package cargador;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import autenticador.AutenticadorDeUsuarios;
import autenticador.Usuario;
import modelo.CoordinadorPMS;
import modelo.HabitacionEstandar;
import modelo.HabitacionSuite;
import modelo.HabitacionSuiteDoble;
import modelo.Producto;

public class CargadorDeDatos
{
	String nombreArchivoUsuarios;
	HashMap<String, Usuario> mapaUsuarios;
	HashMap<String, HabitacionEstandar> mapaHabitacionesEstandar;
	HashMap<String, HabitacionSuite> mapaHabitacionesSuite;
	HashMap<String, HabitacionSuiteDoble> mapaHabitacionesSuiteDoble;
	HashMap<String, Producto> mapaProducto;
	
	public CargadorDeDatos()
	{
		this.nombreArchivoUsuarios = "data/usuarios.xml";
		this.mapaUsuarios = new HashMap<String, Usuario>();
		this.mapaHabitacionesEstandar = new HashMap<String, HabitacionEstandar>();
		this.mapaHabitacionesSuite = new HashMap<String, HabitacionSuite>();
		this.mapaHabitacionesSuiteDoble = new HashMap<String, HabitacionSuiteDoble>();
		this.mapaProducto = new HashMap<String, Producto>();
	}
	
	public void cargarDatosHotel(AutenticadorDeUsuarios autenticador, CoordinadorPMS coordinadorPMS)
	{
		cargarUsuarios(autenticador);
		cargarHabitaciones(coordinadorPMS);
		cargarProductos(coordinadorPMS);
	
	}

	private void cargarHabitaciones(CoordinadorPMS coordinadorPMS) 
	{
		
		cargarHabitacionesEstandar(coordinadorPMS);
		cargarHabitacionesSuite(coordinadorPMS);
		cargarHabitacionesSuiteDoble(coordinadorPMS);
		
	}


	private void cargarHabitacionesEstandar(CoordinadorPMS coordinadorPMS) 
	{
		try
		{
			Object obj;
			FileInputStream fis = new FileInputStream("data/tarifasHabitacionesEstandar.xml");
			XMLDecoder decoder = new XMLDecoder(fis);
			
			obj = decoder.readObject();
			if (obj instanceof ArrayList)
			{
				HabitacionEstandar.setTarifas((ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>) obj);
			}
			else
			{
				System.err.println("No esta la lista en el archivo");
			}
			decoder.close();
			fis.close();
			
			fis = new FileInputStream("data/habitacionesEstandar.xml");
			decoder = new XMLDecoder(fis);
			
			while (true)
			{
				try
				{
					obj = decoder.readObject();
					
					if (obj instanceof HabitacionEstandar)
					{
						HabitacionEstandar room = (HabitacionEstandar) obj;
						String id = room.getID();
						mapaHabitacionesEstandar.put(id, room);
					}
					else
					{
						System.err.println("objecto inesperado en el archivo");
					}
				}
				catch (ArrayIndexOutOfBoundsException e3)
				{
					break;
				}
			}
			decoder.close();
			fis.close();
		}
		catch (FileNotFoundException e2)
		{
			return;
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		for (HashMap.Entry<String, HabitacionEstandar> entrada : mapaHabitacionesEstandar.entrySet())
		{
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue().getID());
		}
		
		System.out.println(HabitacionEstandar.getTarifas());
		
		coordinadorPMS.setHabitacionesEstandar(mapaHabitacionesEstandar);
	}
	
	private void cargarHabitacionesSuite(CoordinadorPMS coordinadorPMS) 
	{
		try
		{
			Object obj;
			FileInputStream fis = new FileInputStream("data/tarifasHabitacionesSuite.xml");
			XMLDecoder decoder = new XMLDecoder(fis);
			
			obj = decoder.readObject();
			if (obj instanceof ArrayList)
			{
				HabitacionSuite.setTarifas((ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>) obj);
			}
			else
			{
				System.err.println("No esta la lista en el archivo");
			}
			decoder.close();
			fis.close();
			
			fis = new FileInputStream("data/habitacionesSuite.xml");
			decoder = new XMLDecoder(fis);
			
			while (true)
			{
				try
				{
					obj = decoder.readObject();
					
					if (obj instanceof HabitacionSuite)
					{
						HabitacionSuite room = (HabitacionSuite) obj;
						String id = room.getID();
						mapaHabitacionesSuite.put(id, room);
					}
					else
					{
						System.err.println("objecto inesperado en el archivo");
					}
				}
				catch (ArrayIndexOutOfBoundsException e3)
				{
					break;
				}
			}
			decoder.close();
			fis.close();
		}
		catch (FileNotFoundException e2)
		{
			return;
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		for (HashMap.Entry<String, HabitacionSuite> entrada : mapaHabitacionesSuite.entrySet())
		{
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue().getID());
		}
		
		System.out.println(HabitacionSuite.getTarifas());
		
		coordinadorPMS.setHabitacionesSuite(mapaHabitacionesSuite);
		
	}

