package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class CoordinadorPMS {
	
	private HashMap<String, HabitacionEstandar> mapaHabitacionesEstandar;
	private HashMap<String, HabitacionSuite> mapaHabitacionesSuite;
	private HashMap<String, HabitacionSuiteDoble> mapaHabitacionesSuiteDoble;
	private HashMap<String, Producto> mapaProductos;
	private HashMap<String, Servicio> mapaServicios;
	private HashMap<Integer, Integer> mapaDiasMes;
	private ArrayList<String> listaDiasSemana;
	private HashMap<Integer, String> mapaDiasSemana;
	private HashMap<String, Reserva> mapaReservas;
	
	public CoordinadorPMS()
	{
		this.mapaDiasMes = new HashMap<Integer, Integer>();
		int[] diasMes = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i=0; i<12; i++)
		{
			mapaDiasMes.put(i, diasMes[i]);
		}
		
		this.listaDiasSemana = new ArrayList<String>();
		this.mapaDiasSemana = new HashMap<Integer, String>();
		
		listaDiasSemana.add("D");
		listaDiasSemana.add("L");
		listaDiasSemana.add("M");
		listaDiasSemana.add("I");
		listaDiasSemana.add("J");
		listaDiasSemana.add("V");
		listaDiasSemana.add("S");
		
		for (int i=0; i<7; i++)
		{
			mapaDiasSemana.put(i, listaDiasSemana.get(i));
		}
	}
	
	
	public HashMap<String, HabitacionEstandar> getHabitacionesEstandar() 
	{
		return mapaHabitacionesEstandar;
	}
	
	public HashMap<String, Servicio> getServicios() {
		return mapaServicios;
	}

	public void setServicios(HashMap<String, Servicio> servicio) {
		this.mapaServicios = servicio;
		
	}
	
	public void addServicio(Servicio servicio)
	{
		String id = servicio.getID();
		this.mapaServicios.put(id, servicio);
	}

	public void setHabitacionesEstandar(HashMap<String, HabitacionEstandar> habitacionesEstandar)
	{
		this.mapaHabitacionesEstandar = habitacionesEstandar;
	}
	
	public void addHabitacionEstandar(HabitacionEstandar habitacion)
	{
		String id = habitacion.getID();
		this.mapaHabitacionesEstandar.put(id, habitacion);
	}
	
	public HashMap<String, HabitacionSuite> getHabitacionesSuite()
	{
		return mapaHabitacionesSuite;
	}
	
	public void setHabitacionesSuite(HashMap<String, HabitacionSuite> habitacionesSuite)
	{
		this.mapaHabitacionesSuite = habitacionesSuite;
	}
	
	public void addHabitacionSuite(HabitacionSuite habitacion)
	{
		String id = habitacion.getID();
		this.mapaHabitacionesSuite.put(id, habitacion);
	}
	
	public HashMap<String, HabitacionSuiteDoble> getHabitacionesSuiteDoble()
	{
		return mapaHabitacionesSuiteDoble;
	}
	
	public void setHabitacionesSuiteDoble(HashMap<String, HabitacionSuiteDoble> habitacionesSuiteDoble)
	{
		this.mapaHabitacionesSuiteDoble = habitacionesSuiteDoble;
	}
	
	public void addHabitacionSuiteDoble(HabitacionSuiteDoble habitacion)
	{
		String id = habitacion.getID();
		this.mapaHabitacionesSuiteDoble.put(id, habitacion);
	}
	
	
	public HashMap<String, Producto> getProductos() 
	{
		return mapaProductos;
	}
	
	public void setProductos(HashMap<String, Producto> producto)
	{
		this.mapaProductos = producto ;
	}
	
	public void addProducto(Producto producto)
	{
		String id = producto.getID();
		this.mapaProductos.put(id, producto);
	}

	public String addHabitacion(String tipoHabitacion, boolean tieneCocina, boolean tieneBalcon, boolean tieneVista, String torre, int piso, String id)
	{
		String infoHabitacion = "";
		
		if (tipoHabitacion.equals("estandar"))
		{
			HabitacionEstandar habitacion = new HabitacionEstandar(tieneCocina, tieneBalcon, tieneVista, torre, piso, id);
			mapaHabitacionesEstandar.put(id, habitacion);
			infoHabitacion = habitacion.toString();
		}
		else if (tipoHabitacion.equals("suite"))
		{
			HabitacionSuite habitacion = new HabitacionSuite(tieneCocina, tieneBalcon, tieneVista, torre, piso, id);
			mapaHabitacionesSuite.put(id, habitacion);
			infoHabitacion = habitacion.toString();
		}
		else if (tipoHabitacion.equals("suitedoble"))
		{
			HabitacionSuiteDoble habitacion = new HabitacionSuiteDoble(tieneCocina, tieneBalcon, tieneVista, torre, piso, id);
			mapaHabitacionesSuiteDoble.put(id,  habitacion);
			infoHabitacion = habitacion.toString();
		}
		return infoHabitacion;
	}

	public void addTarifa(String tipoHabitacion, ArrayList<Integer> listaFechaI, ArrayList<Integer> listaFechaF, ArrayList<Integer> dias, int valor)
	{
		if (listaFechaI.get(0).equals(listaFechaF.get(0)))
			addTarifaMismoMes(tipoHabitacion, listaFechaI, listaFechaF, dias, valor);
		else
			addTarifaDifMes(tipoHabitacion, listaFechaI, listaFechaF, dias, valor);
	}
	
	private void addTarifaDifMes(String tipoHabitacion, ArrayList<Integer> listaFechaI, ArrayList<Integer> listaFechaF,
			ArrayList<Integer> dias, int valor) 
	{
		int mesI = listaFechaI.get(0);
		int diaI = listaFechaI.get(1);
		int mesF = listaFechaF.get(0);
		int diaF = listaFechaF.get(1);
		
		for (int diaMes=diaI; diaMes < mapaDiasMes.get(mesI) ; diaMes++)
		{
			for (int dia : dias)
			{
				if (tipoHabitacion.equals("estandar"))
				{
					HabitacionEstandar.addTarifa(mesI, diaMes, dia, valor);
				}
				else if (tipoHabitacion.equals("suite"))
				{
					HabitacionSuite.addTarifa(mesI, diaMes, dia, valor);
				}
				else
				{
					HabitacionSuiteDoble.addTarifa(mesI, diaMes, dia, valor);
				}
			}
		}
		
		for (int diaMes=0; diaMes<=diaF; diaMes++)
		{
			for (int dia : dias)
			{
				if (tipoHabitacion.equals("estandar"))
				{
					HabitacionEstandar.addTarifa(mesF, diaMes, dia, valor);
				}
				else if (tipoHabitacion.equals("suite"))
				{
					HabitacionSuite.addTarifa(mesF, diaMes, dia, valor);
				}
				else
				{
					HabitacionSuiteDoble.addTarifa(mesF, diaMes, dia, valor);
				}
			}
		}
		
	}

	private void addTarifaMismoMes(String tipoHabitacion, ArrayList<Integer> listaFechaI,
			ArrayList<Integer> listaFechaF, ArrayList<Integer> dias, int valor) 
	{
		int mes = listaFechaI.get(0);
		int diaI = listaFechaI.get(1);
		int diaF = listaFechaF.get(1);
		
		for (int diaMes=diaI; diaMes<=diaF; diaMes++)
		{
			for (int dia : dias)
			{
				if (tipoHabitacion.equals("estandar"))
					HabitacionEstandar.addTarifa(mes, diaMes, dia, valor);
				else if (tipoHabitacion.equals("suite"))
					HabitacionSuite.addTarifa(mes, diaMes, dia, valor);
				else
					HabitacionSuiteDoble.addTarifa(mes, diaMes, dia, valor);
			}
		}
	}

	public void eliminarTarifa(String tipoHabitacion, ArrayList<Integer> listaFechaI, ArrayList<Integer> listaFechaF,
			ArrayList<Integer> dias)
	{
		if (listaFechaI.get(0).equals(listaFechaF.get(0)))
			eliminarTarifaMismoMes(tipoHabitacion, listaFechaI, listaFechaF, dias);
		else
			eliminarTarifaDifMes(tipoHabitacion, listaFechaI, listaFechaF, dias);
	
	}


	private void eliminarTarifaDifMes(String tipoHabitacion, ArrayList<Integer> listaFechaI,
			ArrayList<Integer> listaFechaF, ArrayList<Integer> dias)
	{

		int mesI = listaFechaI.get(0);
		int diaI = listaFechaI.get(1);
		int mesF = listaFechaF.get(0);
		int diaF = listaFechaF.get(1);
		
		for (int diaMes=diaI; diaMes < mapaDiasMes.get(mesI) ; diaMes++)
		{
			for (int dia : dias)
			{
				if (tipoHabitacion.equals("estandar"))
				{
					HabitacionEstandar.removeTarifa(mesI, diaMes, dia);
				}
				else if (tipoHabitacion.equals("suite"))
				{
					HabitacionSuite.removeTarifa(mesI, diaMes, dia);
				}
				else
				{
					HabitacionSuiteDoble.removeTarifa(mesI, diaMes, dia);
				}
			}
		}
		
		for (int diaMes=0; diaMes<=diaF; diaMes++)
		{
			for (int dia : dias)
			{
				if (tipoHabitacion.equals("estandar"))
				{
					HabitacionEstandar.removeTarifa(mesF, diaMes, dia);
				}
				else if (tipoHabitacion.equals("suite"))
				{
					HabitacionSuite.removeTarifa(mesF, diaMes, dia);
				}
				else
				{
					HabitacionSuiteDoble.removeTarifa(mesF, diaMes, dia);
				}
			}
		}
	}

	private void eliminarTarifaMismoMes(String tipoHabitacion, ArrayList<Integer> listaFechaI,
			ArrayList<Integer> listaFechaF, ArrayList<Integer> dias)
	{
		int mes = listaFechaI.get(0);
		int diaI = listaFechaI.get(1);
		int diaF = listaFechaF.get(1);
		
		for (int diaMes=diaI; diaMes<=diaF; diaMes++)
		{
			for (int dia : dias)
			{
				if (tipoHabitacion.equals("estandar"))
					HabitacionEstandar.removeTarifa(mes, diaMes, dia);
				else if (tipoHabitacion.equals("suite"))
					HabitacionSuite.removeTarifa(mes, diaMes, dia);
				else
					HabitacionSuiteDoble.removeTarifa(mes, diaMes, dia);
			}
		}
		
	}


	public String revisarTarifas() 
	{
		String textoFinal = "";
		
		ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifasEstandar = HabitacionEstandar.getTarifas();
		ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifasSuite = HabitacionSuite.getTarifas();
		ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifasSuiteDoble = HabitacionSuiteDoble.getTarifas();
		
		for (int mes=0; mes<12; mes++)
		{
			ArrayList<ArrayList<ArrayList<Integer>>> diasMes = tarifasEstandar.get(mes);
			
			for (int diaMes=0; diaMes<diasMes.size(); diaMes++)
			{
				ArrayList<ArrayList<Integer>> diasSemana = diasMes.get(diaMes);
				ArrayList<String> diasSemanaSinTarifa = new ArrayList<String>();
				for (int diaSemana=0; diaSemana<diasSemana.size(); diaSemana++)
				{
					ArrayList<Integer> listaDia = diasSemana.get(diaSemana);
					if (listaDia.isEmpty())
					{
						diasSemanaSinTarifa.add(mapaDiasSemana.get(diaSemana));
					}
				}
				if (diasSemanaSinTarifa != null)
				{
					textoFinal += addFechaSinTarifa(mes, diaMes, diasSemanaSinTarifa);
				}
			}
		}
		
		for (int mes=0; mes<12; mes++)
		{
			ArrayList<ArrayList<ArrayList<Integer>>> diasMes = tarifasSuite.get(mes);
			
			for (int diaMes=0; diaMes<diasMes.size(); diaMes++)
			{
				ArrayList<ArrayList<Integer>> diasSemana = diasMes.get(diaMes);
				ArrayList<String> diasSemanaSinTarifa = new ArrayList<String>();
				for (int diaSemana=0; diaSemana<diasSemana.size(); diaSemana++)
				{
					ArrayList<Integer> listaDia = diasSemana.get(diaSemana);
					if (listaDia.isEmpty())
					{
						diasSemanaSinTarifa.add(mapaDiasSemana.get(diaSemana));
					}
				}
				if (diasSemanaSinTarifa != null)
				{
					textoFinal += addFechaSinTarifa(mes, diaMes, diasSemanaSinTarifa);
				}
			}
		}
		
		for (int mes=0; mes<12; mes++)
		{
			ArrayList<ArrayList<ArrayList<Integer>>> diasMes = tarifasSuiteDoble.get(mes);
			
			for (int diaMes=0; diaMes<diasMes.size(); diaMes++)
			{
				ArrayList<ArrayList<Integer>> diasSemana = diasMes.get(diaMes);
				ArrayList<String> diasSemanaSinTarifa = new ArrayList<String>();
				for (int diaSemana=0; diaSemana<diasSemana.size(); diaSemana++)
				{
					ArrayList<Integer> listaDia = diasSemana.get(diaSemana);
					if (listaDia.isEmpty())
					{
						diasSemanaSinTarifa.add(mapaDiasSemana.get(diaSemana));
					}
				}
				if (diasSemanaSinTarifa != null)
				{
					textoFinal += addFechaSinTarifa(mes, diaMes, diasSemanaSinTarifa);
				}
			}
		}
		
		return textoFinal;
	}


	private String addFechaSinTarifa(int mes, int diaMes, ArrayList<String> diasSemana) 
	{
		return "Mes: " + (mes+1) + " | Dia: " + (diaMes+1) + " | Dias de la semana: " + diasSemana + "\n";
	}


	public ArrayList<Habitacion> getHabitacionesDesocupadas(int numeroDeNoches, LocalDate fechaInicial)
	{
		LocalDate fechaFinal = fechaInicial.plusDays(numeroDeNoches);
		ArrayList<Habitacion> habitacionesDesocupadas = new ArrayList<Habitacion>();
		
		if (mapaHabitacionesEstandar != null)
		{
			for (Entry<String, HabitacionEstandar> entradaHabitacion : mapaHabitacionesEstandar.entrySet())
			{
				Habitacion habitacion = (Habitacion) entradaHabitacion.getValue();
				HashMap<String, Reserva> reservas = habitacion.getReservas();
				if (reservas != null)
				{
					boolean desocupada = true;
					for (Entry<String, Reserva> entradaReserva : reservas.entrySet())
					{
						Reserva reserva = entradaReserva.getValue();
						LocalDate fechaI = reserva.getFechaInicial();
						LocalDate fechaF = reserva.getFechaFinal();
						
						if (fechasDentroDeRango(fechaI, fechaF, fechaInicial, fechaFinal))
						{
							desocupada = false;
							break;
						}
					}
					if (desocupada)
					{
						habitacionesDesocupadas.add(habitacion);
					}
				}	
			}
		}
		if (mapaHabitacionesSuite != null)
		{
			for (Entry<String, HabitacionSuite> entrada : mapaHabitacionesSuite.entrySet())
			{
				Habitacion habitacion = (Habitacion) entrada.getValue();
				HashMap<String, Reserva> reservas = habitacion.getReservas();
				if (reservas != null)
				{
					boolean desocupada = true;
					for (Entry<String, Reserva> entradaReserva : reservas.entrySet())
					{
						Reserva reserva = entradaReserva.getValue();
						LocalDate fechaI = reserva.getFechaInicial();
						LocalDate fechaF = reserva.getFechaFinal();
						
						if (fechasDentroDeRango(fechaI, fechaF, fechaInicial, fechaFinal))
						{
							desocupada = false;
							break;
						}
					}
					if (desocupada)
					{
						habitacionesDesocupadas.add(habitacion);
					}
				}
			}
		}
		if (mapaHabitacionesSuiteDoble != null)
		{
			for (Entry<String, HabitacionSuiteDoble> entrada : mapaHabitacionesSuiteDoble.entrySet())
			{
				Habitacion habitacion = (Habitacion) entrada.getValue();
				HashMap<String, Reserva> reservas = habitacion.getReservas();
				if (reservas != null)
				{
					boolean desocupada = true;
					for (Entry<String, Reserva> entradaReserva : reservas.entrySet())
					{
						Reserva reserva = entradaReserva.getValue();
						LocalDate fechaI = reserva.getFechaInicial();
						LocalDate fechaF = reserva.getFechaFinal();
						
						if (fechasDentroDeRango(fechaI, fechaF, fechaInicial, fechaFinal))
						{
							desocupada = false;
							break;
						}
					}
					if (desocupada)
					{
						habitacionesDesocupadas.add(habitacion);
					}
				}
			}
		}
		
		Collections.sort(habitacionesDesocupadas, new ComparadorHabitaciones());
		
		return habitacionesDesocupadas;
	}
	
	private boolean fechasDentroDeRango(LocalDate fechaInicialRango, LocalDate fechaFinalRango, LocalDate fechaInicial, LocalDate fechaFinal)
	{
		boolean fechaFinalDentroDeReserva = (fechaFinal.isBefore(fechaFinalRango) && fechaFinal.isAfter(fechaInicialRango)) || fechaFinal.isEqual(fechaInicialRango) || fechaFinal.isEqual(fechaFinalRango);
		boolean fechaInicialDentroDeReserva = (fechaInicial.isBefore(fechaFinalRango) && fechaInicial.isAfter(fechaInicialRango)) || fechaInicial.isEqual(fechaInicialRango) || fechaInicial.isEqual(fechaFinalRango);
		boolean fechaReservaDentroDeRango = fechaFinal.isAfter(fechaFinalRango) && fechaInicial.isBefore(fechaInicialRango);
		
		return fechaFinalDentroDeReserva || fechaInicialDentroDeReserva || fechaReservaDentroDeRango;
	}


	public Reserva getReserva(String idHuesped)
	{		
		return mapaReservas.get(idHuesped);
	}


	public HashMap<String, Reserva> getMapaReservas()
	{
		return mapaReservas;
	}


	public void setMapaReservas(HashMap<String, Reserva> mapaReservas)
	{
		this.mapaReservas = mapaReservas;
	}

}
