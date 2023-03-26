package consola;

public class InterfazServicios extends Interfaz
{
	public InterfazServicios()
	{
		
	}
	
	@Override
	public void iniciarInterfaz()
	{
		System.out.println("\nPortal de servicios");
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int seleccion = Integer.parseInt(input("Seleciione una opción"));
				
				if (seleccion == 1)
					ejecutarRegistrarConsumo();
				else if (seleccion == 2)
					ejecutarGoToRestaurante();
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

	@Override
	protected void mostrarMenu()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Registrar consumo");
		System.out.println("2. Ir a restaurante");
		System.out.println("3. Consultar información de una habitación");
	}
}
