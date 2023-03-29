package consola;

import modelo.CoordinadorPMS;

public class InterfazRecepcion extends Interfaz
{
	private CoordinadorPMS coordinadorPMS;
	
	public InterfazRecepcion(CoordinadorPMS coordinadorPMS)
	{
		this.coordinadorPMS = coordinadorPMS;
	}
	
	@Override
	public void iniciarInterfaz()
	{
		System.out.println("\nRecepcion");
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int seleccion = Integer.parseInt(input("Selecione una opción"));
				
				if (seleccion == 1)
					ejecutarInfoHuesped();
				else if (seleccion == 2)
					ejecutarInfoHabitacion();
				else if (seleccion == 3)
					ejecutarRealizarReserva();
				else if (seleccion == 4)
					ejecutarCancelarReserva();
				else if (seleccion == 5)
					ejecutarRealizarCheckIn();
				else if (seleccion == 6)
					ejecutarRealizarCheckOut();
				else if (seleccion == 7)
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

	private void ejecutarRealizarCheckOut()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarRealizarCheckIn()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarCancelarReserva()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarRealizarReserva()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarInfoHabitacion()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarInfoHuesped()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mostrarMenu()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Consultar información de un huésped");
		System.out.println("2. Consultar información de una habitación");
		System.out.println("3. Realizar una reserva");
		System.out.println("4. Cancelar una reserva");
		System.out.println("5. Realizar Check-In");
		System.out.println("6. Realizar Check-Out");
		System.out.println("7. Ir atrás (admin) / Cerrar sesión");
	}
}
