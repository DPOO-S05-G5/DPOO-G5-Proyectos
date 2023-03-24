package autenticador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Register
{
	/* opciones para tipoEmpleado: 
	"admin"
	"recepcionista"
	"empleado"
	*/
	private String tipoEmpleado;
	
	public void registrarEmpleado(HashMap<String, Usuario> usersMap)
	{
		seleccionarTipoEmpleado();
		String login = input("Nombre de usuario (login)");
		String password1 = input("Contraseña (Password)");
		String password2 = input("Confirmar contraseña");
		
		boolean userExists = usersMap.containsKey(login);
		
		if (!userExists)
		{
			if (password1.equals(password2))
			{
				Usuario nuevoUsuario = new Usuario(login, password1, this.tipoEmpleado);
				usersMap.put(login, nuevoUsuario);
				System.out.println("Nuevo usuario:\n" + nuevoUsuario.toString() + "\n");
			}
			else
			{
				System.out.println("\nLAS CONTRASEÑAS DEBEN DE SER IGUALES\n");
			}
		}
		else
		{
			System.out.println("\nNOMBRE DE USUARIO YA EXISTE\n");
		}
	}
	
	private void seleccionarTipoEmpleado()
	{
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				menuTipoEmpleado();
				int seleccion = Integer.parseInt(input("Seleccione una opción"));
				
				if (seleccion == 1)
				{
					this.tipoEmpleado = "admin";
					continuar = false;
				}
				else if (seleccion == 2)
				{
					this.tipoEmpleado = "recepcionista";
					continuar = false;
				}
				else if (seleccion == 3)
				{
					this.tipoEmpleado = "empleado";
					continuar = false;
				}
				else if (seleccion == 4)
				{
					continuar = false;
				}
				else
				{
					System.out.println("\nPor favor seleccione una opción válida.");
				} 
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	private void menuTipoEmpleado()
	{
		System.out.println("1. Administrador");
		System.out.println("2. Recepcionista");
		System.out.println("3. Otro (Empleado)");
		System.out.println("4. Cancelar registración");
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
