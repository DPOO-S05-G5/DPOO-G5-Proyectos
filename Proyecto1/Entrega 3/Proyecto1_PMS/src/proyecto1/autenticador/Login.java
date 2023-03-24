package proyecto1.autenticador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Login
{
	
	public String inicioDeSesion(HashMap<String, Usuario> usersMap)
	{
		
		String login = input("Nombre de usuario (login)");
		String password = input("Contraseña (Password)");
		Usuario user = usersMap.get(login);
		
		if (user != null)
		{
			String userPassword = user.getPassword();
			if (userPassword.equals(password))
			{
				return user.getTipoUsuario();
			}
			else
			{
				System.out.println("\nCONTRASEÑA INCORRECTA\n");
			}
		}
		else
		{
			System.out.println("\nUSUARIO NO EXISTE\n");
		}
		
		return null;
	}
	

	private String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
}
