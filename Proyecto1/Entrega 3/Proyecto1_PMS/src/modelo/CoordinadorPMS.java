package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class CoordinadorPMS {
	
	private HashMap<String, HabitacionEstandar> habitacionesEstandar;
	private HashMap<String, HabitacionSuite> habitacionesSuite;
	private HashMap<String, HabitacionSuiteDoble> habitacionesSuiteDoble;
	private HashMap<String, Producto> producto;
	private HashMap<String, Servicio> servicio;
	
	
	public HashMap<String, HabitacionEstandar> getHabitacionesEstandar() 
	{
		return habitacionesEstandar;
	}
	
	public HashMap<String, Servicio> getServicio() {
		return servicio;
	}

	public void setServicio(HashMap<String, Servicio> servicio) {
		this.servicio = servicio;
		
	}
	
	public void addServicio(Servicio servicio)
	{
		String id = servicio.getID();
		this.servicio.put(id, servicio);
	}

	public void setHabitacionesEstandar(HashMap<String, HabitacionEstandar> habitacionesEstandar)
	{
		this.habitacionesEstandar = habitacionesEstandar;
	}
	
	public void addHabitacionEstandar(HabitacionEstandar habitacion)
	{
		String id = habitacion.getID();
		this.habitacionesEstandar.put(id, habitacion);
	}
	
	public HashMap<String, HabitacionSuite> getHabitacionesSuite()
	{
		return habitacionesSuite;
	}
	
	public void setHabitacionesSuite(HashMap<String, HabitacionSuite> habitacionesSuite)
	{
		this.habitacionesSuite = habitacionesSuite;
	}
	
	public void addHabitacionSuite(HabitacionSuite habitacion)
	{
		String id = habitacion.getID();
		this.habitacionesSuite.put(id, habitacion);
	}
	
	public HashMap<String, HabitacionSuiteDoble> getHabitacionesSuiteDoble()
	{
		return habitacionesSuiteDoble;
	}
	
	public void setHabitacionesSuiteDoble(HashMap<String, HabitacionSuiteDoble> habitacionesSuiteDoble)
	{
		this.habitacionesSuiteDoble = habitacionesSuiteDoble;
	}
	
	public void addHabitacionSuiteDoble(HabitacionSuiteDoble habitacion)
	{
		String id = habitacion.getID();
		this.habitacionesSuiteDoble.put(id, habitacion);
	}
	
	
	public HashMap<String, Producto> getProducto() 
	{
		return producto;
	}
	
	public void setProducto(HashMap<String, Producto> producto)
	{
		this.producto = producto ;
	}
	
	public void addProducto(Producto producto)
	{
		String id = producto.getID();
		this.producto.put(id, producto);
	}

	public void addHabitacion(String tipoHabitacion, boolean tieneCocina, boolean tieneBalcon, boolean tieneVista, String torre, int piso, String id)
	{
		if (tipoHabitacion.equals("estandar"))
		{
			HabitacionEstandar habitacion = new HabitacionEstandar(tieneCocina, tieneBalcon, tieneVista, torre, piso, id);
			habitacionesEstandar.put(id, habitacion);
		}
		else if (tipoHabitacion.equals("suite"))
		{
			HabitacionSuite habitacion = new HabitacionSuite(tieneCocina, tieneBalcon, tieneVista, torre, piso, id);
			habitacionesSuite.put(id, habitacion);
		}
		else if (tipoHabitacion.equals("suitedoble"))
		{
			HabitacionSuiteDoble habitacion = new HabitacionSuiteDoble(tieneCocina, tieneBalcon, tieneVista, torre, piso, id);
			habitacionesSuiteDoble.put(id,  habitacion);
		}
	}

	public void addTarifa(String tipoHabitacion, ArrayList<Integer> listaFechaI, ArrayList<Integer> listaFechaF, ArrayList<Integer> dias, int valor)
	{
		if (listaFechaI.get(0).equals(listaFechaF.get(0)))
			addTarifaMismoMes(tipoHabitacion, listaFechaI, listaFechaF, dias, valor);
		else
			addTarifaDifMes(tipoHabitacion, listaFechaI, listaFechaF, dias, valor);
		
		if (tipoHabitacion.equals("estandar"))
			{
				HabitacionEstandar.addTarifa(valor, valor, valor, valor);
			}
			else if (tipoHabitacion.equals("suite"))
			{
				HabitacionSuite.addTarifa(valor, valor, valor, valor);
			}
			else
			{
				HabitacionSuiteDoble.addTarifa(valor, valor, valor, valor);
			}	
	}
	
	private void addTarifaDifMes(String tipoHabitacion, ArrayList<Integer> listaFechaI, ArrayList<Integer> listaFechaF,
			ArrayList<Integer> dias, int valor) 
	{
		// TODO Auto-generated method stub
		
	}

	private void addTarifaMismoMes(String tipoHabitacion, ArrayList<Integer> listaFechaI,
			ArrayList<Integer> listaFechaF, ArrayList<Integer> dias, int valor) 
	{
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> getTarifas(String tipoHabitacion)
	{
		if (tipoHabitacion.equals("estandar"))
		{
			return HabitacionEstandar.getTarifas();
		}
		else if (tipoHabitacion.equals("suite"))
		{
			return HabitacionSuite.getTarifas();
		}
		else
		{
			return HabitacionSuiteDoble.getTarifas();
		}
	}

	public void cambiarDiasSemanaTarifa(String tipoHabitacion, ArrayList<Integer> dias) 
	{
		// TODO Auto-generated method stub
		
	}

	public void eliminarTarifa(int tarifaSeleccionada) 
	{
		// TODO Auto-generated method stub
		
	}

}
