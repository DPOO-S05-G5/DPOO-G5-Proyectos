package salvador;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import autenticador.AutenticadorDeUsuarios;
import autenticador.Usuario;
import modelo.CoordinadorPMS;
import modelo.HabitacionEstandar;
import modelo.HabitacionSuite;
import modelo.HabitacionSuiteDoble;
import modelo.Producto;
import modelo.Servicio;

public class SalvadorDeDatos
{
	String nombreArchivoUsuarios;
	HashMap<String, Usuario> mapaUsuarios;
	String nombreArchivoHabitacionesEstandar;
	String nombreArchivoTarifasEstandar;
	String nombreArchivoHabitacionesSuite;
	String nombreArchivoTarifasSuite;
	String nombreArchivoHabitacionesSuiteDoble;
	String nombreArchivoTarifasSuiteDoble;
	String nombreArchivoProductos;
	String nombreArchivoServicios;
	HashMap<String, HabitacionEstandar> mapaHabitacionesEstandar;
	HashMap<String, HabitacionSuite> mapaHabitacionesSuite;
	HashMap<String, HabitacionSuiteDoble> mapaHabitacionesSuiteDoble;
	HashMap<String, Producto> mapaProductos;
	HashMap<String, Servicio> mapaServicios;
	
	
	public SalvadorDeDatos()
	{
		this.nombreArchivoUsuarios = "data/usuarios.xml";
		this.nombreArchivoHabitacionesEstandar = "data/habitacionesEstandar.xml";
		this.nombreArchivoTarifasEstandar = "data/tarifasHabitacionesEstandar.xml";
		this.nombreArchivoHabitacionesSuite = "data/habitacionesSuite.xml";
		this.nombreArchivoTarifasSuite = "data/tarifasHabitacionesSuite.xml";
		this.nombreArchivoHabitacionesSuiteDoble = "data/habitacionesSuiteDoble";
		this.nombreArchivoTarifasSuiteDoble = "data/tarifasHabitacionesSuiteDoble";
		this.nombreArchivoProductos = "data/Productos";
		this.nombreArchivoServicios = "data/Servicios";
	}
	
	public void salvarDatosHotel(AutenticadorDeUsuarios autenticador, CoordinadorPMS coordinadorPMS)
	{
		salvarUsuarios(autenticador);
		salvarHabitacionesEstandar(coordinadorPMS);
		salvarHabitacionesSuite(coordinadorPMS);
		salvarHabitacionesSuiteDoble(coordinadorPMS);
		salvarProductos(coordinadorPMS);
		salvarServicios(coordinadorPMS);
	}
	
	private void salvarHabitacionesEstandar(CoordinadorPMS coordinadorPMS) 
	{
		this.mapaHabitacionesEstandar = coordinadorPMS.getHabitacionesEstandar();
		
		try
		{
			FileOutputStream fos = new FileOutputStream(nombreArchivoTarifasEstandar);
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(HabitacionEstandar.getTarifas());
			encoder.close();
			fos.close();
			
			fos = new FileOutputStream(nombreArchivoHabitacionesEstandar);
			encoder = new XMLEncoder(fos);
			
			if (mapaHabitacionesEstandar != null)
			{
				for (HashMap.Entry<String, HabitacionEstandar> entrada : mapaHabitacionesEstandar.entrySet())
				{
					HabitacionEstandar room = (HabitacionEstandar) entrada.getValue();
					System.out.println(room.getID());
					encoder.writeObject(room);
				}
			}
			encoder.close();
			fos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	private void salvarHabitacionesSuite(CoordinadorPMS coordinadorPMS) 
	{
		this.mapaHabitacionesSuite = coordinadorPMS.getHabitacionesSuite();
		
		try
		{
			FileOutputStream fos = new FileOutputStream(nombreArchivoTarifasSuite);
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(HabitacionSuite.getTarifas());
			encoder.close();
			fos.close();
			
			fos = new FileOutputStream(nombreArchivoHabitacionesSuite);
			encoder = new XMLEncoder(fos);
			
			if (mapaHabitacionesSuite != null)
			{
				for (HashMap.Entry<String, HabitacionSuite> entrada : mapaHabitacionesSuite.entrySet())
				{
					HabitacionSuite room = (HabitacionSuite) entrada.getValue();
					System.out.println(room.getID());
					encoder.writeObject(room);
				}
			}
			encoder.close();
			fos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	private void salvarHabitacionesSuiteDoble(CoordinadorPMS coordinadorPMS) 
	{
		this.mapaHabitacionesSuiteDoble = coordinadorPMS.getHabitacionesSuiteDoble();
		
		try
		{
			FileOutputStream fos = new FileOutputStream(nombreArchivoTarifasSuiteDoble);
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(HabitacionSuiteDoble.getTarifas());
			encoder.close();
			fos.close();
			
			fos = new FileOutputStream(nombreArchivoHabitacionesSuiteDoble);
			encoder = new XMLEncoder(fos);
			
			if (mapaHabitacionesSuiteDoble != null)
			{
				for (HashMap.Entry<String, HabitacionSuiteDoble> entrada : mapaHabitacionesSuiteDoble.entrySet())
				{
					HabitacionSuiteDoble room = (HabitacionSuiteDoble) entrada.getValue();
					System.out.println(room.getID());
					encoder.writeObject(room);
				}
			}
			encoder.close();
			fos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	private void salvarUsuarios(AutenticadorDeUsuarios autenticador)
	{
		this.mapaUsuarios = autenticador.getMapaUsuarios();
		
		try
		{
			FileOutputStream fos = new FileOutputStream(nombreArchivoUsuarios);
			XMLEncoder encoder = new XMLEncoder(fos);
			if (mapaUsuarios != null)
			{
				for (HashMap.Entry<String, Usuario> entrada : mapaUsuarios.entrySet())
				{
					Usuario usuario = (Usuario) entrada.getValue();
					System.out.println(usuario.toString());
					encoder.writeObject(usuario);
				}
			}
			encoder.close();
			fos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void salvarProductos(CoordinadorPMS coordinadorPMS) 
	{
		this.mapaProductos = coordinadorPMS.getProductos();
		
		try
		{
			FileOutputStream fos = new FileOutputStream(nombreArchivoProductos);
			XMLEncoder encoder = new XMLEncoder(fos);
			
			if (mapaProductos != null)
			{
				for (HashMap.Entry<String, Producto> entrada : mapaProductos.entrySet())
				{
					Producto producto = (Producto) entrada.getValue();
					System.out.println(producto.getID());
					encoder.writeObject(producto);
				}
			}
			encoder.close();
			fos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	private void salvarServicios(CoordinadorPMS coordinadorPMS) 
	{
		this.mapaServicios = coordinadorPMS.getServicios();
		
		try
		{
			FileOutputStream fos = new FileOutputStream(nombreArchivoServicios);
			XMLEncoder encoder = new XMLEncoder(fos);
			
			if (mapaServicios != null)
			{
				for (HashMap.Entry<String, Servicio> entrada : mapaServicios.entrySet())
				{
					Servicio servicio = (Servicio) entrada.getValue();
					System.out.println(servicio.getID());
					encoder.writeObject(servicio);
				}
			}
			encoder.close();
			fos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
