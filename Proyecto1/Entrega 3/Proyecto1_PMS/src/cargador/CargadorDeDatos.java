package cargador;

import autenticador.AutenticadorDeUsuarios;

public class CargadorDeDatos
{
	String nombreArchivoUsuarios;
	
	public CargadorDeDatos()
	{
		// TODO Auto-generated constructor stub
	}
	
	public CargadorDeDatos(AutenticadorDeUsuarios autenticador)
	{
		this.nombreArchivoUsuarios = "data/usuarios.bin";
	}
	
	public void cargarDatosHotel()
	{
		cargarUsuarios();
	}

	private void cargarUsuarios()
	{
		
	}
}
