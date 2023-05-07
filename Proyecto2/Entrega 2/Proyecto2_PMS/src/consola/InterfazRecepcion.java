package consola;

import java.time.LocalDate;

import controlador.Controlador;

public class InterfazRecepcion extends Interfaz
{
	private Controlador controlador;
	
	public InterfazRecepcion(Controlador controlador)
	{
		this.controlador = controlador;
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
					ejecutarCheckIn();
				else if (seleccion == 2)
					ejecutarCheckOut();
				else if (seleccion == 3)
					ejecutarGetInfoHuesped();
				else if (seleccion == 4)
					ejecutarGetInfoHabitacion();
				else if (seleccion == 5)
					ejecutarGetHabitacionesDisponibles();
				else if (seleccion == 6)
					ejecutarReservar();
				else if (seleccion == 7)
					ejecutarCancelarReserva();
				else if (seleccion == 8)
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

	private void ejecutarCheckIn()
	{
		String esConReserva = input("El huesped ya tiene reserva? (si / no)").toLowerCase();
		
		if (esConReserva.equals("si"))
		{
			ejecutarCheckInConReserva();
		}
		else if (esConReserva.equals("no"))
		{
			ejecutarCheckInSinReserva();
		}
		else
			System.out.println("Opción no válida.");
		
	}

	private void ejecutarCheckInSinReserva()
	{
		// TODO check in sin reserva
	}

	private void ejecutarCheckInConReserva()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarCheckOut()
	{
		String idHuesped = input("ID del huesped responsable");
		String fechaInicial = input("Fecha inicial (aaaa-mm-dd)");

		// controlador.generarTextoFactura();
		controlador.checkOut(idHuesped, fechaInicial);
	}

	private void ejecutarGetInfoHuesped()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarGetInfoHabitacion()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarGetHabitacionesDisponibles()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarReservar()
	{
		// TODO Revervar habitaciones
		try
		{
			String nombreHuespedResponsable = input("Nombre del huesped responsable");
			String apellidosHuespedResponsable = input("Apellidos del huesped responsable");
			String documentoHuespedResponsable = input("Documento de ID");
			String correoHuespedResponsable = input("Correo electronico");
			String celularHuespedResponsable = input("Número de celular");
			String fechaInicial = input("Fecha inicial (aaaa-mm-dd)");
			String fechaFinal = input("Fecha final (aaaa-mm-dd)");
			int numeroHabEstandar = Integer.parseInt(input("¿Cuantas habitaciones Estándar?"));
			int numeroHabSuite = Integer.parseInt(input("¿Cuantas habitaciones Suite?"));
			int numeroHabSuiteDoble = Integer.parseInt(input("¿Cuantas habitaciones Suite Doble?"));
			
			boolean disponibles = controlador.revisarDisponibilidad(numeroHabEstandar, numeroHabSuite, numeroHabSuiteDoble, fechaInicial, fechaFinal);
			System.out.println(disponibles);
			

			if (disponibles)
			{					
				int numeroHuespedes = Integer.parseInt(input("¿Cuantos huespedes?"));				
				controlador.nuevaReserva(numeroHabEstandar, numeroHabSuite, numeroHabSuiteDoble, documentoHuespedResponsable, nombreHuespedResponsable, apellidosHuespedResponsable, correoHuespedResponsable, celularHuespedResponsable, fechaFinal, fechaFinal);
				
				for (int  i=1; i<numeroHuespedes; i++)
				{
					String nombreHuesped = input("Nombre del huesped");
					String apellidosHuesped = input("Apellidos del huesped");
					String documentoHuesped = input("Documento de ID");
					String correoHuesped = input("Correo electronico");
					String celularHuesped = input("Número de celular");
					controlador.agregarHuesped(nombreHuesped, apellidosHuesped, documentoHuesped, correoHuesped, celularHuesped);
				}
				System.out.println("Reserva exitosa!");
			}
			else
				System.out.println("No hay habitaciones disponbles para las fechas dadas");
							
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe de usar valores numéricos enteros positivos y el número debe estar dentro de las opciones.");
		}
		
	}

	private void ejecutarCancelarReserva()
	{
		// TODO Auto-generated method stub
	}

	@Override
	protected void mostrarMenu()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Realizar Check-In");
		System.out.println("2. Realizar Check-Out");
		System.out.println("3. Consultar información de un huésped");
		System.out.println("4. Consultar información de una habitación");
		System.out.println("5. Ver habitaciones disponibles");
		System.out.println("6. Realizar una reserva");
		System.out.println("7. Cancelar una reserva");;
		System.out.println("8. Ir atrás (admin) / Cerrar sesión");
	}

}
