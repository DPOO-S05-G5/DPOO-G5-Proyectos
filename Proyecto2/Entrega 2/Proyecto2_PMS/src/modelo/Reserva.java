package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva
{
	private Huesped reservador;
	private String cedulaReservador;
	private String id;
	private LocalDate fechaInicial;
	private LocalDate fechaFinal;
	private int precioTotal;
	private ArrayList<Habitacion> habitaciones;
	
	public Reserva()
	{
		
	}

	public Reserva(Huesped reservador, LocalDate fechaInicial, LocalDate fechaFinal, ArrayList<Habitacion> habitaciones, int precioTotal)
	{
		this.reservador = reservador;
		this.cedulaReservador = reservador.getId();
		this.id = cedulaReservador + "-" + fechaInicial.toString();
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.habitaciones = habitaciones;
		this.precioTotal = precioTotal;
	}

    public Huesped getReservador()
	{
		return reservador;
	}

	public void setReservador(Huesped reservador)
	{
		this.reservador = reservador;
	}

	public String getCedulaReservador()
	{
		return cedulaReservador;
	}

	public void setCedulaReservador(String cedulaReservador)
	{
		this.cedulaReservador = cedulaReservador;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}	

	public LocalDate getFechaInicial()
	{
		return fechaInicial;
	}

	public void setFechaInicial(LocalDate fechaInicial)
	{
		this.fechaInicial = fechaInicial;
	}

	public LocalDate getFechaFinal()
	{
		return fechaFinal;
	}

	public void setFechaFinal(LocalDate fechaFinal)
	{
		this.fechaFinal = fechaFinal;
	}

	public int getPrecioTotal()
	{
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal)
	{
		this.precioTotal = precioTotal;
	}

	public ArrayList<Habitacion> getHabitaciones()
	{
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones)
	{
		this.habitaciones = habitaciones;
	}

	public int getNumeroHabEstandar() 
	{
		int contador = 0;
        for (Habitacion habitacion : habitaciones)
		{
			if (habitacion instanceof HabitacionEstandar)
				contador ++;
		}
		return contador;
	}

	public int getNumeroHabSuite() 
	{
        int contador = 0;
        for (Habitacion habitacion : habitaciones)
		{
			if (habitacion instanceof HabitacionSuite)
				contador ++;
		}
		return contador;
    }

    public int getNumeroHabSuiteDoble() 
	{
        int contador = 0;
        for (Habitacion habitacion : habitaciones)
		{
			if (habitacion instanceof HabitacionSuiteDoble)
				contador ++;
		}
		return contador;
    }

	public void agregarHuesped(Huesped huesped)
	{
		for (Habitacion hab : habitaciones)
		{
			if (hab.getHuespedes().size() < hab.getCapacidadAdultos() + hab.getCapacidadNinios())
			{
				hab.getHuespedes().put(huesped.getId(), huesped);
				break;
			}
		}
	}
}
