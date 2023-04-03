package modelo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
public class HabitacionEstandar extends Habitacion
{
	private static final String TIPO = "estandar";
	private static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifas = crearListaTarifas();

	public HabitacionEstandar()
	{
		
	}
	
	public HabitacionEstandar(boolean tieneCocina, boolean tieneBalcon, boolean tieneVista, String torre, int piso,
			String iD)
	{
		super(TIPO, tieneCocina, tieneBalcon, tieneVista, torre, piso, iD);

		ArrayList<Cama> camas = new ArrayList<Cama>(Arrays.asList(new Cama("doble")));
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
		System.out.println("TARIFAS ESTANDAR");
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
		HabitacionEstandar.tarifas = tarifas;
	}

	public static void addTarifa(int mes, int diaMes, int diaSemana, int tarifa)
	{
		ArrayList<ArrayList<ArrayList<Integer>>> listaDiasDelMes = tarifas.get(mes);
		
		ArrayList<ArrayList<Integer>> listaDiaDeMes = listaDiasDelMes.get(diaMes);
		
		ArrayList<Integer> listaDiasSemana = listaDiaDeMes.get(diaSemana);
		
		listaDiasSemana.add(tarifa);
		listaDiasSemana.sort(null);
	}
	

	public static void removeTarifa(int mes, int diaMes, int diaSemana)
	{
		ArrayList<ArrayList<ArrayList<Integer>>> listaDiasDelMes = tarifas.get(mes);
		
		ArrayList<ArrayList<Integer>> listaDiaDeMes = listaDiasDelMes.get(diaMes);
		
		ArrayList<Integer> listaDiasSemana = listaDiaDeMes.get(diaSemana);
		listaDiasSemana.clear();
	}
	
	public static int calcularTarifaFecha(LocalDate fecha)
	{
		int mes = fecha.getMonthValue()-1;
		int diaMes = fecha.getDayOfMonth()-1;
		DayOfWeek diaSemana = fecha.getDayOfWeek();
		int diaSemanaInt = diaSemana.getValue()-1;
		
		ArrayList<ArrayList<ArrayList<Integer>>> listaDiasDelMes = tarifas.get(mes);
		
		ArrayList<ArrayList<Integer>> listaDiaDeMes = listaDiasDelMes.get(diaMes);
		
		ArrayList<Integer> listaDiasSemana = listaDiaDeMes.get(diaSemanaInt);
		
		return listaDiasSemana.get(0);
	}
	
//	public static void main(String[] args)
//	{
//		System.out.println(HabitacionEstandar.getTarifas());
//		
//		HabitacionEstandar room1 = new HabitacionEstandar(false, false, false, "A", 1, "101A");
//		HabitacionEstandar room2 = new HabitacionEstandar(true, false, false, "A", 1, "102A");
//		HabitacionEstandar room3 = new HabitacionEstandar(false, true, false, "A", 2, "201A");
//		HabitacionEstandar room4 = new HabitacionEstandar(true, true, true, "B", 6, "601B");
//		HabitacionEstandar room5 = new HabitacionEstandar(false, false, false, "B", 1, "101B");
//		HabitacionEstandar room6 = new HabitacionEstandar(false, false, false, "C", 3, "301C");
//		
//		HabitacionEstandar.addTarifa(0, 0, 0, 7);
//		HabitacionEstandar.addTarifa(0, 0, 0, 10);
//		HabitacionEstandar.addTarifa(0, 0, 0, 1);
//		HabitacionEstandar.addTarifa(0, 0, 0, 6);
//		System.out.println(HabitacionEstandar.getTarifas());
//		
//		ArrayList<HabitacionEstandar> rooms = new ArrayList<HabitacionEstandar>(Arrays.asList(room1, room2, room3, room4, room5, room6));
//		
//		try
//		{
//			FileOutputStream fos = new FileOutputStream("data/tarifasHabitacionesEstandar.xml");
//			XMLEncoder encoder = new XMLEncoder(fos);
//			encoder.writeObject(tarifas);
//			encoder.close();
//			fos.close();
//			
//			fos = new FileOutputStream("data/habitacionesEstandar.xml");
//			encoder = new XMLEncoder(fos);
//			
//			for (HabitacionEstandar room : rooms)
//			{
//				encoder.writeObject(room);
//			}
//			encoder.close();
//			fos.close();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		
//		ArrayList<HabitacionEstandar> roomsLoaded = new ArrayList<HabitacionEstandar>();
//		
//		try
//		{
//			Object obj;
//			FileInputStream fis = new FileInputStream("data/tarifasHabitacionesEstandar.xml");
//			XMLDecoder decoder = new XMLDecoder(fis);
//			
//			obj = decoder.readObject();
//			if (obj instanceof ArrayList)
//			{
//				HabitacionEstandar.setTarifas((ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>) obj);
//			}
//			else
//			{
//				System.err.println("No esta la lista en el archivo");
//			}
//			decoder.close();
//			fis.close();
//			
//			fis = new FileInputStream("data/habitacionesEstandar.xml");
//			decoder = new XMLDecoder(fis);
//			
//			while (true)
//			{
//				try
//				{
//					obj = decoder.readObject();
//					
//					if (obj instanceof HabitacionEstandar)
//					{
//						HabitacionEstandar room = (HabitacionEstandar) obj;
//						roomsLoaded.add(room);
//					}
//					else
//					{
//						System.err.println("objecto inesperado en el archivo");
//					}
//				}
//				catch (ArrayIndexOutOfBoundsException e3)
//				{
//					break;
//				}
//			}
//			decoder.close();
//			fis.close();
//		}
//		catch (FileNotFoundException e2)
//		{
//			return;
//		}
//		catch (IOException e1)
//		{
//			e1.printStackTrace();
//		}
//		
//		for (HabitacionEstandar room : roomsLoaded)
//		{
//			System.out.println(room.getId());
//		}
//		
//		System.out.println(HabitacionEstandar.getTarifas());
//		
//	}

}
