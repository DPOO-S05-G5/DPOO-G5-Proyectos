package consola;

import modelo.CoordinadorPMS;

public class InterfazHabitaciones extends Interfaz
{
	private  CoordinadorPMS coordinadorPMS;
	
	public InterfazHabitaciones(CoordinadorPMS coordinadorPMS)
	{
		 this.coordinadorPMS = coordinadorPMS;
	}
	@Override
	public void iniciarInterfaz()
	{
		System.out.println("\nHabitaciones");
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int seleccion = Integer.parseInt(input("Selecione una opción"));
				
				if (seleccion == 1)
					ejecutarCrearHabitacion();
				else if (seleccion == 2)
					ejecutarEliminarHabitacion();
				else if (seleccion == 3)
				{
					System.out.println();
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

	private void ejecutarCrearHabitacion()
	{
		try
		{
			System.out.println("\nEstandar (capacidad total: 2 adultos)\n" + "\t1 cama doble (2 adultos por cama)");
			System.out.println("\nSuite (capacidad total: 3 adultos, 1 niño)\n" + "\t1 cama doble (2 adultos por cama)\n" + "\t1 cama sencilla (1 adulto por cama)\n" + "\t1 cama de niño (1 niño)");
			System.out.println("\nSuite doble (capacidad total: 5 adultos)\n" + "\t2 camas dobles (2 adultos por cama)\n" + "\t1 sofacama (1 adulto por cama)");
			String tipoHabitacion = input("\nTipo de habitación (estandar / suite / suitedoble)");
			String torre = input("Torre");
			int piso = Integer.parseInt(input("Piso"));
			String id = input("ID");
			String tieneBalcon = input("Tiene balcon? (si/no)");
			String tieneVista = input("Tiene vista? (si/no)");
			String tieneCocina = input("Tiene cocina integrada? (si/no)");
			
			coordinadorPMS.addHabitacion(tipoHabitacion, torre, piso, id, tieneBalcon, tieneVista, tieneCocina);
		}
		catch (NumberFormatException e)
		{
			System.out.println("El piso de la habitación debe ser un valor numerico.");
		}
		
	}
	private void ejecutarEliminarHabitacion()
	{
		try
		{
			String tipoHabitacion = input("Tipo de habitación del cuarto que desea eliminar (estandar / suite / suitedoble)");
			String torre = input("Torre");
			int piso = Integer.parseInt(input("Piso"));
			// TODO mostrar habitaciones existentes para el tipo de habitación, torre, y piso
		
			int habitacionSeleccionada = Integer.parseInt(input("Seleccione la habitación para eliminar"));
			// TODO Eliminar la habitacion elegida
		}
		catch(NumberFormatException e)
		{
			System.out.println("El piso de la habitación debe ser un valor numerico.");
		}		
	}

	@Override
	protected void mostrarMenu()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Crear nueva habitación");
		System.out.println("2. Eliminar habitación");
		System.out.println("3. Salir");
	}
	
}
