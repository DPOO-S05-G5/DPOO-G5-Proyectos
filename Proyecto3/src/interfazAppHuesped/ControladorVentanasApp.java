package interfazAppHuesped;

import java.awt.Color;
import com.formdev.flatlaf.FlatLightLaf;

import autenticador.AutenticadorDeUsuarios;
import controlador.Controlador;
import interfazGrafica.ControladorVentanas;
import interfazGrafica.DialogInicial;
import interfazGrafica.DialogLogin;
import modelo.CoordinadorPMS;

public class ControladorVentanasApp implements ControladorVentanas
{
	public static final String EMPLEADO = "empleado";
	public static final String RECEPCIONISTA = "recepcionista";
	public static final String ADMIN = "admin";
	public static final String HUESPED = "huesped";
	public static final String ESTANDAR = "estandar";
	public static final String SUITE = "suite";
	public static final String SUITEDOBLE = "suitedoble";
	public static final Color BACK_COLOR = new Color(10, 28, 46);
	public static final Color TEXT_COLOR = new Color(229, 229, 229);
	public static final Color BUTTON_COLOR = new Color(0, 128, 128);
	
	private AutenticadorDeUsuarios autenticador;
	private Controlador controlador;
	private DialogInicial dialogInicial;
	private DialogRegistrarHuesped dialogRegistrar;
	private DialogLogin dialogLogin;
	private InterfazHuesped interfazHuesped;
	
	public ControladorVentanasApp()
	{

		autenticador = new AutenticadorDeUsuarios();
		controlador = new Controlador(this, autenticador);
		controlador.cargarDatos();

		dialogInicial = new DialogInicial(this, BACK_COLOR, TEXT_COLOR, BUTTON_COLOR);
	}

	public void dialogRegistrar()
	{
		dialogRegistrar	= new DialogRegistrarHuesped(this, autenticador, BACK_COLOR, TEXT_COLOR, BUTTON_COLOR);
	}
	
	@Override
	public void dialogLogin()
	{
		dialogLogin	= new DialogLogin(this, autenticador, BACK_COLOR, TEXT_COLOR, BUTTON_COLOR);
	}

	public static void main(String[] args)
	{
		FlatLightLaf.install();
		new ControladorVentanasApp();
	}

	public void iniciarInterfazHuesped() 
	{
		interfazHuesped = new InterfazHuesped(this); 
	}

	@Override
    public CoordinadorPMS getCoordinadorPMS()
	{
        return controlador.getCoordinadorPMS();
    }

	@Override
	public void actualizar(String tipo) {
		
		iniciarInterfazHuesped();
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		interfazHuesped.dispose();
		dialogInicial = new DialogInicial(this, BACK_COLOR, TEXT_COLOR, BUTTON_COLOR);
	}

}
