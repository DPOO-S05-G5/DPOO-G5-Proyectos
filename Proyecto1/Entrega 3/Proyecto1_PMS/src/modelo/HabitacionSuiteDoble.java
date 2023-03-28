package modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class HabitacionSuiteDoble extends Habitacion
{
	private static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifas = crearListaTarifas();
	private static String tipo = "suitedoble";

	public HabitacionSuiteDoble()
	{
		// TODO Auto-generated constructor stub
	}
	
	public HabitacionSuiteDoble(boolean tieneCocina, boolean tieneBalcon, boolean tieneVista, String torre, int piso,
			String iD)
	{
		super(tieneCocina, tieneBalcon, tieneVista, torre, piso, iD);

		ArrayList<Cama> camas = new ArrayList<Cama>(Arrays.asList(new Cama("doble"), new Cama("doble"), new Cama("sofacama")));
		super.setCamas(camas);
		
		int capacidadAdultos = 0;
		int capacidadNinos = 0;
		for (Cama cama : camas)
		{
			capacidadAdultos += cama.getCapacidadAdultos();
			capacidadNinos += cama.getCapacidadNinos();
		}
		super.setCapacidadAdultos(capacidadAdultos);
		super.setCapacidadNinos(capacidadNinos);
	}
	
	private static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> crearListaTarifas()
	{
		int meses = 12;
		int[] diasPorMes = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int diasSemana = 7;
		ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> listaTarifas = new ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>(meses);
		
		for (int i=0; i<meses; i++)
		{
			ArrayList<ArrayList<ArrayList<Integer>>> listaDiasDelMes = new ArrayList<ArrayList<ArrayList<Integer>>>(diasPorMes[i]);
			
			for (int j=0; j<diasPorMes[i]; j++)
			{
				ArrayList<ArrayList<Integer>> listaDiaDelMes = new ArrayList<ArrayList<Integer>>(diasSemana);
				
				for (int k=0; k<diasSemana; k++)
				{
					listaDiaDelMes.add(new ArrayList<Integer>());
				}
				listaDiasDelMes.add(listaDiaDelMes);
			}
			listaTarifas.add(listaDiasDelMes);
			System.out.println("Mes: "+ i + " size: " + listaDiasDelMes.size());
		}
		
		System.out.println("Meses: " + listaTarifas.size());
		
		return listaTarifas;
	}

	public static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> getTarifas()
	{
		return tarifas;
	}

	public static void setTarifas(ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifas)
	{
		HabitacionSuiteDoble.tarifas = tarifas;
	}

	public static void addTarifa(int mes, int diaMes, int diaSemana, int tarifa)
	{
		
		
	}

	public static String getTipo()
	{
		return tipo;
	}

	public static void setTipo(String tipo)
	{
		HabitacionSuiteDoble.tipo = tipo;
	}
	
	public static void main(String[] args)
	{
		System.out.println(HabitacionEstandar.getTarifas());
	}

}
