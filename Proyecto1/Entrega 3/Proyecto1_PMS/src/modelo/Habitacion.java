package modelo;

import java.util.ArrayList;

public abstract class Habitacion
{
	private static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifas;
	private ArrayList<Cama> camas;
	private int capacidadAdultos;
	private int capacidadNinos;
	private static String tipo;
	private boolean tieneBalcon;
	private boolean tieneCocina;
	private boolean tieneVista;
	private String torre;
	private int piso;
	private String id;
	// TODO atributos que se necesiten para reservar o asociar huespedes si son necesarios
	
	
	public abstract String textoInformacion();
	
	public Habitacion()
	{
		
	}
	
	public Habitacion(boolean tieneBalcon, boolean tieneCocina, boolean tieneVista, String torre, int piso, String id)
	{
		super();
		this.tieneBalcon = tieneBalcon;
		this.tieneCocina = tieneCocina;
		this.tieneVista = tieneVista;
		this.torre = torre;
		this.piso = piso;
		this.id = id;
		
	}

	public static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> getTarifas()
	{
		return tarifas;
	}

	public static void setTarifas(ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifas)
	{
		Habitacion.tarifas = tarifas;
	}

	public ArrayList<Cama> getCamas()
	{
		return camas;
	}

	public void setCamas(ArrayList<Cama> camas)
	{
		this.camas = camas;
	}

	public int getCapacidadAdultos()
	{
		return capacidadAdultos;
	}

	public void setCapacidadAdultos(int capacidadAdultos)
	{
		this.capacidadAdultos = capacidadAdultos;
	}

	public int getCapacidadNinos()
	{
		return capacidadNinos;
	}

	public void setCapacidadNinos(int capacidadNinos)
	{
		this.capacidadNinos = capacidadNinos;
	}

	public static String getTipo()
	{
		return tipo;
	}

	public static void setTipo(String tipo)
	{
		Habitacion.tipo = tipo;
	}

	public boolean isTieneBalcon()
	{
		return tieneBalcon;
	}

	public void setTieneBalcon(boolean tieneBalcon)
	{
		this.tieneBalcon = tieneBalcon;
	}

	public boolean isTieneCocina()
	{
		return tieneCocina;
	}

	public void setTieneCocina(boolean tieneCocina)
	{
		this.tieneCocina = tieneCocina;
	}

	public boolean isTieneVista()
	{
		return tieneVista;
	}

	public void setTieneVista(boolean tieneVista)
	{
		this.tieneVista = tieneVista;
	}

	public String getTorre()
	{
		return torre;
	}

	public void setTorre(String torre)
	{
		this.torre = torre;
	}

	public int getPiso()
	{
		return piso;
	}

	public void setPiso(int piso)
	{
		this.piso = piso;
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
