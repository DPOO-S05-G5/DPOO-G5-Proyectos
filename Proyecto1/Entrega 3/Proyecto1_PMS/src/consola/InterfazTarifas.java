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
			String fechaInicial = input("Fecha inicial (dd-mm)");
			String fechaFinal = input("Fecha final (dd-mm)");
			String diasSemana = input("Dias de la semana (Formato: L-M-I-J-V-S-D)").toUpperCase();
			if (tipoHabitacion.equals(tiposHabitacion[0]) || tipoHabitacion.equals(tiposHabitacion[1]) || tipoHabitacion.equals(tiposHabitacion[2]))
			{
				String[] listaFechaI = fechaInicial.split("-");
				String[] listaFechaF = fechaFinal.split("-");
				String[] listaDiasIngresados = diasSemana.split("-");
				ArrayList<Integer> dias = new ArrayList<Integer>();
				for (String dia : listaDiasIngresados)
				{
					if (listaDias.contains(dia))
					{
						dias.add(mapaDias.get(dia));
					}
				}
				
				coordinadorPMS.addTarifa(tipoHabitacion, listaFechaI, listaFechaF, dias);
			}
			else
			{
				System.out.println("Tipo de habitacion debe ser  \"estandar\" o \"suite\" o \"suite doble\".");
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
				coordinadorPMS.mostrarTarifas(tipoHabitacion);
			}
			else
			{
				System.out.println("Tipo de habitacion debe ser  \"estandar\" o \"suite\" o \"suite doble\".");
			}
			
			
			int tarifaSeleccionada = Integer.parseInt(input("Seleccione la tarifa para eliminar"));
			// TODO Eliminar la tarifa elegida
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}		
	}

	private void ejecutarEditarTarifa()
	{
		String tipoHabitacion = input("Tipo de habitación de la tarifa que desea editar (estandar / suite / suitedoble)");
		
		// TODO mostrar tarifas existentes para el tipo de habitación
		
		try
		{
			int tarifaSeleccionada = Integer.parseInt(input("Seleccione la tarifa para editar"));
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
			ejecutarCambiarAtributo(seleccion);
		}
	}

	private void ejecutarCambiarAtributo(int seleccion)
	{
		if (seleccion == 1)
			ejecutarCambiarValorTarifa();
		else if (seleccion == 2)
			ejecutarCambiarFechaInicial();
		else if (seleccion == 3)
			ejecutarCambiarFechaFinal();
		else
			ejecutarCambiarDiasSemana();
	}

	private void ejecutarCambiarDiasSemana()
	{
		// TODO Auto-generated method stub
		String diasSemana = input("Dias de la semana donde se aplica la tarifa (Formato: L.M.I.J.V.S.D)");
	}

	private void ejecutarCambiarFechaFinal()
	{
		// TODO Auto-generated method stub
		String fechaFinal = input("Nueva fecha final");
	}

	private void ejecutarCambiarFechaInicial()
	{
		// TODO Auto-generated method stub
		String fechaInicial = input("Nueva fecha inicial");
	}

	private void ejecutarCambiarValorTarifa()
	{
		// TODO Auto-generated method stub
		int valorTarifa = Integer.parseInt(input("Nuevo valor de la tarifa"));		
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
