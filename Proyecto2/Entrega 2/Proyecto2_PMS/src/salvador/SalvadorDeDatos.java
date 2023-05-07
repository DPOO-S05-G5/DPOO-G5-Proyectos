package salvador;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import autenticador.Usuario;
import modelo.CoordinadorPMS;
import modelo.Habitacion;
import modelo.Reserva;
import modelo.Tarifa;

public class SalvadorDeDatos
{
	private static final String DATA_DIR = "./data/";
	private static final String USUARIOS_DIR = DATA_DIR + "usuarios/";
	private static final String TARIFAS_DIR = DATA_DIR + "tarifas/";
	private static final String RESERVAS_DIR = DATA_DIR + "reservas/";
	private static final String HABITACIONES_DIR = DATA_DIR + "habitaciones/";
	private static final String SERVICIOS_DIR = DATA_DIR + "servicios/";
	private static final String PRODUCTOS_DIR = DATA_DIR + "productos/";
	private CoordinadorPMS coordinadorPMS;
	
	public SalvadorDeDatos()
	{
		
	}
	
	public void setCoordinadorPMS(CoordinadorPMS coordinadorPMS)
	{
		this.coordinadorPMS = coordinadorPMS;
	}

	public void salvarObjeto(Object obj)
	{
		try
		{
			FileOutputStream fos = null;
			if (obj instanceof Usuario)
			{
				Usuario usuario = (Usuario) obj;
				fos = new FileOutputStream(USUARIOS_DIR + usuario.getLogin() + ".xml");
			}
			else if (obj instanceof Tarifa)
			{
				Tarifa tarifa = (Tarifa) obj;
				fos = new FileOutputStream(TARIFAS_DIR + tarifa.toString() + ".xml");
			}
			else if (obj instanceof Reserva)
			{
				Reserva reserva = (Reserva) obj;
				fos = new FileOutputStream(RESERVAS_DIR + reserva.getId() + ".xml");
			}
			else if (obj instanceof Habitacion)
			{
				Habitacion hab = (Habitacion) obj;
				fos = new FileOutputStream(HABITACIONES_DIR + hab.getId() + ".xml");
			}
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(obj);
			encoder.close();
			fos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
			
	}
	
	// public void salvarUsuario(Usuario usuario)
	// {
	// 	try
	// 	{
	// 		FileOutputStream fos = new FileOutputStream(USUARIOS_DIR + usuario.getLogin() + ".xml");
	// 		XMLEncoder encoder = new XMLEncoder(fos);
	// 		encoder.writeObject(usuario);
	// 		encoder.close();
	// 		fos.close();
	// 	}
	// 	catch (IOException e)
	// 	{
	// 		e.printStackTrace();
	// 	}
	// }

	// public void salvarTarifa(Tarifa tarifa)
	// {
	// 	try
	// 	{
	// 		FileOutputStream fos = new FileOutputStream(TARIFAS_DIR + tarifa.toString() + ".xml");
	// 		XMLEncoder encoder = new XMLEncoder(fos);
	// 		encoder.writeObject(tarifa);
	// 		encoder.close();
	// 		fos.close();
	// 	}
	// 	catch (IOException e)
	// 	{
	// 		e.printStackTrace();
	// 	}
	// }
	
	// public void salvarHabitacion(Habitacion habitacion)
	// {
	// 	try
	// 	{
	// 		FileOutputStream fos = new FileOutputStream(HABITACIONES_DIR + habitacion.getId() + ".xml");
	// 		XMLEncoder encoder = new XMLEncoder(fos);
	// 		encoder.writeObject(habitacion);
	// 		encoder.close();
	// 		fos.close();
	// 		coordinadorPMS.getCantidadTiposHabitacion().put(habitacion.getTipo(), coordinadorPMS.getCantidadTiposHabitacion().get(habitacion.getTipo()) + 1);
	// 	}
	// 	catch (IOException e)
	// 	{
	// 		e.printStackTrace();
	// 	}
	// }

	public void borrarHabitacion(String id)
	{
		File directorio = new File(HABITACIONES_DIR);
		String[] hijos = directorio.list();
		if (hijos != null)
		{
			for (String archivo : hijos)
			{
				if (archivo.equals(id + ".xml"))
				{
					File archivoAEliminar = new File(HABITACIONES_DIR + archivo);
					archivoAEliminar.delete();
				}
			}
		}		
	}
}
