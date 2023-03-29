package modelo;

public class Producto {
	
	private String nombre;
	private String ID;
	private int precio;
	private int horaInicial;
	private int horaFinal;
	private boolean servicioComedor;
	private boolean servicioHabitacion;
	private boolean esPostre;
	private boolean esBebida;
	private boolean esPlato;
	
	public Producto()
	{
		
	}
	
	public Producto(String nombre, String iD, int precio, int horaInicial, int horaFinal, boolean servicioComedor,
			boolean servicioHabitacion, String tipo) {
		super();
		this.nombre = nombre;
		ID = iD;
		this.precio = precio;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.servicioComedor = servicioComedor;
		this.servicioHabitacion = servicioHabitacion;
		if (tipo.equals("plato"))
		{
			setEsPlato(true);
			setEsPostre(false);
			setEsBebida(false);
		}
		else if (tipo.equals("bebida"))
		{
			setEsPlato(false);
			setEsPostre(false);
			setEsBebida(true);
		}
		else
		{
			setEsPlato(false);
			setEsPostre(true);
			setEsBebida(false);
		}
	}


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


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
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


	public boolean isEsPostre() {
		return esPostre;
	}


	public void setEsPostre(boolean esPostre) {
		this.esPostre = esPostre;
	}


	public boolean isEsBebida() {
		return esBebida;
	}


	public void setEsBebida(boolean esBebida) {
		this.esBebida = esBebida;
	}


	public boolean isEsPlato() {
		return esPlato;
	}


	public void setEsPlato(boolean esPlato) {
		this.esPlato = esPlato;
	}
	
	
}
