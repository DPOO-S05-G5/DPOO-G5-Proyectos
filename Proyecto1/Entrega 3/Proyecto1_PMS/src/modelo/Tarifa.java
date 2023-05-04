package modelo;

import java.util.HashMap;

public class Tarifa
{
	private static final String[] DIAS = {"L", "M", "I", "J", "V", "S", "D"};
	
	private Fecha fecha;
	private HashMap<String, Integer> mapaDiasSemana;
	
	public Tarifa()
	{
		crearMapaDiasSemana();
	}
	
	public Tarifa(Fecha fecha)
	{
		setFecha(fecha);
		crearMapaDiasSemana();
	}
	
	public Tarifa(Fecha fecha, HashMap<String, Integer> mapaDiasSemana)
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

	public HashMap<String, Integer> getMapaDiasSemana()
	{
		return mapaDiasSemana;
	}

	public void setMapaTarifasDiaSemana(HashMap<String, Integer> mapaTarifasDiaSemana)
	{
		this.mapaDiasSemana = mapaTarifasDiaSemana;
	}
	
	public void addTarifa(String dia, int valor)
	{
		mapaDiasSemana.replace(dia, valor);
	}
	
	private void crearMapaDiasSemana()
	{
		mapaDiasSemana = new HashMap<String, Integer>();
		
		for (String dia : DIAS)
		{
			mapaDiasSemana.put(dia, 0);
		}
	}

    public String toString() 
	{
        return "tarifa-" + fecha.toString();
    }
}
