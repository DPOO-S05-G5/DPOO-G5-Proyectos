package cargador;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import autenticador.AutenticadorDeUsuarios;
import autenticador.Usuario;

public class CargadorDeDatos
{
	String nombreArchivoUsuarios;
	HashMap<String, Usuario> mapaUsuarios;
	
	public CargadorDeDatos()
	{
		this.nombreArchivoUsuarios = "data/usuarios.xml";
		this.mapaUsuarios = new HashMap<String, Usuario>();
	}
	
	public void cargarDatosHotel(AutenticadorDeUsuarios autenticador)
	{
		cargarUsuarios(autenticador);
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
