package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public class Calendario 
{
	private TreeMap<LocalDate, ArrayList<Reserva>> calendario;
	
	public Calendario()
	{
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
}
