package modelo;

public class Servicio {
	
	private boolean deSpa;
	private boolean deGuiaTuristico;
	private String nombre;
	private int precio;
	private String ID;
	private boolean disponibilidad;
	private int duracion;
	
	public Servicio()
	{
		
	}
	
	public Servicio(boolean deSpa, boolean deGuiaTuristico, String nombre, int precio, String iD,
			boolean disponibilidad, int duracion) {
		super();
		this.deSpa = deSpa;
		this.deGuiaTuristico = deGuiaTuristico;
		this.nombre = nombre;
		this.precio = precio;
		ID = iD;
		this.disponibilidad = disponibilidad;
		this.duracion = duracion;
	}

	public boolean isDeSpa() {
		return deSpa;
	}

	public void setDeSpa(boolean deSpa) {
		this.deSpa = deSpa;
	}

	public boolean isDeGuiaTuristico() {
		return deGuiaTuristico;
	}

	public void setDeGuiaTuristico(boolean deGuiaTuristico) {
		this.deGuiaTuristico = deGuiaTuristico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
}
