package consola;

import modelo.CoordinadorPMS;

public class InterfazHabitaciones extends Interfaz
{
	private  CoordinadorPMS coordinadorPMS;
	private String[] tiposHabitacion;
	
	public InterfazHabitaciones(CoordinadorPMS coordinadorPMS)
	{
		 this.coordinadorPMS = coordinadorPMS;
		 this.tiposHabitacion = new String[]{"estandar", "suite", "suitedoble"};
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
			String tipoHabitacion = input("\nTipo de habitación (estandar / suite / suitedoble)").toLowerCase();
			String torre = input("Torre").toUpperCase();
			int piso = Integer.parseInt(input("Piso"));
			String id = input("ID");
			String tieneBalcon = input("Tiene balcon? (si/no)").toLowerCase();
			String tieneVista = input("Tiene vista? (si/no)").toLowerCase();
			String tieneCocina = input("Tiene cocina integrada? (si/no)").toLowerCase();
			
			boolean balcon;
			boolean vista;
			boolean cocina;
			if (tieneCocina.equals("si"))
				cocina = true;
			else
				cocina = false;
			if (tieneBalcon.equals("si"))
				balcon = true;
			else
				balcon = false;
			if (tieneVista.equals("si"))
				vista = true;
			else
				vista = false;
			
			if (tipoHabitacion.equals(tiposHabitacion[0]) || tipoHabitacion.equals(tiposHabitacion[1]) || tipoHabitacion.equals(tiposHabitacion[2]))
			{	
				String roomInfo = coordinadorPMS.addHabitacion(tipoHabitacion, cocina, balcon, vista, torre, piso, id);
				System.out.println(roomInfo);
			}
			
			else
				System.out.println("Tipo de habitacion debe ser  \"estandar\" o \"suite\" o \"suite doble\".");
		}
		catch (NumberFormatException e)
		{
			System.out.println("El piso de la habitación debe ser un valor numerico.");
		}
		
	}

	@Override
	protected void mostrarMenu()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Crear nueva habitación");
		System.out.println("2. Salir");
	}
	
}
