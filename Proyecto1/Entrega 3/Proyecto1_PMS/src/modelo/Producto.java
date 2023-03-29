package modelo;

import java.util.ArrayList;

public abstract class Producto {
	
	private String nombre;
	private String ID;
	private String precio;
	private int horaInicial;
	private int horaFinal;
	private boolean servicioComedor;
	private boolean servicioHabitacion;
	
	
	
	public int getHoraInicial() {
		return horaInicial;
	}


	public void setHoraInicial(int horaInicial) {
		this.horaInicial = horaInicial;
	}


	public int getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}


	public Producto(String nombre, String ID, String precio,boolean servicioComedor,boolean servicioHabitacion)
	{
		
	super();
	this.nombre = nombre;
	this.ID = ID;
	this.precio = precio;
	this.servicioComedor = servicioComedor;
	this.servicioHabitacion = servicioHabitacion;
	
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public boolean isServicioComedor() {
		return servicioComedor;
	}


	public void setServicioComedor(boolean servicioComedor) {
		this.servicioComedor = servicioComedor;
	}


	public boolean isServicioHabitacion() {
		return servicioHabitacion;
	}


	public void setServicioHabitacion(boolean servicioHabitacion) {
		this.servicioHabitacion = servicioHabitacion;
	}
	
	
}
