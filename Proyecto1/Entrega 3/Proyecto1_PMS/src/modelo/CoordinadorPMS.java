package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class CoordinadorPMS {
	
	private static final String SUITEDOBLE = "suitedoble";
	private static final String SUITE = "suite";
	private static final String ESTANDAR = "estandar";
	private HashMap<String, HabitacionEstandar> mapaHabitacionesEstandar;
	private HashMap<String, HabitacionSuite> mapaHabitacionesSuite;
	private HashMap<String, HabitacionSuiteDoble> mapaHabitacionesSuiteDoble;
	private HashMap<String, Producto> mapaProductos;
	private HashMap<String, Servicio> mapaServicios;
	private HashMap<Integer, Integer> mapaDiasMes;
	private ArrayList<String> listaDiasSemana;
	private HashMap<Integer, String> mapaDiasSemana;
	private HashMap<String, Reserva> mapaReservas;
	private HashMap<String, Huesped> mapaHuespedes;
	
	public CoordinadorPMS()
	{
		this.mapaHabitacionesEstandar = new HashMap<String, HabitacionEstandar>();
		this.mapaHabitacionesSuite = new HashMap<String, HabitacionSuite>();
		this.mapaHabitacionesSuiteDoble = new HashMap<String, HabitacionSuiteDoble>();
		this.mapaProductos = new HashMap<String, Producto>();
		this.mapaServicios = new HashMap<String, Servicio>();
		this.mapaDiasMes = new HashMap<Integer, Integer>();
		
		int[] diasMes = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i=0; i<12; i++)
		{
			mapaDiasMes.put(i, diasMes[i]);
		}
		
		this.listaDiasSemana = new ArrayList<String>();
		this.mapaDiasSemana = new HashMap<Integer, String>();
		
		listaDiasSemana.add("L");
		listaDiasSemana.add("M");
		listaDiasSemana.add("I");
		listaDiasSemana.add("J");
		listaDiasSemana.add("V");
		listaDiasSemana.add("S");
		listaDiasSemana.add("D");
		
		for (int i=0; i<7; i++)
		{
			mapaDiasSemana.put(i, listaDiasSemana.get(i));
		}
		
		this.mapaReservas = new HashMap<String, Reserva>();
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
		String id = habitacion.getId();
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
		String id = habitacion.getId();
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
		String id = habitacion.getId();
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
		
		if (tipoHabitacion.equals(ESTANDAR))
		{
			HabitacionEstandar habitacion = new HabitacionEstandar(tieneCocina, tieneBalcon, tieneVista, torre, piso, id);
			mapaHabitacionesEstandar.put(id, habitacion);
			infoHabitacion = habitacion.toString();
		}
		else if (tipoHabitacion.equals(SUITE))
		{
			HabitacionSuite habitacion = new HabitacionSuite(tieneCocina, tieneBalcon, tieneVista, torre, piso, id);
			mapaHabitacionesSuite.put(id, habitacion);
			infoHabitacion = habitacion.toString();
		}
		else if (tipoHabitacion.equals(SUITEDOBLE))
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
				if (tipoHabitacion.equals(ESTANDAR))
				{
					HabitacionEstandar.addTarifa(mesI, diaMes, dia, valor);
				}
				else if (tipoHabitacion.equals(SUITE))
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
				if (tipoHabitacion.equals(ESTANDAR))
				{
					HabitacionEstandar.addTarifa(mesF, diaMes, dia, valor);
				}
				else if (tipoHabitacion.equals(SUITE))
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
				if (tipoHabitacion.equals(ESTANDAR))
					HabitacionEstandar.addTarifa(mes, diaMes, dia, valor);
				else if (tipoHabitacion.equals(SUITE))
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
				if (tipoHabitacion.equals(ESTANDAR))
				{
					HabitacionEstandar.removeTarifa(mesI, diaMes, dia);
				}
				else if (tipoHabitacion.equals(SUITE))
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
				if (tipoHabitacion.equals(ESTANDAR))
				{
					HabitacionEstandar.removeTarifa(mesF, diaMes, dia);
				}
				else if (tipoHabitacion.equals(SUITE))
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
				if (tipoHabitacion.equals(ESTANDAR))
					HabitacionEstandar.removeTarifa(mes, diaMes, dia);
				else if (tipoHabitacion.equals(SUITE))
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


	public LinkedHashMap<Integer, Habitacion> getHabitacionesDesocupadas(int numeroDeNoches, LocalDate fechaInicial)
	{
		LocalDate fechaFinal = fechaInicial.plusDays(numeroDeNoches);
		ArrayList<Habitacion> listaHabitacionesDesocupadas = new ArrayList<Habitacion>();
		
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
						listaHabitacionesDesocupadas.add(habitacion);
					}
				}
				else
					listaHabitacionesDesocupadas.add(habitacion);
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
						listaHabitacionesDesocupadas.add(habitacion);
					}
				}
				else
					listaHabitacionesDesocupadas.add(habitacion);
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
						listaHabitacionesDesocupadas.add(habitacion);
					}
				}
				else
					listaHabitacionesDesocupadas.add(habitacion);
			}
		}
		
		LinkedHashMap<Integer, Habitacion> mapaHabitacionesDesocupadas = new LinkedHashMap<Integer, Habitacion>();
		if (listaHabitacionesDesocupadas != null)
		{
			Collections.sort(listaHabitacionesDesocupadas, new ComparadorHabitaciones());
			int i = 1;
			for (Habitacion hab : listaHabitacionesDesocupadas)
			{
				mapaHabitacionesDesocupadas.put(i, hab);
				i++;
			}
		}
		
		return mapaHabitacionesDesocupadas;
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


	public void addHuesped(boolean isAdulto, String tipoHabitacion, String idHabitacion, String nombre,
			String apellidos, String idHuesped)
	{
		if (isAdulto)
		{
			if (tipoHabitacion.equals(ESTANDAR))
			{
				HabitacionEstandar habitacion = mapaHabitacionesEstandar.get(idHabitacion);
				Huesped huesped = new Huesped(idHuesped, nombre, apellidos, idHabitacion);
				habitacion.addHuespedAdulto(huesped);
				mapaHuespedes.put(huesped.getId(), huesped);
			}
			else if (tipoHabitacion.equals(SUITE))
			{
				HabitacionSuite habitacion = mapaHabitacionesSuite.get(idHabitacion);
				Huesped huesped = new Huesped(idHuesped, nombre, apellidos, idHabitacion);
				habitacion.addHuespedAdulto(huesped);
			}
			else
			{
				HabitacionSuiteDoble habitacion = mapaHabitacionesSuiteDoble.get(idHabitacion);
				Huesped huesped = new Huesped(idHuesped, nombre, apellidos, idHabitacion);
				habitacion.addHuespedAdulto(huesped);
				mapaHuespedes.put(huesped.getId(), huesped);
			}
		}
		else
		{
			if (tipoHabitacion.equals(ESTANDAR))
			{
				HabitacionEstandar habitacion = mapaHabitacionesEstandar.get(idHabitacion);
				Huesped huesped = new Huesped(idHuesped, nombre, apellidos, idHabitacion);
				habitacion.addHuespedNinio(huesped);
				mapaHuespedes.put(huesped.getId(), huesped);
			}
			else if (tipoHabitacion.equals(SUITE))
			{
				HabitacionSuite habitacion = mapaHabitacionesSuite.get(idHabitacion);
				Huesped huesped = new Huesped(idHuesped, nombre, apellidos, idHabitacion);
				habitacion.addHuespedNinio(huesped);
			}
			else
			{
				HabitacionSuiteDoble habitacion = mapaHabitacionesSuiteDoble.get(idHabitacion);
				Huesped huesped = new Huesped(idHuesped, nombre, apellidos, idHabitacion);
				habitacion.addHuespedNinio(huesped);
			}
		}
		
	}


	public void addHuespedResponsable(String tipoHabitacion, String idHabitacion, String nombres,
			String apellidos, String idHuesped, String correo, String numeroCelular)
	{
		HabitacionEstandar habitacion = mapaHabitacionesEstandar.get(idHabitacion);
		Huesped huesped = new Huesped(idHuesped, nombres, apellidos, correo, numeroCelular, idHabitacion);
		habitacion.addHuespedAdulto(huesped);
		mapaHuespedes.put(huesped.getId(), huesped);
		
	}
	
	public Huesped addHuespedResponsable(String nombre, String apellidos, String idHuesped, String correo, String celular)
	{
		Huesped huesped = new Huesped(nombre, apellidos, correo, celular);
		mapaHuespedes.put(huesped.getId(), huesped);
		return huesped;
	}


	public void addReserva(Huesped huesped, int numHuespedes, int noches, LocalDate fechaInicial)
	{
		mapaReservas.put(huesped.getId(), new Reserva(huesped, numHuespedes, noches, fechaInicial));
		
	}
	
	public void cancelarReserva(Huesped huesped)
	{
		mapaReservas.remove(huesped.getId());	
	}
	
	public void realizarTextoFactura(Huesped huesped)
	{
		String textoFactura = "";
		return textoFactura;	
	}


	public Habitacion getHabitacion(String tipo, String id)
	{
		// TODO Auto-generated method stub
		if (tipo.equals(ESTANDAR))
		{
			return mapaHabitacionesEstandar.get(id);
		}
		else if (tipo.equals(SUITE))
		{
			return mapaHabitacionesSuite.get(id);
		}
		else
		{
			return mapaHabitacionesSuiteDoble.get(id);
		}
		
	}


	public HashMap<String, Huesped> getMapaHuespedes()
	{
		return mapaHuespedes;
	}


	public void setMapaHuespedes(HashMap<String, Huesped> mapaHuespedes)
	{
		this.mapaHuespedes = mapaHuespedes;
	}


	public Huesped getHuesped(String idHuesped)
	{
		return mapaHuespedes.get(idHuesped);
	}
	
	

}
