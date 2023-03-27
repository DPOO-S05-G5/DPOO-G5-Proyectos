package consola;

import java.util.ArrayList;

public class InterfazTarifas extends Interfaz
{

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
			String tipoHabitacion = input("Tipo de habitación (estandar / suite / suitedoble)");
			int valorTarifa = Integer.parseInt(input("Valor de la tarifa"));
			String fechaInicial = input("Fecha inicial");
			String fechaFinal = input("Fecha final");
			String diasSemana = input("Dias de la semana (Formato: L.M.I.J.V.S.D)");
		}
		catch (NumberFormatException e)
		{
			System.out.println("El valor de la tarifa debe ser un valor numercio.");
		}
		
		// TODO Enviar información al coordinador/controlador para crear las tarifas
	}
	
	private void ejecutarEliminarTarifa()
	{
		try
		{
			String tipoHabitacion = input("Tipo de habitación de la tarifa que desea eliminar (estandar / suite / suitedoble)");
			
			// TODO mostrar tarifas existentes para el tipo de habitación
			
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
