package modelo;

import java.util.ArrayList;

public class Huesped {
	
	private String id;
	private String nombres;
	private String apellidos;
	private String correo;
	private String numeroCelular;
	private ArrayList<Habitacion> habs;
	
	public Huesped()
	{
		
	}
	
	public Huesped(String nombres, String apellidos, String id, String correo, String numeroCelular,
			ArrayList<Habitacion> habs)
	{
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.numeroCelular = numeroCelular;
		this.habs = habs;
	}
	
	public Huesped(String nombres, String apellidos, String id, String correo, String numeroCelular)
	{
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.numeroCelular = numeroCelular;
	}

	public Huesped(String nombres, String apellidos, String idHuesped, ArrayList<Habitacion> habs)
	{
		this.id = idHuesped;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.habs = habs;
		
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
	public ArrayList<Habitacion> getHabitaciones()
	{
		return habs;
	}
	public void setHabitaciones(ArrayList<Habitacion> habs)
	{
		this.habs = habs;
	}
}
