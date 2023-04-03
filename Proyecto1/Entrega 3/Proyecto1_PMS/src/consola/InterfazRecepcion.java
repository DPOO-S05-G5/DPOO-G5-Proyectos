package consola;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import modelo.CoordinadorPMS;
import modelo.Habitacion;
import modelo.HashMap;
import modelo.Reserva;
import modelo.String;

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
			String nombreHuespedResponsable = input("Nombre del huesped responsable");
			String apellidosHuespedResponsable = input("Apellidos del huesped responsable");
			String documentoHuesped = input("Documento de ID");
			String correoHuesped = input("Correo electronico");
			String numeroCelular = input("Numero de celular");
			int numeroDeNoches = Integer.parseInt(input("¿Cuantas noches?"));
			int totalHuespedes = Integer.parseInt(input("Numero de huespedes"));
			int huespedesNoAsignados = totalHuespedes;
			LinkedHashMap<Integer, Habitacion> habitacionesDisponibles = coordinadorPMS.getHabitacionesDesocupadas(numeroDeNoches-1, fechaHoy);
			
			if (habitacionesDisponibles != null)
			{
				String strHabitacionesDisponibles = "0. Cancelar\n";
				for (Entry<Integer, Habitacion> entry : habitacionesDisponibles.entrySet())
				{
					Habitacion hab = entry.getValue();
					strHabitacionesDisponibles += entry.getKey() + ": " + hab.toString() + "\n";
				}
				while(huespedesNoAsignados > 0)
				{
					System.out.println(strHabitacionesDisponibles);	
					System.out.println("Huespedes sin habitacion: " + huespedesNoAsignados);
					int seleccion = Integer.parseInt(input("Seleccione una habitacion"));
					if (seleccion == 0)
						break;
					
					Habitacion habitacion = habitacionesDisponibles.get(seleccion);
					if (habitacion != null)
					{
						int adultosAsignadosHab = 0;
						int niniosAsignadosHab = 0;
						
						if (huespedesNoAsignados == totalHuespedes)
						{
							agregarHuespedResponsable(habitacion.getTipo(), habitacion.getId(), nombreHuespedResponsable, apellidosHuespedResponsable, documentoHuesped, correoHuesped, numeroCelular);
							adultosAsignadosHab++;
							huespedesNoAsignados--;
						}
						
						while (true)
						{
							
							System.out.println("1. Agregar ocupante adulto");
							System.out.println("2. Agregar ocupante niño");
							System.out.println("3. Confirmar configuracion de habitacion");
							int seleccion2 = Integer.parseInt(input("Seleccionar una opcion"));
							if (seleccion2 == 1)
							{
								if((adultosAsignadosHab < habitacion.getCapacidadAdultos()) && (huespedesNoAsignados > 0))
								{	
									agregarHuesped(true, habitacion.getTipo(), habitacion.getId());
									huespedesNoAsignados--;
									adultosAsignadosHab++;
								}
							}
							else if (seleccion2 == 2)
							{
								if((niniosAsignadosHab < habitacion.getCapacidadNinos()) && (huespedesNoAsignados > 0))
								{
									agregarHuesped(false, habitacion.getTipo(), habitacion.getId());
									huespedesNoAsignados--;
									niniosAsignadosHab++;
								}
							}
							else
								break;
						}
					}
					else
						System.out.println("Opcion no valida.");
				}
			}
			else
				System.out.println("No hay habitaciones disponbles entre " + fechaHoy + " y " + fechaHoy.plusDays(numeroDeNoches-1));
		}
		catch (NumberFormatException e1)
		{
			System.out.println("El numero de personas debe ser un valor numerico positivo");
		}
	}

	private void agregarHuespedResponsable(String tipo, String id, String nombre,
			String apellidos, String idHuesped, String correo, String numeroCelular)
	{
		coordinadorPMS.addHuespedResponsable(tipo, id, nombre, apellidos, idHuesped, correo, numeroCelular);
		
	}

	private void agregarHuesped(boolean isAdulto, String tipo, String id)
	{
		String nombre = input("Nombre del huesped");
		String apellido = input("Apellidos del huesped");
		String idHuesped = input("Documento de identidad");
		
		coordinadorPMS.addHuesped(isAdulto, tipo, id, nombre, apellido, idHuesped);
		
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
				int totalHuespedes = Integer.parseInt(input("Numero de huespedes"));
					
				String strHabitacionesDisponibles = "0. Cancelar\n";
				for (Entry<Integer, Habitacion> entry : habitacionesDisponibles.entrySet())
				{
					Habitacion hab = entry.getValue();
					Habitacion tipo = getTipo(hab);
					Habitacion id = getId(hab)
					strHabitacionesDisponibles += entry.getKey() + ": " + hab.toString() + "\n";
					
				}
				Huesped huespedResponsable = coordinadorPMS.addHuespedResponsable(tipo, id, nombreHuespedResponsable, apellidosHuespedResponsable, documentoHuesped, correoHuesped, numeroCelular)
				Reserva reserva = coordinadorPMS.addReserva(huespedResponsable);
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("El numero de personas debe ser un valor numerico positivo");
		}
		
	}

	private void ejecutarInfoHabitacion()
	{
		try
		{
			while (true)
			{
				String nombreHuespedResponsable = input("Nombre del huesped responsable");
				for (Entry<Integer, Habitacion> entry : nombreHuespedResponsable.entrySet())
				{
					Habitacion hab = entry.getValue();
				}
			}
		}
		
	}

	private void ejecutarInfoHuesped()
	{
;
		try
		{
			while (true)
			{
				String nombreHuespedResponsable = input("Nombre del huesped responsable");
			}
		}
		
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
