package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Calendario 
{
	private TreeMap<LocalDate, ArrayList<Reserva>> calendario;
	private CoordinadorPMS coordinadorPMS;

	public Calendario(CoordinadorPMS coordinadorPMS)
	{

		this.coordinadorPMS = coordinadorPMS;
		setCalendario(new TreeMap<LocalDate, ArrayList<Reserva>>(new Comparator<LocalDate>()
		{
			@Override
			public int compare(LocalDate f1, LocalDate f2)
			{
				return f1.compareTo(f2);
			}
		}));
	}

	public TreeMap<LocalDate, ArrayList<Reserva>> getCalendario() {
		return calendario;
	}

	public void setCalendario(TreeMap<LocalDate, ArrayList<Reserva>> calendario) {
		this.calendario = calendario;
	}
	
	public void addReserva(Reserva reserva)
	{
		LocalDate fechaInicial = reserva.getFechaInicial();
		LocalDate fechaFinal = reserva.getFechaFinal();
		
		for (LocalDate fecha = fechaInicial; fecha.isBefore(fechaFinal.plusDays(1)); fecha = fecha.plusDays(1))
		{
			if (!calendario.containsKey(fecha))
				calendario.put(fecha, new ArrayList<Reserva>());
			ArrayList<Reserva> reservas = calendario.get(fecha);
			reservas.add(reserva);
		}
	}

	public boolean revisarDisponibilidad(int numeroHabEstandar, int numeroHabSuite, int numeroHabSuiteDoble,
			LocalDate fechaI, LocalDate fechaF)
	{
		boolean disponible = true;
		
		NavigableMap<LocalDate, ArrayList<Reserva>> fechasEnRango = calendario.subMap(fechaI, true, fechaF, true);
		
		for (Entry<LocalDate, ArrayList<Reserva>> entry : fechasEnRango.entrySet())
		{
			int contadorHabEstandar = 0;
			int contadorHabSuite = 0;
			int contadorHabSuiteDoble = 0;

			ArrayList<Reserva> reservas = entry.getValue();
			for (Reserva reserva : reservas)
			{
				contadorHabEstandar += reserva.getNumeroHabEstandar();
				contadorHabSuite += reserva.getNumeroHabSuite();
				contadorHabSuiteDoble += reserva.getNumeroHabSuiteDoble();
			}
			
			int disponiblesHabEstandar = coordinadorPMS.getCantidadTiposHabitacion().get(CoordinadorPMS.ESTANDAR) - contadorHabEstandar;
			if (disponiblesHabEstandar < numeroHabEstandar)
			{
				disponible = false;
				break;
			}

			int disponiblesHabSuite = coordinadorPMS.getCantidadTiposHabitacion().get(CoordinadorPMS.SUITE) - contadorHabSuite;
			if (disponiblesHabSuite < numeroHabSuite)
			{
				disponible = false;
				break;
			}

			int disponiblesHabSuiteDoble = coordinadorPMS.getCantidadTiposHabitacion().get(CoordinadorPMS.SUITE_DOBLE) - contadorHabSuiteDoble;
			if (disponiblesHabSuiteDoble < numeroHabSuiteDoble)
			{
				disponible = false;
				break;
			}
		}
		
		return disponible;
	}

    public void eliminarReserva(Reserva reserva)
	{
		LocalDate fechaInicial = reserva.getFechaInicial();
		LocalDate fechaFinal = reserva.getFechaFinal();

		NavigableMap<LocalDate, ArrayList<Reserva>> fechasEnRango = calendario.subMap(fechaInicial, true, fechaFinal, true);

		for (Entry<LocalDate, ArrayList<Reserva>> entry : fechasEnRango.entrySet())
		{
			ArrayList<Reserva> reservas = entry.getValue();
			reservas.remove(reserva);
			
		}
    }
}
