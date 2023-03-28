package modelo;

import java.util.ArrayList;

public abstract class Habitacion
{
	private boolean tieneCocina;
	private boolean tieneBalcon;
	private boolean tieneVista;
	private String torre;
	private int piso;
	private String ID;
	private ArrayList<Cama> camas;
	private int capacidadAdultos;
	private int capacidadNinos;
	
	public abstract void addTarifa(int mes, int diaMes, int diaSemana, int tarifa);
	
	public Habitacion()
	{
		
	}
	
	public Habitacion(boolean tieneCocina, boolean tieneBalcon, boolean tieneVista, String torre, int piso, String iD)
	{
		super();
		this.tieneCocina = tieneCocina;
		this.tieneBalcon = tieneBalcon;
		this.tieneVista = tieneVista;
		this.torre = torre;
		this.piso = piso;
		ID = iD;
	}

	public ArrayList<Cama> getCamas()
	{
		return camas;
	}

	public void setCamas(ArrayList<Cama> camas)
	{
		this.camas = camas;
	}

	public boolean isTieneCocina()
	{
		return tieneCocina;
	}

	public void setTieneCocina(boolean tieneCocina)
	{
		this.tieneCocina = tieneCocina;
	}

	public boolean isTieneBalcon()
	{
		return tieneBalcon;
	}

	public void setTieneBalcon(boolean tieneBalcon)
	{
		this.tieneBalcon = tieneBalcon;
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

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
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
}
