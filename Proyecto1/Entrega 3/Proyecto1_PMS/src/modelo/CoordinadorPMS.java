package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class CoordinadorPMS {
	
	private HashMap<String, HabitacionEstandar> habitacionesEstandar;
	private HashMap<String, HabitacionSuite> habitacionesSuite;
	private HashMap<String, HabitacionSuiteDoble> habitacionesSuiteDoble;
	private HashMap<String, Producto> producto;
	
	
	public HashMap<String, HabitacionEstandar> getHabitacionesEstandar() 
	{
		return habitacionesEstandar;
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
	
	

}
