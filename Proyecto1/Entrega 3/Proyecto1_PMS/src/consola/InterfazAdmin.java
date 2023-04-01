package consola;

import modelo.CoordinadorPMS;

public class InterfazAdmin extends Interfaz
{
	
	private InterfazTarifas interfazTarifas;
	private InterfazHabitaciones interfazHabitaciones;
	private InterfazRecepcion interfazRecepcion;
	private InterfazServicios interfazServicios;
	private CoordinadorPMS coordinadorPMS;
	
	public InterfazAdmin(CoordinadorPMS coordinadorPMS)
	{
		this.coordinadorPMS = coordinadorPMS;
		this.interfazRecepcion = new InterfazRecepcion(coordinadorPMS);
		this.interfazServicios = new InterfazServicios(coordinadorPMS);
		this.interfazTarifas = new InterfazTarifas(coordinadorPMS);
		this.interfazHabitaciones = new InterfazHabitaciones(coordinadorPMS);
	}
	
	@Override
	public void iniciarInterfaz()
	{
		System.out.println("\nPortal de administración\n");
		
		ejecutarRevisionDeTarifas365Dias();
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int seleccion = Integer.parseInt(input("Seleccione una opción"));
				
				if (seleccion == 1)
					ejecutarInterfazTarifas();
				else if (seleccion == 2)
					ejecutarInterfazHabitaciones();
				else if (seleccion == 3)
					goToInterfazRecepcion();
				else if (seleccion == 4)
					goToInterfazServicios();
				else if (seleccion == 5)
				{
					System.out.println("Cerrando sesión...\n");
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

	private void ejecutarRevisionDeTarifas365Dias()
	{
		String tarifas = coordinadorPMS.revisarTarifas();
		System.out.println(tarifas);
	}

	@Override
	protected void mostrarMenu()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Agregar o editar tarifas");
		System.out.println("2. Agregar o eliminar habitaciones");
		System.out.println("3. Menú recepción");
		System.out.println("4. Menú servicios");
		System.out.println("5. Cerrar sesión");
	}
	
	private void ejecutarInterfazTarifas()
	{
		interfazTarifas.iniciarInterfaz();
	}
	
	private void ejecutarInterfazHabitaciones()
	{
		interfazHabitaciones.iniciarInterfaz();
	}
	
	private void goToInterfazRecepcion()
	{
		interfazRecepcion.iniciarInterfaz();
	}
	
	private void goToInterfazServicios()
	{
		interfazServicios.iniciarInterfaz();
	}

}
