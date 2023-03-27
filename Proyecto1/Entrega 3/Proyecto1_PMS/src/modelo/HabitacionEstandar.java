package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class HabitacionEstandar extends Habitacion
{
	private static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifas;
	private static String tipo;
	private ArrayList<Cama> camas;
	private int capacidadAdultos;
	private int capacidadNinos;
	private boolean tieneBalcon;
	private boolean tieneCocina;
	private boolean tieneVista;
	private String torre;
	private int piso;
	private String id;
	
	
	public HabitacionEstandar()
	{
		super();
	}
	
	public HabitacionEstandar(boolean tieneBalcon, boolean tieneCocina, boolean tieneVista, String torre, int capacidad, String id)
	{
		super(tieneBalcon, tieneCocina, tieneVista, torre, capacidad, id);
		HabitacionEstandar.tarifas = new ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>();
		HabitacionEstandar.tipo = "estandar";
		this.camas = new ArrayList<Cama>();
		Cama cama1 = new Cama("doble");
		camas.add(cama1);
		super.setCapacidadAdultos(cama1.getCapacidadAdultos());
		super.setCapacidadNinos(cama1.getCapacidadNinos());
	}
	
	@Override
	public String textoInformacion()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
