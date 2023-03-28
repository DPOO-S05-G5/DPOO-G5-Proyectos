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
import modelo.Habitacion;
import modelo.HabitacionEstandar;

public class CargadorDeDatos
{
	String nombreArchivoUsuarios;
	HashMap<String, Usuario> mapaUsuarios;
	ArrayList<HabitacionEstandar> listaHabitacionesEstandar;
	
	public CargadorDeDatos()
	{
		this.nombreArchivoUsuarios = "data/usuarios.xml";
		this.mapaUsuarios = new HashMap<String, Usuario>();
	}
	
	public void cargarDatosHotel(AutenticadorDeUsuarios autenticador, CoordinadorPMS coordinadorPMS)
	{
		cargarUsuarios(autenticador);
		cargarHabitaciones(coordinadorPMS);
	}

	private void cargarHabitaciones(CoordinadorPMS coordinadorPMS) 
	{
		
		cargarHabitacionesEstandar(coordinadorPMS);
		cargarHabitacionesSuite(coordinadorPMS);
		cargarHabitacionesSuiteDoble(coordinadorPMS);
		
	}


	private void cargarHabitacionesEstandar(CoordinadorPMS coordinadorPMS) 
	{
		String tipo = "estandar";
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
						listaHabitacionesEstandar.add(room);
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
		
		for (HabitacionEstandar room : listaHabitacionesEstandar)
		{
			System.out.println(room.getID());
		}
		
		System.out.println(HabitacionEstandar.getTarifas());
		
		
		
	}
	
	private void cargarHabitacionesSuite(CoordinadorPMS coordinadorPMS) 
	{
		// TODO Auto-generated method stub
		
	}

	private void cargarHabitacionesSuiteDoble(CoordinadorPMS coordinadorPMS) 
	{
		// TODO Auto-generated method stub
		
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
