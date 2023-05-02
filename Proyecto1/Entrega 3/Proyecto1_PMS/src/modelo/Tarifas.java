package modelo;

import java.util.Comparator;
import java.util.TreeMap;

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
				Fecha fecha = new Fecha(i+1, j+i);
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

	public void addTarifa(Tarifa tarifa)
	{
		Fecha fechaTarifa = tarifa.getFecha();
		arbolTarifas.put(fechaTarifa, tarifa);
	}
	
	public void replaceTarifa(Tarifa tarifa)
	{
		Fecha fechaTarifa = tarifa.getFecha();
		arbolTarifas.replace(fechaTarifa, tarifa);
	}
}