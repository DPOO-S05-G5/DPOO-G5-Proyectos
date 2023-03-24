package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import autenticador.AutenticadorDeUsuarios;
import cargador.CargadorDeDatos;

public class InterfazInicial
{
	
	private AutenticadorDeUsuarios autenticador;
	private CargadorDeDatos cargador;
	//private CoordinadorPMS coordinador;
	//private InterfazAdmin interfazAdmin;
	//private InterfazRecepcion interfazRecepcion;
	//private InterfazEmpleado interfazEmpleado;
	
	public InterfazInicial()
	{
		super();
		this.autenticador = new AutenticadorDeUsuarios();
		this.cargador = new CargadorDeDatos();
	}
	
	public void ejecutarAplicacion()
	{
		System.out.println("\nProperty management system (PMS) - Hotel Villa Uniandes\n");
		System.out.println("Cargando información del hotel...\n");
		ejecutarCargarDatosHotel();
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenuDeInicio();
				int seleccion = Integer.parseInt(input("Seleccione una opción"));
				
				if (seleccion == 1)
					ejecutarIniciarSesion();
				else if (seleccion == 2)
					ejecutarRegistrarEmpleado();
				else if (seleccion == 3)
				{
					System.out.println("\nSaliendo de la aplicación...\n");
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

	private void mostrarMenuDeInicio()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Iniciar sesión");
		System.out.println("2. Registrar nuevo empleado");
		System.out.println("3. Salir de la aplicación");
	}
	
	private void ejecutarCargarDatosHotel()
	{
		cargador.cargarDatosHotel();
	}
	
	private void ejecutarIniciarSesion()
	{
		String tipoUsuario = autenticador.iniciarSesion();
		if (tipoUsuario != null)
			System.out.println("Empleado de tipo: " + tipoUsuario + "\n");
		
//		if (tipoUsuario.equals("admin"))
//			ejecutarInterfazAdmin();
//		else if (tipoUsuario.equals("recepcionista"))
//			ejecutarInterfazRecepcion();
//		else if (tipoUsuario.equals("empleado"))
//			ejecutarInterfazEmpleado();			
	}
	
	private void ejecutarRegistrarEmpleado()
	{
		autenticador.registrarEmpleado();
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

	public static void main(String[] args)
	{
		InterfazInicial consola = new InterfazInicial();
		consola.ejecutarAplicacion();
	}

}
