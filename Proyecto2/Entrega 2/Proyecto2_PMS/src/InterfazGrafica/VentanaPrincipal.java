package InterfazGrafica;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;


import autenticador.AutenticadorDeUsuarios;
import controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame
{
	private static final String EMPLEADO = "empleado";
	private static final String RECEPCIONISTA = "recepcionista";
	private static final String ADMIN = "admin";
	private static final Color FOREGROUND_COLOR = Color.WHITE;
	private static final Color BACKGROUND_COLOR = new Color(224,255,255);
	private static final Color BUTTON_COLOR = new Color(0,139,139);
	
	private Controlador controlador;
	private DialogInicial dialogInicial;
	private DialogRegistrar dialogRegistrar;
	private DialogLogin dialogLogin;
	
	public VentanaPrincipal()
	{
		dialogInicial = new DialogInicial(this, FOREGROUND_COLOR, BACKGROUND_COLOR, BUTTON_COLOR);
		
	}
	
	public static void main(String[] args)
	{
		new VentanaPrincipal();
	}

	public void dialogoRegistrar()
	{
		dialogRegistrar	= new DialogRegistrar(this, FOREGROUND_COLOR, BACKGROUND_COLOR, BUTTON_COLOR);
	}

	public void dialogLogin()
	{
		dialogLogin	= new DialogLogin(this, FOREGROUND_COLOR, BACKGROUND_COLOR, BUTTON_COLOR);
	}
}
