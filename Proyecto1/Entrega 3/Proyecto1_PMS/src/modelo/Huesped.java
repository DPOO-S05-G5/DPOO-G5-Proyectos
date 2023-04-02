package modelo;

public class Huesped {
	
	private String id;
	private String nombres;
	private String apellidos;
	private String correo;
	private String numeroCelular;
	private String idHabitacion;
	private int idReserva;
	
	public Huesped()
	{
		
	}
	
	public Huesped(String id, String nombres, String apellidos, String correo, String numeroCelular,
			String idHabitacion, int idReserva)
	{
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.numeroCelular = numeroCelular;
		this.idHabitacion = idHabitacion;
		this.idReserva = idReserva;
	}

	public Huesped(String idHuesped, String nombres, String apellidos, String idHabitacion, int idReserva)
	{
		this.id = idHuesped;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.idHabitacion = idHabitacion;
		this.setIdReserva(idReserva);
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getNombres()
	{
		return nombres;
	}
	public void setNombres(String nombres)
	{
		this.nombres = nombres;
	}
	public String getApellidos()
	{
		return apellidos;
	}
	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}
	public String getCorreo()
	{
		return correo;
	}
	public void setCorreo(String correo)
	{
		this.correo = correo;
	}
	public String getNumeroCelular()
	{
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular)
	{
		this.numeroCelular = numeroCelular;
	}
	public String getIdHabitacion()
	{
		return idHabitacion;
	}
	public void setIdHabitacion(String idHabitacion)
	{
		this.idHabitacion = idHabitacion;
	}

	public int getIdReserva()
	{
		return idReserva;
	}

	public void setIdReserva(int idReserva)
	{
		this.idReserva = idReserva;
	}

}
