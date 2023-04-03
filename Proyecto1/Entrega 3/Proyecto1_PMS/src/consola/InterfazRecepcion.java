package consola;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import modelo.CoordinadorPMS;
import modelo.Habitacion;
import modelo.Huesped;
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
		String idHuesped =  input("Documento de ID");
		Huesped huesped = coordinadorPMS.getHuesped(idHuesped);
		Reserva reserva = coordinadorPMS.getReserva(idHuesped);
		
		String factura = coordinadorPMS.realizarTextoFactura(huesped)
		String facturaPagada = input("El huesped ya realizó el pago? (si / no)").toLowerCase();
		
		if (facturaPagada.equals("si"))
		{
			coordinadorPMS.cancelarReserva(huesped);
		}
		
	}

	private void ejecutarCancelarReserva()
	{
		String documentoHuesped = input("Documento de ID del huésped responsable");
		Huesped huesped = coordinadorPMS.getHuesped(documentoHuesped);
		if (tiempo <= 48)
		{
			coordinadorPMS.cancelarReserva(huesped);
		}
		else
		{
			System.out.println("La reserva está fuera del tiempo permitido para ser cancelada.");
		}	
		
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
				LinkedHashMap<Integer, Habitacion> habitacionesDisponibles = coordinadorPMS.getHabitacionesDesocupadas(numeroDeNoches-1, fechaHoy);
				String strHabitacionesDisponibles = "0. Cancelar\n";
				for (Entry<Integer, Habitacion> entry : habitacionesDisponibles.entrySet())
				{
					Habitacion hab = entry.getValue();
					strHabitacionesDisponibles += entry.getKey() + ": " + hab.toString() + "\n";
					
				}
				String[] habitacionesSeleccionadas = input("Seleccione las habitaciones deseadas (formato: 1-2-3...)").split("-");
				ArrayList<Integer> listaSeleccionadas = new ArrayList<Integer>();
				for (String seleccion : habitacionesSeleccionadas)
				{
					listaSeleccionadas.add(Integer.parseInt(seleccion));
				}
				
				Huesped huesped = coordinadorPMS.addHuespedResponsable(nombreHuespedResponsable, apellidosHuespedResponsable, documentoHuesped, correoHuesped, numeroCelular);
				coordinadorPMS.addReserva(huesped, totalHuespedes, numeroDeNoches-1, fechaHoy);
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("El numero de personas debe ser un valor numerico positivo");
		}
		
	}

	private void ejecutarInfoHabitacion()
	{
		String tipo = input("Tipo");
		String id = input("ID de la habitacion");
		Habitacion hab = coordinadorPMS.getHabitacion(tipo, id);
		System.out.println(hab.toString());
	}

	private void ejecutarInfoHuesped()
	{
		String idHuesped = input("ID del huesped responsable");
		Huesped huesped = coordinadorPMS.getHuesped(idHuesped);
		System.out.println(huesped.toString());
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
