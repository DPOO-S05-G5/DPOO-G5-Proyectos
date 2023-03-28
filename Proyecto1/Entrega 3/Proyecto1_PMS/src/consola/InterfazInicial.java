package consola;

import autenticador.AutenticadorDeUsuarios;
import cargador.CargadorDeDatos;
import modelo.CoordinadorPMS;
import salvador.SalvadorDeDatos;

public class InterfazInicial extends Interfaz
{
	
	private InterfazAdmin interfazAdmin;
	private InterfazRecepcion interfazRecepcion;
	private InterfazServicios interfazServicios;
	private AutenticadorDeUsuarios autenticador;
	private CoordinadorPMS coordinadorPMS;
	private CargadorDeDatos cargador;
	private SalvadorDeDatos salvador;
	
	
	public InterfazInicial()
	{
		this.interfazAdmin = new InterfazAdmin();
		this.interfazRecepcion = new InterfazRecepcion();
		this.interfazServicios = new InterfazServicios();
		this.autenticador = new AutenticadorDeUsuarios();
		this.coordinadorPMS = new CoordinadorPMS();
		this.cargador = new CargadorDeDatos();
		this.salvador = new SalvadorDeDatos();
	}
	
	@Override
	public void iniciarInterfaz()
	{
		System.out.println("\nProperty management system (PMS) - Hotel Villa Uniandes\n");
		System.out.println("Cargando información del hotel...\n");
		ejecutarCargarDatosHotel();
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int seleccion = Integer.parseInt(input("Seleccione una opción"));
				
				if (seleccion == 1)
					ejecutarIniciarSesion();
				else if (seleccion == 2)
					ejecutarRegistrarEmpleado();
				else if (seleccion == 3)
				{
					System.out.println("\nSaliendo de la aplicación...\n");
					ejecutarSalvarDatosHotel();
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
	
	@Override
	protected void mostrarMenu()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Iniciar sesión");
		System.out.println("2. Registrar nuevo empleado");
		System.out.println("3. Salir de la aplicación");
	}
	
	private void ejecutarCargarDatosHotel()
	{
		cargador.cargarDatosHotel(autenticador, coordinadorPMS);
	}
	
	private void ejecutarSalvarDatosHotel()
	{
		salvador.salvarDatosHotel(autenticador);
	}
	
	private void ejecutarIniciarSesion()
	{
		String tipoUsuario = autenticador.iniciarSesion();
		if (tipoUsuario != null)
			System.out.println("Empleado de tipo: " + tipoUsuario + "\n");
		
		if (tipoUsuario.equals("admin"))
			ejecutarInterfazAdmin();
		else if (tipoUsuario.equals("recepcionista"))
			ejecutarInterfazRecepcion();
		else if (tipoUsuario.equals("empleado"))
			ejecutarInterfazServicios();			
	}
	
	private void ejecutarRegistrarEmpleado()
	{
		autenticador.registrarEmpleado();
	}
	
	private void ejecutarInterfazAdmin()
	{
		interfazAdmin.iniciarInterfaz();
	}
	
	private void ejecutarInterfazRecepcion()
	{
		interfazRecepcion.iniciarInterfaz();
	}
	
	private void ejecutarInterfazServicios()
	{
		interfazServicios.iniciarInterfaz();
	}

	public static void main(String[] args)
	{
		InterfazInicial consola = new InterfazInicial();
		consola.iniciarInterfaz();
	}

}
