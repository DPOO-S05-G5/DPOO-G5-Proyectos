package autenticador;

import java.util.HashMap;

public class AutenticadorDeUsuarios
{
	
	private Login login;
	private Register registrador;
	private HashMap<String, Usuario> mapaUsuarios;
	
	public AutenticadorDeUsuarios()
	{
		this.mapaUsuarios = new HashMap<String, Usuario>();
		this.login = new Login();
		this.registrador = new Register();
	}
	
	public AutenticadorDeUsuarios(HashMap<String, Usuario> mapaUsuarios)
	{
		this.mapaUsuarios = mapaUsuarios;
		this.login = new Login();
		this.registrador = new Register();
	}
	
	public String iniciarSesion()
	{
		return login.inicioDeSesion(mapaUsuarios);		
	}
	
	public void registrarEmpleado()
	{
		registrador.registrarEmpleado(mapaUsuarios);
	}
	
	public void setMapaUsuarios(HashMap<String, Usuario> mapaUsuarios)
	{
		this.mapaUsuarios = mapaUsuarios;
	}
	
	public HashMap<String, Usuario> getMapaUsuarios()
	{
		return mapaUsuarios;
	}
}
