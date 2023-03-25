package salvador;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import autenticador.AutenticadorDeUsuarios;
import autenticador.Usuario;

public class SalvadorDeDatos
{
	String nombrerArchivoUsuarios;
	HashMap<String, Usuario> mapaUsuarios;
	
	public SalvadorDeDatos()
	{
		this.nombrerArchivoUsuarios = "data/usuarios.xml";
	}
	
	public void salvarDatosHotel(AutenticadorDeUsuarios autenticador)
	{
		salvarUsuarios(autenticador);
	}
	
	private void salvarUsuarios(AutenticadorDeUsuarios autenticador)
	{
		this.mapaUsuarios = autenticador.getMapaUsuarios();
		
		try
		{
			FileOutputStream fos = new FileOutputStream(nombrerArchivoUsuarios);
			XMLEncoder encoder = new XMLEncoder(fos);
			
			for (HashMap.Entry<String, Usuario> entrada : mapaUsuarios.entrySet())
			{
				Usuario usuario = (Usuario) entrada.getValue();
				System.out.println(usuario.toString());
				encoder.writeObject(usuario);
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
