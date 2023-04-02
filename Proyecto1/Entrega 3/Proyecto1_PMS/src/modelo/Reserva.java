package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Reserva {

	private int cedulaReservador;
	private int precioTotal;
	private LocalDate fechaInicial;
	private LocalDate fechaFinal;
	private ArrayList<Habitacion> habitacion;
	private int cantidadHuespedes;
	private Huesped Reservador;
	
	
	public int getCedulaReservador() {
		return cedulaReservador;
	}


	public void setCedulaReservador(int cedulaReservador) {
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


	public ArrayList<Habitacion> getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(ArrayList<Habitacion> habitacion) {
		this.habitacion = habitacion;
	}


	public int getCantidadHuespedes() {
		return cantidadHuespedes;
	}


	public void setCantidadHuespedes(int cantidadHuespedes) {
		this.cantidadHuespedes = cantidadHuespedes;
	}


	public Huesped getReservador() {
		return Reservador;
	}


	public void setReservador(Huesped reservador) {
		Reservador = reservador;
	}


	public Reserva()
	{
		
	}
	
	
	
	
}
