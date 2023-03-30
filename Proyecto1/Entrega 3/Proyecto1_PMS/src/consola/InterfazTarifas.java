package consola;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.CoordinadorPMS;

public class InterfazTarifas extends Interfaz
{
	private  CoordinadorPMS coordinadorPMS;
	private String[] tiposHabitacion;
	private ArrayList<String> listaDias;
	private HashMap<String, Integer> mapaDias;
	private HashMap<Integer, Integer> mapaDiasMes;

	public InterfazTarifas(CoordinadorPMS coordinadorPMS) 
	{
		this.coordinadorPMS = coordinadorPMS;
		this.tiposHabitacion = new String[]{"estandar", "suite", "suitedoble"};
		
		this.listaDias = new ArrayList<String>();
		this.mapaDias = new HashMap<String, Integer>();
		
		listaDias.add("D");
		listaDias.add("L");
		listaDias.add("M");
		listaDias.add("I");
		listaDias.add("J");
		listaDias.add("V");
		listaDias.add("S");
		
		for (int i=0; i<7; i++)
		{
			mapaDias.put(listaDias.get(i), i);
		}
		
		this.mapaDiasMes = new HashMap<Integer, Integer>();
		int[] diasMes = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i=0; i<12; i++)
		{
			mapaDiasMes.put(i+1, diasMes[i]);
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
					ejecutarEditarTarifa();
				else if (seleccion == 3)
					ejecutarEliminarTarifa();
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
					if (listaDias.contains(dia))
					{
						dias.add(mapaDias.get(dia));
					}
				}
				
				coordinadorPMS.addTarifa(tipoHabitacion, fechaInicial, fechaFinal, dias, valorTarifa);
			}
			else
			{
				System.out.println("Tipo de habitacion debe ser \"estandar\" o \"suite\" o \"suite doble\".");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("El valor de la tarifa debe ser un valor numercio.");
		}
		
	}

	private void ejecutarEliminarTarifa()
	{
		try
		{
			String tipoHabitacion = input("Tipo de habitación de la tarifa que desea eliminar (estandar / suite / suitedoble)").toLowerCase();
			if (tipoHabitacion.equals(tiposHabitacion[0]) || tipoHabitacion.equals(tiposHabitacion[1]) || tipoHabitacion.equals(tiposHabitacion[2]))
			{
				ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifas = coordinadorPMS.getTarifas(tipoHabitacion);
				int tarifaSeleccionada = Integer.parseInt(input("Seleccione la tarifa para eliminar"));
				coordinadorPMS.eliminarTarifa(tarifaSeleccionada);
			}
			else
			{
				System.out.println("Tipo de habitacion debe ser  \"estandar\" o \"suite\" o \"suite doble\".");
			}
			
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}		
	}

	private void ejecutarEditarTarifa()
	{
		String tipoHabitacion = input("Tipo de habitación de la tarifa que desea editar (estandar / suite / suitedoble)");
				
		try
		{
			if (tipoHabitacion.equals(tiposHabitacion[0]) || tipoHabitacion.equals(tiposHabitacion[1]) || tipoHabitacion.equals(tiposHabitacion[2]))
			{
				ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> tarifas = coordinadorPMS.getTarifas(tipoHabitacion);
			}
			else
			{
				System.out.println("Tipo de habitacion debe ser  \"estandar\" o \"suite\" o \"suite doble\".");
			}
		}
		catch (NumberFormatException e1)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
		
		menuAtributosTarifa();
		String atributosACambiar = input("Seleccione los atributos que desea editar (Formato: 1,2,3,4)");
		String[] stringListAtributosACambiar = atributosACambiar.split(",");
		
		ArrayList<Integer> listAtributosACambiar = new ArrayList<Integer>();
		for (String s : stringListAtributosACambiar)
		{
			try
			{	
				int i = Integer.parseInt(s);
				if ((0 < i) && (i < 5))
					listAtributosACambiar.add(Integer.parseInt(s));
				else
					System.out.println("No hay opción " + i + '.');
			}
			catch (NumberFormatException e2)
			{
				System.out.println("Debe seleccionar los números de las opciones (Formato: 1,2,3,4).");
				break;
			}
		}
		
		for (int seleccion : listAtributosACambiar)
		{
			ejecutarCambiarAtributo(seleccion, tipoHabitacion);
		}
	}

	private void ejecutarCambiarAtributo(int seleccion, String tipoHabitacion)
	{
		if (seleccion == 1)
			ejecutarCambiarValorTarifa(tipoHabitacion);
		else if (seleccion == 2)
			ejecutarCambiarFechaInicial(tipoHabitacion);
		else if (seleccion == 3)
			ejecutarCambiarFechaFinal(tipoHabitacion);
		else
			ejecutarCambiarDiasSemana(tipoHabitacion);
	}

	private void ejecutarCambiarDiasSemana(String tipoHabitacion)
	{
		String diasSemana = input("Dias de la semana donde se aplica la tarifa (Formato: L-M-I-J-V-S-D)");
		String[] listaDiasSemana = diasSemana.split("-");
		ArrayList<Integer> dias = new ArrayList<Integer>();
		for (String dia : listaDiasSemana)
		{
			if (listaDias.contains(dia))
			{
				dias.add(mapaDias.get(dia));
			}
		}
		coordinadorPMS.cambiarDiasSemanaTarifa(tipoHabitacion, dias);
	}

	private void ejecutarCambiarFechaFinal(String tipoHabitacion)
	{
		// TODO Auto-generated method stub
		String fechaFinal = input("Nueva fecha final (dd-mm)");
		String[] listaFecha = fechaFinal.split("-");
		ArrayList<Integer> fecha = fechaAListaInt(listaFecha);
		
	}

	private void ejecutarCambiarFechaInicial(String tipoHabitacion)
	{
		// TODO Auto-generated method stub
		String fechaInicial = input("Nueva fecha inicial (dd-mm)");
		String[] listaFecha = fechaInicial.split("-");
		ArrayList<Integer> fecha = fechaAListaInt(listaFecha);
	}

	private void ejecutarCambiarValorTarifa(String tipoHabitacion)
	{
		// TODO Auto-generated method stub
		int valorTarifa = Integer.parseInt(input("Nuevo valor de la tarifa"));
		
	}
	
	private ArrayList<Integer> fechaAListaInt(String[] lista)
	{
		ArrayList<Integer> listaFinal = new ArrayList<Integer>();
		
		int dia = Integer.parseInt(lista[0]);
		int mes = Integer.parseInt(lista[1]);
		
		if ((0 < mes) && (mes <= 12))
		{
			int diasMes = mapaDiasMes.get(mes);
			if ((0 < dia) && (dia <= diasMes))
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
		System.out.println("2. Editar tarifa");
		System.out.println("3. Eliminar tarifa");
		System.out.println("4. Salir");
	}
	
	private void menuAtributosTarifa()
	{
		System.out.println("Atributos:");
		System.out.println("1. Valor de la tarfia");
		System.out.println("2. Fecha inicial");
		System.out.println("3. Fecha final");
		System.out.println("4. Dias de la semana");
	}

}
