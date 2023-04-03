package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Habitacion
{
	private String tipo;
	private boolean tieneCocina;
	private boolean tieneBalcon;
	private boolean tieneVista;
	private String torre;
	private int piso;
	private String ID;
	private ArrayList<Cama> camas;
	private int capacidadAdultos;
	private int capacidadNinos;
	private Huesped huespedReserva;
	private HashMap<String, Huesped> huespedesAdultos;
	private HashMap<String, Huesped> huespedesNinios;
	private HashMap<String, Reserva> reservas;
	
	
	public Habitacion()
	{
		
	}
	
	public Habitacion(String tipo, boolean tieneCocina, boolean tieneBalcon, boolean tieneVista, String torre, int piso, String id)
	{
		super();
		this.tipo = tipo;
		this.tieneCocina = tieneCocina;
		this.tieneBalcon = tieneBalcon;
		this.tieneVista = tieneVista;
		this.torre = torre;
		this.piso = piso;
		this.ID = id;
		this.huespedesAdultos = new HashMap<String, Huesped>();
		this.huespedesNinios = new HashMap<String, Huesped>();
		this.reservas = new HashMap<String, Reserva>();
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

	public void setID(String id)
	{
		this.ID = id;
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
	
	public String getUbicacion()
	{
		return "Habitacion " + ID +" -> Torre: " + torre + ", Piso: " + piso;
	}

	@Override
	public String toString() 
	{
		return "Habitacion [tieneCocina=" + tieneCocina + ", tieneBalcon=" + tieneBalcon + ", tieneVista=" + tieneVista
				+ ", torre=" + torre + ", piso=" + piso + ", id=" + ID + ", camas=" + camas + ", capacidadAdultos="
				+ capacidadAdultos + ", capacidadNinos=" + capacidadNinos + "]";
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public Huesped getHuespedReserva()
	{
		return huespedReserva;
	}

	public void setHuespedReserva(Huesped huespedReserva)
	{
		this.huespedReserva = huespedReserva;
	}

	public HashMap<String, Reserva> getReservas()
	{
		return reservas;
	}

	public void setReservas(HashMap<String, Reserva> reservas)
	{
		this.reservas = reservas;
	}

	public HashMap<String, Huesped> getHuespedesAdultos()
	{
		return huespedesAdultos;
	}

	public void setHuespedesAdultos(HashMap<String, Huesped> huespedesAdultos)
	{
		this.huespedesAdultos = huespedesAdultos;
	}
	
	public void addHuespedAdulto(Huesped huesped)
	{
		huespedesAdultos.put(huesped.getId(), huesped);
	}

	public HashMap<String, Huesped> getHuespedesNinios()
	{
		return huespedesNinios;
	}

	public void setHuespedesNinios(HashMap<String, Huesped> huespedesNinios)
	{
		this.huespedesNinios = huespedesNinios;
	}
	
	public void addHuespedNinio(Huesped huesped)
	{
		huespedesNinios.put(huesped.getId(), huesped);
	}
}
