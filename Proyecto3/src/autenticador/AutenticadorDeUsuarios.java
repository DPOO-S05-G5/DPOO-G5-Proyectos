package autenticador;

import java.util.HashMap;
import java.util.Map.Entry;

import salvador.SalvadorDeDatos;


public class AutenticadorDeUsuarios
{
	private SalvadorDeDatos salvador;
	private Login login;
	private Register register;
	private HashMap<String, Usuario> usersMap;
	
	
	public AutenticadorDeUsuarios()
	{
		this.salvador = new SalvadorDeDatos();
		this.usersMap = new HashMap<String, Usuario>();
		this.login = new Login();
		this.register = new Register();
	}
	
	public AutenticadorDeUsuarios(HashMap<String, Usuario> usersMap)
	{
		this.salvador = new SalvadorDeDatos();
		this.usersMap = usersMap;
		this.login = new Login();
		this.register = new Register();
	}
	
	public void registrarUsuario(String tipo, String login, String password, String confirmPassword) throws Exception
	{		
		boolean userExists = usersMap.containsKey(login);

		if (!userExists)
		{
			if (confirmPassword.equals(password))
			{
				Usuario newUser = new Usuario(login, password, tipo);
				usersMap.put(login, newUser);
				salvador.salvarObjeto(newUser);
			}
			else
				throw new Exception("Las contraseñas no coinciden");
		}
		else
			throw new Exception("El usuario ya existe");
	}
	
	public String iniciarSesion(String userLogin, String password) throws Exception
	{
		Usuario user = usersMap.get(userLogin);
		
		if (user != null)
		{
			String userPassword = user.getPassword();
			if (userPassword.equals(password))
				return user.getType();
			else
				throw new Exception("Contraseña incorrecta");
		}
		else
			throw new Exception("El usuario no existe");
	}
	
	public void setUsersMap(HashMap<String, Usuario> usersMap)
	{
		this.usersMap = usersMap;
		if (usersMap != null)
		{
			for (Entry<String, Usuario> entrada : usersMap.entrySet())
			{
				System.out.println(entrada.getValue().toString());
			}
		}
		
	}
}
