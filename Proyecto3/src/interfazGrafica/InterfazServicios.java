package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JComboBox;
import javax.swing.JPanel;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterfazServicios extends JFrame implements ActionListener {

	private ControladorVentanasPMS padre;
	private Color backColor;
	private Color textColor;
	private Color buttonColor;
	
	
	private JPanel centerPanel;
	JLabel opciones;
	JComboBox<String> opcionesC;
	
	public InterfazServicios (ControladorVentanasPMS ventanaPrincipal)
	{
		centerPanel = new JPanel();
		centerPanel.setBackground(backColor);
	    centerPanel.setForeground(textColor);
		
		opciones = new JLabel ("Seleccione una opción");
		opciones.setForeground(textColor);
		opciones.setBackground(backColor);
		
		opcionesC = new JComboBox<String>();
		opcionesC.addItem("Registrar Consumo");
		opcionesC.addItem("Go to restaurante");
		opcionesC.addActionListener(this);
		centerPanel.add(opciones);
		centerPanel.add(opcionesC);
		
		setLayout(new BorderLayout());
        setBackground(backColor);
        setForeground(textColor);
        

		add(centerPanel, BorderLayout.CENTER);

		setTitle("Portal de Servicios");
		setSize(400, 120);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command =  e.getActionCommand();
	}

}
