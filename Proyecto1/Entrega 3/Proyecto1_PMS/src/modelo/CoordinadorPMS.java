package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import controlador.Controlador;
import salvador.SalvadorDeDatos;

public class CoordinadorPMS
{
	private static final String ESTANDAR = "estandar";
	private static final String SUITE = "suite";
	private static final String SUITE_DOBLE = "suitedoble";
	private Controlador controlador;
	private SalvadorDeDatos salvador;
	private Tarifas tarifas;
	private HashMap<String, Habitacion> mapaHabitaciones;

	public CoordinadorPMS(Controlador controlador)
	{
		this.controlador = controlador;
		this.salvador = new SalvadorDeDatos();

	}
	
	public Tarifas getTarifasHotel()
	{
		return tarifas;
	}

	public void setTarifasHotel(Tarifas tarifasHotel)
	{
		this.tarifas = tarifasHotel;
	}
	
	public void agregarTarifa(String tipo, int valor, ArrayList<Integer> fechaInicial, ArrayList<Integer> fechaFinal, ArrayList<String> diasTarifa)
	{
		ArrayList<Tarifa> tarifasEditadas = tarifas.addTarifa(tipo, valor, fechaInicial, fechaFinal, diasTarifa);
		System.out.println(tarifasEditadas);
		for (Tarifa tarifa : tarifasEditadas)
			salvador.salvarTarifa(tarifa);
	}
	
	public void eliminarTarifas(String tipo, ArrayList<Integer> fechaInicial, ArrayList<Integer> fechaFinal, ArrayList<String> diasTarifa)
	{
		ArrayList<Tarifa> tarifasEditadas = tarifas.removeTarifa(tipo, fechaInicial, fechaFinal, diasTarifa);
		System.out.println(tarifasEditadas);
		for (Tarifa tarifa : tarifasEditadas)
			salvador.salvarTarifa(tarifa);
	}
	
	public ArrayList<String> getFechasSinTarifaStr()
	{
		// TODO dar info de fechas sin tarifa
		ArrayList<String> tarifasSinValor = new ArrayList<String>();
		for (Entry<Fecha, Tarifa> entry : tarifas.getArbolTarifas().entrySet())
		{
			Fecha fecha = entry.getKey();
			HashMap<String, HashMap<String, Integer>> mapaDiasTarifa = entry.getValue().getMapaDiasSemana();
			String infoFecha = "Mes: " + fecha.getMes() + " Dia: " + fecha.getDia();
			
			for (Entry<String, HashMap<String, Integer>> dia : mapaDiasTarifa.entrySet())
			{
				String infoDia = dia.getKey() + ": ";
				HashMap<String, Integer> mapaTarifasTipoHabitacion = dia.getValue();
				
				if (mapaTarifasTipoHabitacion.get(Tarifa.ESTANDAR) == null)
					infoDia += ESTANDAR + ", ";
				if (mapaTarifasTipoHabitacion.get(Tarifa.SUITE) == null)
					infoDia += SUITE + ", ";
				if (mapaTarifasTipoHabitacion.get(Tarifa.SUITE_DOBLE) == null)
					infoDia += SUITE_DOBLE + ", ";
				if (!infoDia.endsWith(": "))
				{
					infoDia = infoDia.substring(0, infoDia.length() - 2);
					infoFecha += "\n" + infoDia + "\n";
				}
			}
			if (!infoFecha.endsWith(": "))
				tarifasSinValor.add(infoFecha);
		}

		return tarifasSinValor;
	}

	public boolean existeHabitacion(String id)
	{
		return mapaHabitaciones.containsKey(id);
	}

	public void putHabitacion(String tipo, boolean cocina, boolean balcon, boolean vista, String torre, int piso,
			String id)
	{
		Habitacion hab;
		if (tipo.equals(ESTANDAR))
			hab = (Habitacion) new HabitacionEstandar(cocina, balcon, vista, torre, piso, id);
		else if (tipo.equals(SUITE))
			hab = (Habitacion) new HabitacionSuite(cocina, balcon, vista, torre, piso, id);
		else
			hab = (Habitacion) new HabitacionSuiteDoble(cocina, balcon, vista, torre, piso, id);
		mapaHabitaciones.put(id, hab);
	}

