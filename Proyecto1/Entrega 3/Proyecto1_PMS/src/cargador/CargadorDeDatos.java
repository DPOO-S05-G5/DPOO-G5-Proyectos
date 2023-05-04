package cargador;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;

import autenticador.Usuario;
import controlador.Controlador;
import modelo.Fecha;
import modelo.Habitacion;
import modelo.Tarifa;
import modelo.Tarifas;

public class CargadorDeDatos
{
	private static final String DATA_DIR = "data/";
	
	private Controlador controlador;
	private HashMap<String, Usuario> mapaUsuarios;
	private Tarifas tarifas;
	private HashMap<String, Habitacion> mapaHabitaciones;
	
	public CargadorDeDatos(Controlador controlador)
	{
		this.controlador = controlador;		
		this.mapaUsuarios = new HashMap<String, Usuario>();
		this.tarifas = new Tarifas();
		this.mapaHabitaciones = new HashMap<String, Habitacion>();
	}
	
	public HashMap<String, Integer> infoDeCarga()
	{
		HashMap<String, Integer> dictInfoCarga = new HashMap<String, Integer>();
		
		dictInfoCarga.put("Usuarios", mapaUsuarios.size());
		dictInfoCarga.put("Habitaciones", mapaHabitaciones.size());
		dictInfoCarga.put("Tarifas", tarifas.getArbolTarifas().size());
		
		return dictInfoCarga;
	}

	public void cargarDatos()
	{
		File directorioData = new File(DATA_DIR);
		File[] subDirectoriosData = directorioData.listFiles(new FileFilter() {
            @Override
            public boolean accept(File dir) {
                return dir.isDirectory();
			}
		});
		
		if (subDirectoriosData != null)
		{
			for (File subDirectorio : subDirectoriosData)
			{
				String[] archivos = subDirectorio.list();
				
				if (archivos != null)
				{
					for (String archivo : archivos)
					{
						cargarArchivo(subDirectorio.toString() + "/", archivo);
					}
				}
			}
		}
		
		controlador.setUsuarios(mapaUsuarios);
		controlador.setTarifas(tarifas);
		controlador.setHabitaciones(mapaHabitaciones);
	}
	
	private void cargarArchivo(String directorio, String archivo) 
	{
		try 
		{
			FileInputStream fis = new FileInputStream(directorio + archivo);
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
					else if (obj instanceof Tarifa)
					{
						Tarifa tarifa = (Tarifa) obj;
						Fecha fecha = tarifa.getFecha();
						tarifas.getArbolTarifas().put(fecha, tarifa);
					}
					else if (obj instanceof Habitacion)
					{
						Habitacion hab = (Habitacion) obj;
						String id = hab.getId();
						mapaHabitaciones.put(id, hab);
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
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}

	}
}
