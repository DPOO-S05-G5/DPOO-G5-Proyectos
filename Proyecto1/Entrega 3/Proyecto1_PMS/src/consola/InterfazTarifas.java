package consola;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.CoordinadorPMS;

public class InterfazTarifas extends Interfaz
{
	private  CoordinadorPMS coordinadorPMS;
	private String[] tiposHabitacion;
	private ArrayList<String> listaDiasSemana;
	private HashMap<String, Integer> mapaDiasSemana;
	private HashMap<Integer, Integer> mapaDiasMes;

	public InterfazTarifas(CoordinadorPMS coordinadorPMS) 
	{
		this.coordinadorPMS = coordinadorPMS;
		this.tiposHabitacion = new String[]{"estandar", "suite", "suitedoble"};
		
		this.listaDiasSemana = new ArrayList<String>();
		this.mapaDiasSemana = new HashMap<String, Integer>();
		
		listaDiasSemana.add("L");
		listaDiasSemana.add("M");
		listaDiasSemana.add("I");
		listaDiasSemana.add("J");
		listaDiasSemana.add("V");
		listaDiasSemana.add("S");
		listaDiasSemana.add("D");
		
		for (int i=0; i<7; i++)
		{
			mapaDiasSemana.put(listaDiasSemana.get(i), i);
		}
		
		this.mapaDiasMes = new HashMap<Integer, Integer>();
		int[] diasMes = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i=0; i<12; i++)
		{
			mapaDiasMes.put(i, diasMes[i]);
		}
	}

	@Override
	public void iniciarInterfaz()
	{
		System.out.println("\nTarifas");
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int seleccion = Integer.parseInt(input("Selecione una opción"));
				
				if (seleccion == 1)
					ejecutarCrearTarifa();
				else if (seleccion == 2)
					ejecutarSobreescribirTarifa();
				else if (seleccion == 3)
					ejecutarEliminarTarifas();
				else if (seleccion == 4)
				{
					System.out.println();
					continuar = false;
				}
				else
				{
					System.out.println("\nPor favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	private void ejecutarSobreescribirTarifa()
	{
		try 
		{
			String tipoHabitacion = input("Tipo de habitación (estandar / suite / suitedoble)").toLowerCase();
			int valorTarifa = Integer.parseInt(input("Nuevo valor de la tarifa"));
			String fechaInicialInput = input("Fecha inicial (dd-mm)");
			String fechaFinalInput = input("Fecha final (dd-mm)");
			String diasSemana = input("Dias de la semana (Formato: L-M-I-J-V-S-D)").toUpperCase();
			
			if (tipoHabitacion.equals(tiposHabitacion[0]) || tipoHabitacion.equals(tiposHabitacion[1]) || tipoHabitacion.equals(tiposHabitacion[2]))
			{
				String[] listaFechaI = fechaInicialInput.split("-");
				String[] listaFechaF = fechaFinalInput.split("-");
				
				ArrayList<Integer> fechaInicial = fechaAListaInt(listaFechaI);
				ArrayList<Integer> fechaFinal = fechaAListaInt(listaFechaF);
				
				String[] listaDiasIngresados = diasSemana.split("-");
				ArrayList<Integer> dias = new ArrayList<Integer>();
				for (String dia : listaDiasIngresados)
				{
					if (listaDiasSemana.contains(dia))
					{
						dias.add(mapaDiasSemana.get(dia));
					}
				}
				
				coordinadorPMS.eliminarTarifa(tipoHabitacion, fechaInicial, fechaFinal, dias);
				coordinadorPMS.addTarifa(tipoHabitacion, fechaInicial, fechaFinal, dias, valorTarifa);
			}
			else
			{
				System.out.println("Tipo de habitacion debe ser \"estandar\" o \"suite\" o \"suite doble\".");
				return;
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("El valor de la tarifa debe ser un valor numerico.");
			return;
		}
		
	}

	private void ejecutarCrearTarifa()
	{
		try 
		{
			String tipoHabitacion = input("Tipo de habitación (estandar / suite / suitedoble)").toLowerCase();
			int valorTarifa = Integer.parseInt(input("Valor de la tarifa"));
			String fechaInicialInput = input("Fecha inicial (dd-mm)");
			String fechaFinalInput = input("Fecha final (dd-mm)");
			String diasSemana = input("Dias de la semana (Formato: L-M-I-J-V-S-D)").toUpperCase();
			
			if (tipoHabitacion.equals(tiposHabitacion[0]) || tipoHabitacion.equals(tiposHabitacion[1]) || tipoHabitacion.equals(tiposHabitacion[2]))
			{
				String[] listaFechaI = fechaInicialInput.split("-");
				String[] listaFechaF = fechaFinalInput.split("-");
				
				ArrayList<Integer> fechaInicial = fechaAListaInt(listaFechaI);
				ArrayList<Integer> fechaFinal = fechaAListaInt(listaFechaF);
				
				String[] listaDiasIngresados = diasSemana.split("-");
				ArrayList<Integer> dias = new ArrayList<Integer>();
				for (String dia : listaDiasIngresados)
				{
					if (listaDiasSemana.contains(dia))
					{
						dias.add(mapaDiasSemana.get(dia));
					}
				}
				
				coordinadorPMS.addTarifa(tipoHabitacion, fechaInicial, fechaFinal, dias, valorTarifa);
			}
			else
			{
				System.out.println("Tipo de habitacion debe ser \"estandar\" o \"suite\" o \"suite doble\".");
				return;
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("El valor de la tarifa debe ser un valor numercio.");
			return;
		}
		
	}

	private void ejecutarEliminarTarifas()
	{
		try 
		{
			String tipoHabitacion = input("Tipo de habitación (estandar / suite / suitedoble)").toLowerCase();
			String fechaInicialInput = input("Fecha inicial (dd-mm)");
			String fechaFinalInput = input("Fecha final (dd-mm)");
			String diasSemana = input("Dias de la semana (Formato: L-M-I-J-V-S-D)").toUpperCase();
			
			if (tipoHabitacion.equals(tiposHabitacion[0]) || tipoHabitacion.equals(tiposHabitacion[1]) || tipoHabitacion.equals(tiposHabitacion[2]))
			{
				String[] listaFechaI = fechaInicialInput.split("-");
				String[] listaFechaF = fechaFinalInput.split("-");
				
				ArrayList<Integer> fechaInicial = fechaAListaInt(listaFechaI);
				ArrayList<Integer> fechaFinal = fechaAListaInt(listaFechaF);
				
				String[] listaDiasIngresados = diasSemana.split("-");
				ArrayList<Integer> dias = new ArrayList<Integer>();
				for (String dia : listaDiasIngresados)
				{
					if (listaDiasSemana.contains(dia))
					{
						dias.add(mapaDiasSemana.get(dia));
					}
				}
				if (fechaInicial != null && fechaFinal != null)
				coordinadorPMS.eliminarTarifa(tipoHabitacion, fechaInicial, fechaFinal, dias);
			}
			else
			{
				System.out.println("Tipo de habitacion debe ser \"estandar\" o \"suite\" o \"suite doble\".");
				return;
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("El valor de la tarifa debe ser un valor numercio.");
			return;
		}		
	}
	
	private ArrayList<Integer> fechaAListaInt(String[] lista)
	{
		ArrayList<Integer> listaFinal = new ArrayList<Integer>();
		
		int dia = Integer.parseInt(lista[0])-1;
		int mes = Integer.parseInt(lista[1])-1;
		
		if ((0 <= mes) && (mes < 12))
		{
			int diasMes = mapaDiasMes.get(mes);
			if ((0 <= dia) && (dia < diasMes))
			{
				listaFinal.add(mes);
				listaFinal.add(dia);
			}
			else
			{
				System.out.println("Dia no valido.");
				return null;
			}
		}
		else
		{
			System.out.println("Mes no valido.");
			return null;
		}
		return listaFinal;
	}

	@Override
	protected void mostrarMenu()
	{
		System.out.println("Opciones\n");
		System.out.println("1. Crear nueva tarifa");
		System.out.println("2. Sobreescribir tarifa");
		System.out.println("3. Eliminar tarifas");
		System.out.println("4. Salir");
	}

}
