package consola;

import controlador.Controlador;

public class InterfazServicios extends Interfaz
{
	private Controlador controlador;
	
	public InterfazServicios(Controlador controlador)
	{
		this.controlador = controlador;
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
				int seleccion = Integer.parseInt(input("Selecione una opción"));
				
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

	private void ejecutarGoToRestaurante()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarRegistrarConsumo()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mostrarMenu()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Registrar consumo");
		System.out.println("2. Ir a restaurante");
		System.out.println("3. Ir atrás (admin) / Cerrar sesión");
	}
}
