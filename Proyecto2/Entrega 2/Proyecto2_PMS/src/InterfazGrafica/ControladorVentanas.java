package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import autenticador.AutenticadorDeUsuarios;
import controlador.Controlador;

public class ControladorVentanas
{
	public static final String EMPLEADO = "empleado";
	public static final String RECEPCIONISTA = "recepcionista";
	public static final String ADMIN = "admin";
	public static final Color BACK_COLOR = new Color(10, 28, 46);
	public static final Color TEXT_COLOR = new Color(229, 229, 229);
	public static final Color BUTTON_COLOR = new Color(0, 128, 128);
	
	private AutenticadorDeUsuarios autenticador;
	private Controlador controlador;
	private DialogInicial dialogInicial;
	private DialogRegistrar dialogRegistrar;
	private DialogLogin dialogLogin;
	private InterfazAdmin interfazAdmin;
	
	public ControladorVentanas()
	{

		autenticador = new AutenticadorDeUsuarios();
		controlador = new Controlador(this, autenticador);
		controlador.cargarDatos();

		dialogInicial = new DialogInicial(this, BACK_COLOR, TEXT_COLOR, BUTTON_COLOR);
	}

	public void dialogRegistrar()
	{
		dialogRegistrar	= new DialogRegistrar(this, autenticador, BACK_COLOR, TEXT_COLOR, BUTTON_COLOR);
	}

	public void dialogLogin()
	{
		dialogLogin	= new DialogLogin(this, autenticador, BACK_COLOR, TEXT_COLOR, BUTTON_COLOR);
	}

	public static void main(String[] args)
	{
		FlatLightLaf.install();
		new ControladorVentanas();
	}

	public void actualizar(String tipo) 
	{
		if (tipo.equals(EMPLEADO))
			iniciarInterfazEmpleado();
		else if (tipo.equals(RECEPCIONISTA))
			iniciarInterfazRecepcionista();
		else if (tipo.equals(ADMIN))
			iniciarInterfazAdmin();
	}

	private void iniciarInterfazAdmin() 
	{
		interfazAdmin = new InterfazAdmin(this); 
	}

	private void iniciarInterfazRecepcionista() 
	{
	
	}

	private void iniciarInterfazEmpleado() 
	{
	}
}
