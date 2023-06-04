package interfazAppHuesped;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import autenticador.AutenticadorDeUsuarios;
import controlador.Controlador;
import interfazGrafica.ControladorVentanas;
import interfazGrafica.DialogInicial;
import interfazGrafica.DialogLogin;
import modelo.CoordinadorPMS;
import modelo.Habitacion;

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
		interfazHuesped.dispose();
		dialogInicial = new DialogInicial(this, BACK_COLOR, TEXT_COLOR, BUTTON_COLOR);
	}

	@Override
	public JPanel filtrarFechas(ActionListener padre, String fechaInicial, String fechaFinal) {
		
		ArrayList<Habitacion> habs = controlador.getHabitacionesDisponibles(fechaInicial, fechaFinal);
		int rows = (int) Math.ceil(habs.size() / 6.0);
		int cols = rows * 6;
		JPanel panelDisponibles = new JPanel(new GridLayout(rows, cols));
		JButton botonHab;

		for (Habitacion hab : habs)
		{
			botonHab = new JButton(hab.toString());
			botonHab.setBackground(BUTTON_COLOR);
			botonHab.setForeground(TEXT_COLOR);
			botonHab.addActionListener(padre);
			String actionCommand = "Hab-" + hab.getId();
			botonHab.setActionCommand(actionCommand);

			panelDisponibles.add(botonHab);
		}

		return panelDisponibles;
		
	}



	@Override
	public String getInfoHabitacion(String id) {
		return controlador.getInfoHabitacion(id);
	}

	@Override
	public String getTipoHabitacion(String id) {
		return controlador.getTipoHabitacion(id);
	}

	@Override
	public void pagarHab(String id, String fechaInicial, String fechaFinal) {

		controlador.pagarHabitacion(id, fechaInicial, fechaFinal);
	}

	@Override
	public void reservarHab(String id, String fechaInicial, String fechaFinal) {

		controlador.reservarHabitacion(id, fechaInicial, fechaFinal);
	}

}
