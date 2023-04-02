package consola;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.CoordinadorPMS;
import modelo.Habitacion;
import modelo.Reserva;

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

	private void ejecutarRealizarCheckIn()
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
			System.out.println("Opcion no valida.");
	}
	
	private void ejecutarCheckInSinReserva()
	{
		LocalDate fechaHoy = LocalDate.now();
		try
		{
			while (true)
			{
				String nombreHuespedResponsable = input("Nombre del huesped responsable");
				String apellidosHuespedResponsable = input("Apellidos del huesped responsable");
				String documentoHuesped = input("Documento de ID");
				String correoHuesped = input("Correo electronico");
				String numeroCelular = input("Numero de celular");
				int numeroDeNoches = Integer.parseInt(input("¿Cuantas noches?"));
				int totalAdultos = Integer.parseInt(input("Numero de adultos"));
				int totalNinos = Integer.parseInt(input("Numero de niños"));
				
				ArrayList<Habitacion> habitacionesDisponibles = coordinadorPMS.getHabitacionesDesocupadas(numeroDeNoches-1, fechaHoy);
				
				for (Habitacion hab : habitacionesDisponibles)
				{
					System.out.println(hab.toString());
				}
			}
		}
		catch (NumberFormatException e1)
		{
			System.out.println("El numero de personas debe ser un valor numerico positivo");
		}
	}

	private void ejecutarCheckInConReserva()
	{
		String idHuesped =  input("Documento de ID");
		Reserva reserva = coordinadorPMS.getReserva(idHuesped);
		if (reserva == null)
		{
			System.out.println("Reserva no encontrada para documeno de ID: " + idHuesped);
			return;
		}
		
		System.out.println(reserva.toString());
		
	}

	private void ejecutarRealizarCheckOut()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarCancelarReserva()
	{
		// TODO Auto-generated method stub
		
	}

	private void ejecutarRealizarReserva()
	{
		LocalDate fechaHoy = LocalDate.now();
		try
		{
			while (true)
			{
				String nombreHuespedResponsable = input("Nombre del huesped responsable");
				String apellidosHuespedResponsable = input("Apellidos del huesped responsable");
				String documentoHuesped = input("Documento de ID");
				String correoHuesped = input("Correo electronico");
				String numeroCelular = input("Numero de celular");
				int numeroDeNoches = Integer.parseInt(input("¿Cuantas noches?"));
				int totalAdultos = Integer.parseInt(input("Numero de adultos"));
				int totalNinos = Integer.parseInt(input("Numero de niños"));
				
				ArrayList<Habitacion> habitacionesDisponibles = coordinadorPMS.getHabitacionesDesocupadas(numeroDeNoches-1, fechaHoy);
				
				for (Habitacion hab : habitacionesDisponibles)
				{
					System.out.println(hab.toString());
				}
			}
		
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
