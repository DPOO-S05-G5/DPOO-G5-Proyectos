package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {

	private String cedulaReservador;
	private int precioTotal;
	private LocalDate fechaInicial;
	private LocalDate fechaFinal;
	private int noches;
	private ArrayList<Habitacion> habitaciones;
	private int cantidadHuespedes;
	private Huesped reservador;
	private String id;
	
	public Reserva()
	{
		
	}
	
	public Reserva(Huesped huesped, int numHuespedes, int noches, LocalDate fechaInicial, ArrayList<Habitacion> habs)
	{
		this.cedulaReservador = huesped.getId();
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaInicial.plusDays(noches);
		this.noches = noches;
		this.habitaciones = habs;
		this.cantidadHuespedes = numHuespedes;
		this.reservador = huesped;
		this.id = huesped.getId();
		calcularPrecioTotal();
	}
	
	public String getCedulaReservador() {
		return cedulaReservador;
	}


	public void setCedulaReservador(String cedulaReservador) {
		this.cedulaReservador = cedulaReservador;
	}


	public int getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public void calcularPrecioTotal()
	{
		precioTotal = 0;
		LocalDate fechaEnRevision = fechaInicial;
		for (Habitacion hab : habitaciones)
		{
			if (hab instanceof HabitacionEstandar)
			{
				if (noches > 1)
				{
					while(!fechaEnRevision.equals(fechaFinal))
					{
						precioTotal += HabitacionEstandar.calcularTarifaFecha(fechaEnRevision);
						fechaEnRevision = fechaEnRevision.plusDays(1);
					}
				}
				else
					precioTotal += HabitacionEstandar.calcularTarifaFecha(fechaInicial);
			}
			
			else if (hab instanceof HabitacionSuite)
			{
				if (noches > 1)
				{
					while(!fechaEnRevision.equals(fechaFinal))
					{
						precioTotal += HabitacionSuite.calcularTarifaFecha(fechaEnRevision);
						fechaEnRevision = fechaEnRevision.plusDays(1);
					}
				}
				else
					precioTotal += HabitacionSuite.calcularTarifaFecha(fechaInicial);
			}
			else
			{
				if (noches > 1)
				{
					while(!fechaEnRevision.equals(fechaFinal))
					{
						precioTotal += HabitacionSuiteDoble.calcularTarifaFecha(fechaEnRevision);
						fechaEnRevision = fechaEnRevision.plusDays(1);
					}
				}
				else
					precioTotal += HabitacionSuiteDoble.calcularTarifaFecha(fechaInicial);
			}
		}	
			
	}


	public LocalDate getFechaInicial() {
		return fechaInicial;
	}


	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}


	public LocalDate getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}


	public void setHabitaciones(ArrayList<Habitacion> habitacion) {
		this.habitaciones = habitacion;
	}


	public int getCantidadHuespedes() {
		return cantidadHuespedes;
	}


	public void setCantidadHuespedes(int cantidadHuespedes) {
		this.cantidadHuespedes = cantidadHuespedes;
	}


	public Huesped getReservador() {
		return reservador;
	}


	public void setReservador(Huesped reservador) {
		this.reservador = reservador;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