	public String infoHabitacion(String id)
	{
		Habitacion habitacion = mapaHabitaciones.get(id);
		salvador.salvarHabitacion(habitacion);
		return habitacion.toString();
	}

	public void setHabitaciones(HashMap<String, Habitacion> mapaHabitaciones)
	{
		this.mapaHabitaciones = mapaHabitaciones;		
	}

	public boolean eliminarHabitacion(String id)
	{
		if (mapaHabitaciones.containsKey(id))
		{
			mapaHabitaciones.remove(id);
			salvador.borrarHabitacion(id);
			return true;
		}
		else
			return false;
	}

	public HashMap<String, Habitacion> getHabitaciones()
	{
		return mapaHabitaciones;
	}

	public String catalogoHabitaciones()
	{
		String catalogo = "";
		if (mapaHabitaciones.isEmpty())
			catalogo = "No hay habitaciones";
		else
		{
			ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
			for (Entry<String, Habitacion> entry : mapaHabitaciones.entrySet())
				listaHabitaciones.add(entry.getValue());
			
			Collections.sort(listaHabitaciones, new ComparadorHabitaciones());
			
			for (Habitacion hab : listaHabitaciones)
				catalogo += "\n" + hab.toString();
		}

		return catalogo;
	}

	public ArrayList<Habitacion> getHabitacionesDisponibles(LocalDate initialDate, int numeroDeNoches)
	{
		ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<Habitacion>();
		LocalDate finalDate = initialDate.plusDays(numeroDeNoches);
		
		if (mapaHabitaciones != null)
		{
			for (Entry<String, Habitacion> entryHabitacion : mapaHabitaciones.entrySet())
			{
				Habitacion habitacion = entryHabitacion.getValue();
				HashMap<String, Reserva> reservas = habitacion.getReservas();
				
				if (reservas != null)
				{
					boolean disponible = true;
					
					for (Entry<String, Reserva> entryReserva : reservas.entrySet())
					{
						Reserva reserva = entryReserva.getValue();
						LocalDate initialDateReserva = reserva.getFechaInicial();
						LocalDate finalDateReserva = reserva.getFechaFinal();
						
						if(fechasDentroDeRango(initialDateReserva, finalDateReserva, initialDate, finalDate))
						{
							disponible = false;
							break;
						}
					}
					if (disponible)
					{
						habitacionesDisponibles.add(habitacion);
					}
				}
				else
				{
					habitacionesDisponibles.add(habitacion);
				}
			}
		}
		
		Collections.sort(habitacionesDisponibles, new ComparadorHabitaciones());
		
		return habitacionesDisponibles;
	}
	
	private boolean fechasDentroDeRango(LocalDate fechaInicialRango, LocalDate fechaFinalRango, LocalDate fechaInicial, LocalDate fechaFinal)
	{
		boolean fechaFinalDentroDeReserva = (fechaFinal.isBefore(fechaFinalRango) && fechaFinal.isAfter(fechaInicialRango)) || fechaFinal.isEqual(fechaInicialRango) || fechaFinal.isEqual(fechaFinalRango);
		boolean fechaInicialDentroDeReserva = (fechaInicial.isBefore(fechaFinalRango) && fechaInicial.isAfter(fechaInicialRango)) || fechaInicial.isEqual(fechaInicialRango) || fechaInicial.isEqual(fechaFinalRango);
		boolean rangoDentroDeFechas = fechaFinal.isAfter(fechaFinalRango) && fechaInicial.isBefore(fechaInicialRango);
		
		return fechaFinalDentroDeReserva || fechaInicialDentroDeReserva || rangoDentroDeFechas;
	}
}
