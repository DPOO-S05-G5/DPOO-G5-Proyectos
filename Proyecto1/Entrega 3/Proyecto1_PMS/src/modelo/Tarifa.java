package modelo;

import java.util.HashMap;

public class Tarifa
{
	public static final String ESTANDAR = "estandar";
	public static final String SUITE = "suite";
	public static final String SUITE_DOBLE = "suitedoble";
	private static final String[] DIAS = {"L", "M", "I", "J", "V", "S", "D"};
	
	private Fecha fecha;
	private HashMap<String, HashMap<String, Integer>> mapaDiasSemana = crearMapaDiasSemana();
	
	public Tarifa()
	{
		
	}
	
	public Tarifa(Fecha fecha)
	{
		setFecha(fecha);
		crearMapaDiasSemana();
	}
	
	public Tarifa(Fecha fecha, HashMap<String, HashMap<String, Integer>> mapaDiasSemana)
	{
		this.fecha = fecha;
		this.mapaDiasSemana = mapaDiasSemana;
	}

	public Fecha getFecha()
	{
		return fecha;
	}

	public void setFecha(Fecha fecha)
	{
		this.fecha = fecha;
	}
	
	public HashMap<String, HashMap<String, Integer>> getMapaDiasSemana() 
	{
		return mapaDiasSemana;
	}

	public void setMapaDiasSemana(HashMap<String, HashMap<String, Integer>> mapaDiasSemana) 
	{
		this.mapaDiasSemana = mapaDiasSemana;
	}

	public void addTarifa(String dia, String tipo, int valor)
	{
		mapaDiasSemana.get(dia).replace(tipo, valor);
	}

	public void removeTarifa(String dia, String tipo)
	{
		mapaDiasSemana.get(dia).replace(tipo, null);
	}
	
	private HashMap<String, HashMap<String, Integer>> crearMapaDiasSemana()
	{
		mapaDiasSemana = new HashMap<String, HashMap<String, Integer>>();
		
		for (String dia : DIAS)
		{
			HashMap<String, Integer> mapaTipos = new HashMap<String, Integer>();
			mapaTipos.put(ESTANDAR, null);
			mapaTipos.put(SUITE, null);
			mapaTipos.put(SUITE_DOBLE, null);
			mapaDiasSemana.put(dia, mapaTipos);
		}
		
		return mapaDiasSemana;
	}
	
	public String infoTarifa() 
	{
		String info;
		
		info = toString() + "\n";
		info += mapaDiasSemana.toString();
		
		return info;
	}
	@Override
    public String toString() 
	{
        return "tarifa-" + fecha.toString();
    }
}
