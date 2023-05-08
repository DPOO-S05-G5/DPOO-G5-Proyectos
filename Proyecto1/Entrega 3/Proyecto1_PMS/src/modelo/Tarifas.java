package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import salvador.SalvadorDeDatos;

public class Tarifas
{
	private static final int MESES = 12;
	private static final int[] DIASXMES = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private TreeMap<Fecha, Tarifa> arbolTarifas;
	
	public Tarifas()
	{
		setArbolTarifas(new TreeMap<Fecha, Tarifa>(new Comparator<Fecha>()
		{

			@Override
			public int compare(Fecha f1, Fecha f2)
			{
				if (f1.getMes() > f2.getMes())
					return 1;
				if (f1.getMes() < f2.getMes())
					return -1;
				if (f1.getMes() == f2.getMes())
					if (f1.getDia() > f2.getDia())
						return 1;
					if (f1.getDia() < f2.getDia())
						return -1;
				return 0;
			}
			
		}));
		
		crearTarifasEnArbol();
	}

	private void crearTarifasEnArbol()
	{
		for (int i=0; i<MESES; i++)
		{
			for (int j=0; j<DIASXMES[i]; j++)
			{
				Fecha fecha = new Fecha(i+1, j+1);
				Tarifa tarifa = new Tarifa(fecha);
				arbolTarifas.put(fecha, tarifa);
			}
		}
	}

	public TreeMap<Fecha, Tarifa> getArbolTarifas()
	{
		return arbolTarifas;
	}

	public void setArbolTarifas(TreeMap<Fecha, Tarifa> arbolTarifas)
	{
		this.arbolTarifas = arbolTarifas;
	}	
	

	public ArrayList<Tarifa> addTarifa(String tipo, int valor, ArrayList<Integer> fechaInicial, ArrayList<Integer> fechaFinal,
			ArrayList<String> diasTarifa) 
	{
		ArrayList<Tarifa> tarifasEditadas = new ArrayList<Tarifa>();
		
		Fecha fechaI = new Fecha(fechaInicial.get(0), fechaInicial.get(1));
		Fecha fechaF = new Fecha(fechaFinal.get(0), fechaFinal.get(1));
		NavigableMap<Fecha, Tarifa> fechasEnRango = arbolTarifas.subMap(fechaI, true, fechaF, true);
		
		for (Entry<Fecha, Tarifa> entry : fechasEnRango.entrySet())
		{
			Tarifa tarifa = entry.getValue();
			for (String dia : diasTarifa)
				tarifa.addTarifa(dia, tipo, valor);
			tarifasEditadas.add(tarifa);
		}
		
		for (Entry<Fecha, Tarifa> entry: arbolTarifas.entrySet())
		{
			System.out.println(entry.getValue().infoTarifa());
		}
		
		return tarifasEditadas;
	}
	
	public void replaceTarifa(String tipo, int valor, ArrayList<Integer> fechaInicial, ArrayList<Integer> fechaFinal,
			ArrayList<String> diasTarifa)
	{
		addTarifa(tipo, valor, fechaInicial, fechaFinal, diasTarifa);
	}

	public ArrayList<Tarifa> removeTarifa(String tipo, ArrayList<Integer> fechaInicial, ArrayList<Integer> fechaFinal,
			ArrayList<String> diasTarifa)
	{
		ArrayList<Tarifa> tarifasEditadas = new ArrayList<Tarifa>();
		
		Fecha fechaI = new Fecha(fechaInicial.get(0), fechaInicial.get(1));
		Fecha fechaF = new Fecha(fechaFinal.get(0), fechaFinal.get(1));
		NavigableMap<Fecha, Tarifa> fechasEnRango = arbolTarifas.subMap(fechaI, true, fechaF, true);
		
		for (Entry<Fecha, Tarifa> entry : fechasEnRango.entrySet())
		{
			Tarifa tarifa = entry.getValue();
			for (String dia : diasTarifa)
				tarifa.removeTarifa(dia, tipo);
			tarifasEditadas.add(tarifa);
		}
		
		for (Entry<Fecha, Tarifa> entry: arbolTarifas.entrySet())
		{
			System.out.println(entry.getValue().infoTarifa());
		}
		
		return tarifasEditadas;
	}
}