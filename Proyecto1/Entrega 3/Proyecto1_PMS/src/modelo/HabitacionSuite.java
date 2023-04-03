package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class HabitacionSuite extends Habitacion {
	
	private static final String TIPO = "suite";
	private static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifas = crearListaTarifas();

	public HabitacionSuite() {
		// TODO Auto-generated constructor stub
	}

	public HabitacionSuite(boolean tieneCocina, boolean tieneBalcon, boolean tieneVista, String torre, int piso,
			String iD) {
		super(TIPO, tieneCocina, tieneBalcon, tieneVista, torre, piso, iD);
		
		ArrayList<Cama> camas = new ArrayList<Cama>(Arrays.asList(new Cama("doble"), new Cama("sencilla"), new Cama("nino")));
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
		HabitacionSuite.tarifas = tarifas;
	}

	public static void addTarifa(int mes, int diaMes, int diaSemana, int tarifa)
	{
		ArrayList<ArrayList<ArrayList<Integer>>> listaDiasDelMes = tarifas.get(mes);
		
		ArrayList<ArrayList<Integer>> listaDiaDeMes = listaDiasDelMes.get(diaMes);
		
		ArrayList<Integer> listaDiasSemana = listaDiaDeMes.get(diaSemana);
		
		listaDiasSemana.add(tarifa);
		listaDiasSemana.sort(null);
		System.out.println(tarifas);
	}

	public static void removeTarifa(int mes, int diaMes, int diaSemana)
	{
		ArrayList<ArrayList<ArrayList<Integer>>> listaDiasDelMes = tarifas.get(mes);
		
		ArrayList<ArrayList<Integer>> listaDiaDeMes = listaDiasDelMes.get(diaMes);
		
		ArrayList<Integer> listaDiasSemana = listaDiaDeMes.get(diaSemana);
		
		listaDiasSemana.clear();

		System.out.println(tarifas);
		
	}
	
	public static int calcularTarifaFecha(LocalDate fecha)
	{
		int tarifa = 0;
		return tarifa;
	}

}