	private void cargarHabitacionesSuiteDoble(CoordinadorPMS coordinadorPMS) 
	{
		try
		{
			Object obj;
			FileInputStream fis = new FileInputStream("data/tarifasHabitacionesSuiteDoble.xml");
			XMLDecoder decoder = new XMLDecoder(fis);
			
			obj = decoder.readObject();
			if (obj instanceof ArrayList)
			{
				HabitacionSuiteDoble.setTarifas((ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>) obj);
			}
			else
			{
				System.err.println("No esta la lista en el archivo");
			}
			decoder.close();
			fis.close();
			
			fis = new FileInputStream("data/habitacionesSuiteDoble.xml");
			decoder = new XMLDecoder(fis);
			
			while (true)
			{
				try
				{
					obj = decoder.readObject();
					
					if (obj instanceof HabitacionSuiteDoble)
					{
						HabitacionSuiteDoble room = (HabitacionSuiteDoble) obj;
						String id = room.getID();
						mapaHabitacionesSuiteDoble.put(id, room);
					}
					else
					{
						System.err.println("objecto inesperado en el archivo");
					}
				}
				catch (ArrayIndexOutOfBoundsException e3)
				{
					break;
				}
			}
			decoder.close();
			fis.close();
		}
		catch (FileNotFoundException e2)
		{
			return;
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		for (HashMap.Entry<String, HabitacionSuiteDoble> entrada : mapaHabitacionesSuiteDoble.entrySet())
		{
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue().getID());
		}
		
		System.out.println(HabitacionSuiteDoble.getTarifas());
		
		coordinadorPMS.setHabitacionesSuiteDoble(mapaHabitacionesSuiteDoble);

	}

	private void cargarProductos(CoordinadorPMS coordinadorPMS) 
	{
		try
		{
			Object obj;
			FileInputStream fis = new FileInputStream("data/Producto.xml");
			XMLDecoder decoder = new XMLDecoder(fis);
			
			obj = decoder.readObject();
			if (obj instanceof ArrayList)
			{
				Producto.setTarifas((ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>) obj);
			}
			else
			{
				System.err.println("No esta la lista en el archivo");
			}
			decoder.close();
			fis.close();
			
			fis = new FileInputStream("data/Productos.xml");
			decoder = new XMLDecoder(fis);
			
			while (true)
			{
				try
				{
					obj = decoder.readObject();
					
					if (obj instanceof HabitacionSuiteDoble)
					{
						Producto producto = (Producto) obj;
						String id = producto.getID();
						mapaProducto.put(id, producto);
					}
					else
					{
						System.err.println("objecto inesperado en el archivo");
					}
				}
				catch (ArrayIndexOutOfBoundsException e3)
				{
					break;
				}
			}
			decoder.close();
			fis.close();
		}
		catch (FileNotFoundException e2)
		{
			return;
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		for (HashMap.Entry<String, Producto> entrada : mapaProducto.entrySet())
		{
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue().getID());
		}
		
		System.out.println(HabitacionSuiteDoble.getTarifas());
		
		coordinadorPMS.setProducto(mapaProducto);

	}

	
	
	
	private void cargarUsuarios(AutenticadorDeUsuarios autenticador)
	{	
		try
		{
			FileInputStream fis = new FileInputStream(nombreArchivoUsuarios);
			XMLDecoder decoder = new XMLDecoder(fis);
			Object obj;
			
			while (true)
			{
				try
				{
					obj = decoder.readObject();
					
					if (obj instanceof Usuario)
					{
						Usuario usuario = (Usuario) obj;
						String login = usuario.getLogin();
						mapaUsuarios.put(login, usuario);
					}
					else
					{
						System.err.println("objecto inesperado en el archivo");
					}
				}
				catch (ArrayIndexOutOfBoundsException e3)
				{
					break;
				}
			}
			decoder.close();
			fis.close();
		}
		catch (FileNotFoundException e2)
		{
			return;
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		autenticador.setMapaUsuarios(mapaUsuarios);

	}
}
