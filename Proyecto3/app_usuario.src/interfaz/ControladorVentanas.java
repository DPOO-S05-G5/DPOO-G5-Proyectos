package interfaz;

import java.awt.Color;

import autenticador.AutenticadorDeUsuarios;
import controlador.Controlador;
import interfazGrafica.DialogInicial;

public class ControladorVentanas 
{
    public static final Color BACK_COLOR = new Color(10, 28, 46);
	public static final Color TEXT_COLOR = new Color(229, 229, 229);
	public static final Color BUTTON_COLOR = new Color(0, 128, 128);
	
	private AutenticadorDeUsuarios autenticador;
	private Controlador controlador;
    private DialogInicial dialogInicial;

    
    public ControladorVentanas()
	{

		autenticador = new AutenticadorDeUsuarios();
		controlador = new Controlador(this, autenticador);
		controlador.cargarDatos();

		dialogInicial = new DialogInicial(this, BACK_COLOR, TEXT_COLOR, BUTTON_COLOR);
	}

}
