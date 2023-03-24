package proyecto1.autenticador;

import java.util.HashMap;

public class AutenticadorDeUsuarios
{
	
	private Login login;
	private Register registrador;
	private HashMap<String, Usuario> usersMap;
	
	public AutenticadorDeUsuarios()
	{
		this.usersMap = new HashMap<String, Usuario>();
		this.login = new Login();
		this.registrador = new Register();
	}
	
	public AutenticadorDeUsuarios(HashMap<String, Usuario> usersMap)
	{
		this.usersMap = usersMap;
		this.login = new Login();
		this.registrador = new Register();
	}
	
	public String iniciarSesion()
	{
		return login.inicioDeSesion(usersMap);		
	}
	
	public void registrarEmpleado()
	{
		registrador.registrarEmpleado(usersMap);
	}
	 
}
