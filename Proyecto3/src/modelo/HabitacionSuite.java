package modelo;

import java.util.ArrayList;

public class HabitacionSuite extends Habitacion
{
	private static final String TIPO = "suite";
	private static final String[] TIPOS_CAMA = {Cama.getDoble(), Cama.getSencilla(), Cama.getInfantil()};
	
	public HabitacionSuite()
	{
		
	}
	
	public HabitacionSuite(boolean cocina, boolean balcon, boolean vista, String torre, int piso, String id, int tamanoHab, boolean aire_acondicionado, boolean calefaccion, int tamanoCama, boolean tv, boolean cafetera, boolean ropCama_TapHipoaler, boolean plancha, boolean secadorPelo, int voltajeAC, boolean tomaUSBA, boolean tomaUSBC, boolean incluyeDesayuno)
	{
		super(TIPO, cocina, balcon, vista, torre, piso, id, tamanoHab, calefaccion, tamanoCama, tv, cafetera, ropCama_TapHipoaler, plancha, secadorPelo, voltajeAC, tomaUSBA, tomaUSBC, incluyeDesayuno);

		ArrayList<Cama> camas = new ArrayList<Cama>();
		for (String tipoCama : TIPOS_CAMA)
			camas.add(new Cama(tipoCama));
		super.setCamas(camas);
		
		int capacidadAdultos = 0;
		int capacidadNinos = 0;
		for (Cama cama : camas)
		{
			capacidadAdultos += cama.getCapacidadAdultos();
			capacidadNinos += cama.getCapacidadNinios();
		}
		super.setCapacidadAdultos(capacidadAdultos);
		super.setCapacidadNinios(capacidadNinos);
	}

}
