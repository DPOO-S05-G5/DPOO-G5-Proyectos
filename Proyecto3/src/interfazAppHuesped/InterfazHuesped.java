package interfazAppHuesped;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfazGrafica.ControladorVentanas;
import interfazGrafica.DialogHabitacion;
public class InterfazHuesped extends JFrame implements ActionListener {
	
	public static final String FILTRAR = "Filtrar fechas";
	public static final String RESERVAR = "Reservar";
	public static final String PAGAR = "Pagar";
	public static final String CANCELAR = "Cancelar";
	public static final String MIS_RESERVAS = "Mis reservas";
	public static final String LOGOUT = "Cerrar sesión";
	
	private ControladorVentanas controladorVentanas;
	private Color backColor;
	private Color textColor;
	private Color buttonColor;

    private JPanel westPanel;
    private JPanel eastPanel;

    private JButton filtrarFechasButton;
    private JButton misReservasButton;
    private JButton logoutButton;

	private String fechaInicial;
	private String fechaFinal;

	public InterfazHuesped(ControladorVentanasApp controladorVentanas) {
		
		setTitle("Bienvenido al hotel Villa Uniandes");
		this.controladorVentanas = controladorVentanas;
        backColor = ControladorVentanasApp.BACK_COLOR;
        textColor = ControladorVentanasApp.TEXT_COLOR;
        buttonColor = ControladorVentanasApp.BUTTON_COLOR;
		
        setLayout(new BorderLayout());
        setBackground(backColor);
        setForeground(textColor);

		setWestPanel();
        setEastPanel();

		add(westPanel, BorderLayout.WEST);
        add(eastPanel, BorderLayout.EAST);
		setSize(1200, 800);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void setWestPanel() {
		
		JPanel westPanelButtons = new JPanel();
		westPanelButtons.setBackground(backColor);
		westPanelButtons.setForeground(textColor);
		westPanelButtons.setLayout(new BoxLayout(westPanelButtons, BoxLayout.Y_AXIS));
		
		filtrarFechasButton = new JButton(FILTRAR);
		filtrarFechasButton.addActionListener(this);
		filtrarFechasButton.setActionCommand(FILTRAR);
		filtrarFechasButton.setForeground(getForeground());
		filtrarFechasButton.setBackground(buttonColor);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(backColor);
		panel1.add(filtrarFechasButton);
		westPanelButtons.add(panel1);
		
		misReservasButton = new JButton(MIS_RESERVAS);
		misReservasButton.addActionListener(this);
		misReservasButton.setActionCommand(MIS_RESERVAS);
		misReservasButton.setForeground(getForeground());
		misReservasButton.setBackground(buttonColor);

		JPanel panel2 = new JPanel();
		panel2.setBackground(backColor);
		panel2.add(misReservasButton);
		westPanelButtons.add(panel2);

		logoutButton = new JButton(LOGOUT);
		logoutButton.addActionListener(this);
		logoutButton.setActionCommand(LOGOUT);
		logoutButton.setForeground(getForeground());
		logoutButton.setBackground(buttonColor);

		JPanel panel3 = new JPanel();
		panel3.setBackground(backColor);
		panel3.add(logoutButton);
		westPanelButtons.add(panel3);

		westPanel = new JPanel();
		westPanel.setLayout(new GridBagLayout());
		westPanel.setBackground(backColor);
		westPanel.setForeground(textColor);
		westPanel.add(westPanelButtons);
	}
	
	public void setEastPanel() {
		
		eastPanel = new JPanel(new GridLayout(4, 6));
		eastPanel.setBackground(backColor);
		eastPanel.setForeground(textColor);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		
		if (comando.equals(FILTRAR)) {
			JDialog dialogFiltrarFechas = new DialogFiltrarFechas(this, backColor, textColor, buttonColor);
		} 
		else if (comando.equals(MIS_RESERVAS)) {
			misReservas();
		}
		else if (comando.equals(LOGOUT)) {
			controladorVentanas.logout();
			dispose();
		}
		else if (comando.startsWith("Hab-")) {
			String[] parts = comando.split("-");
			String id = parts[1];
			String info = controladorVentanas.getInfoHabitacion(id);
			String tipo = controladorVentanas.getTipoHabitacion(id);
			JDialog dialogHabitacion = new DialogHabitacion(this, backColor, textColor, buttonColor, id, info, tipo); 
		}		
	}

	private void misReservas() {

		eastPanel.removeAll();
		// TODO Mostrar reservas del usuario

	}

	public void filtrarFechas(String fechaInicial, String fechaFinal) {

		eastPanel.removeAll();
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		eastPanel.add(controladorVentanas.filtrarFechas(this, fechaInicial, fechaFinal));
	}

	public void pagarHab(String idHabitacion) {

		controladorVentanas.pagarHab(idHabitacion, fechaInicial, fechaFinal);
	}

    public void reservarHab(String idHabitacion) {

		controladorVentanas.reservarHab(idHabitacion, fechaInicial, fechaFinal);
    }

}
