package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {

	private String cedulaReservador;
	private int precioTotal;
	private LocalDate fechaInicial;
	private LocalDate fechaFinal;
	private ArrayList<Habitacion> habitaciones;
	private int cantidadHuespedes;
	private Huesped reservador;
	
	public Reserva()
	{
		
	}
	
	public Reserva(Huesped huesped, int numHuespedes, int noches, LocalDate fechaInicial)
	{
		this.cedulaReservador = huesped.getId();
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaInicial.plusDays(noches);
		this.cantidadHuespedes = numHuespedes;
		this.reservador = huesped;
		
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
}
