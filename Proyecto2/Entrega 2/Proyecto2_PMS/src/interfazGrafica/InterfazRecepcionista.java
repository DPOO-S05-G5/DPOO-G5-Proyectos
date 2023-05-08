package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")

public class InterfazRecepcionista extends JFrame implements ActionListener
{
	private ControladorVentanas padre;
	private Controlador controlador;
	private Color backColor;
	private Color textColor;
	private Color buttonColor;
	
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel northPanel;
	JLabel nombreHuesped, apellidoHuesped, idHuesped, correoHuesped, fechaInicio, fechaFinal, numeroHuespedes, numEstandar, numSuite, numDoble;
	JTextField nombreHuespedTF, apellidoHuespedTF, idHuespedTF, correoHuespedTF, fechaInicioTF, fechaFinalTF;
	JComboBox<Integer> numeroHuespedesC, numEstandarC, numSuiteC, numDobleC;
	private JFrame infohuesped;
	
	private static final String ADD_RESERVA = "Realizar reserva";
	private static final String CHECK_IN = "Check-In";
	private static final String CHECK_OUT = "Check-Out";
	
	JButton reservaButton;
	JButton check_outButton;
	
	
	
	
	public InterfazRecepcionista(ControladorVentanas ventanaPrincipal, Controlador controlador)
    {
        setTitle("Recepcionista");
        this.controlador = controlador;
        padre = ventanaPrincipal;
        
        backColor = ControladorVentanas.BACK_COLOR;
        textColor = ControladorVentanas.TEXT_COLOR;
        buttonColor = ControladorVentanas.BUTTON_COLOR;
        
        setLayout(new BorderLayout());
        setBackground(backColor);
        setForeground(textColor);
        
        
        
        setCenterPanel();
        setSouthPanel();

		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		setSize(1000, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	private void setCenterPanel()
	{
		centerPanel = new JPanel();
		centerPanel.setSize(400, 300);
		centerPanel.setBackground(backColor);
		centerPanel.setForeground(textColor);
		
		centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));

		nombreHuesped = new JLabel("Nombre Huesped Responsable:");
		nombreHuesped.setForeground(textColor);
		nombreHuesped.setBackground(backColor);
		//nombreHuesped.setBounds(4, 8, 14, 10);
		nombreHuespedTF = new JTextField(20);
		nombreHuespedTF.setForeground(backColor);
		nombreHuespedTF.setBackground(textColor);
		//nombreHuespedTF.setBounds(10, 8, 14, 10);
		
		
		apellidoHuesped = new JLabel("Apellido Huesped Responsable:");
		apellidoHuesped.setForeground(textColor);
		apellidoHuesped.setBackground(backColor); 
		//apellidoHuesped.setBounds(40, 120,180, 20);
		apellidoHuespedTF = new JTextField(20);
		apellidoHuespedTF.setForeground(backColor);
		apellidoHuespedTF.setBackground(textColor); 
		//apellidoHuespedTF.setBounds(100, 120, 180, 20);
		  
		
		  idHuesped = new JLabel("Documento de ID:");
		  idHuesped.setForeground(textColor); 
		  idHuesped.setBackground(backColor);
		  //idHuesped.setBounds(40, 160, 180, 20); 
		  idHuespedTF = new JTextField();
		  idHuespedTF.setForeground(backColor);
		  idHuespedTF.setBackground(textColor);
		  //idHuesped.setBounds(100, 160, 180, 20);
		  
		  correoHuesped = new JLabel("Correo electrónico:");
		  correoHuesped.setForeground(textColor);
		  correoHuesped.setBackground(backColor); 
		  //correoHuesped.setBounds(40, 200, 180,20); 
		  correoHuespedTF = new JTextField();
		  correoHuespedTF.setForeground(backColor);
		  correoHuespedTF.setBackground(textColor); 
		  //correoHuespedTF.setBounds(100, 200, 180, 20);
		  
		  fechaInicio = new JLabel("Fecha inicial (aaaa-mm-dd)");
		  fechaInicio.setForeground(textColor); 
		  fechaInicio.setBackground(backColor);
		  //fechaInicio.setBounds(40, 240, 180, 20); 
		  fechaInicioTF = new JTextField();
		  fechaInicioTF.setForeground(backColor);
		  fechaInicioTF.setBackground(textColor); 
		  //fechaInicio.setBounds(100, 240, 180,20);
		  
		  fechaFinal = new JLabel("Fecha final (aaaa-mm-dd)");
		  fechaFinal.setForeground(textColor); 
		  fechaFinal.setBackground(backColor);
		  //fechaFinal.setBounds(40, 280, 180, 20); 
		  fechaFinalTF = new JTextField();
		  fechaFinalTF.setForeground(backColor); 
		  fechaFinalTF.setBackground(textColor);
		  //fechaFinalTF.setBounds(100, 280, 180, 20);
		  
		  numeroHuespedes = new JLabel("Cantidad de huespedes: ");
		  //numeroHuespedes.setBounds(40, 320, 180, 20);
		  numeroHuespedes.setForeground(textColor);
		  numeroHuespedes.setBackground(backColor);
		  numeroHuespedesC = new JComboBox<Integer>();
		  
		  //numeroHuespedesC.setBounds(100, 320, 40, 20);
		  numEstandar = new JLabel("¿Cuántas Habitaciones Estándar?");
		  numEstandar.setForeground(textColor);
		  numEstandar.setBackground(backColor);
		  numEstandarC = new JComboBox<Integer>();
		  
		  numSuite = new JLabel("¿Cuántas Habitaciones Suite?");
		  numSuite.setForeground(textColor);
		  numSuite.setBackground(backColor);
		  numSuiteC = new JComboBox<Integer>();
		  
		  numDoble = new JLabel("¿Cuántas Habitaciones Suite?");
		  numDoble.setForeground(textColor);
		  numDoble.setBackground(backColor);
		  numDobleC = new JComboBox<Integer>();
		  
		  for(int f=0;f<=20;f++) 
		  { 
			  numeroHuespedesC.addItem(f);
			  numEstandarC.addItem(f);
			  numSuiteC.addItem(f);
			  numDobleC.addItem(f);
			  
		  }
		 
		
		centerPanel.add(nombreHuesped);
		centerPanel.add(nombreHuespedTF);
		centerPanel.add(apellidoHuesped); 
		centerPanel.add(apellidoHuespedTF);
		centerPanel.add(apellidoHuesped); 
		centerPanel.add(apellidoHuespedTF);
		centerPanel.add(idHuesped); 
		centerPanel.add(idHuespedTF);
		centerPanel.add(correoHuesped);
		centerPanel.add(correoHuespedTF);
		centerPanel.add(fechaInicio); 
		centerPanel.add(fechaInicioTF);
		centerPanel.add(fechaFinal); 
		centerPanel.add(fechaFinalTF);
		centerPanel.add(numeroHuespedes); 
		centerPanel.add(numeroHuespedesC);
		centerPanel.add(numEstandar);
		centerPanel.add(numEstandarC);
		centerPanel.add(numSuite);
		centerPanel.add(numSuiteC);
		centerPanel.add(numDoble);
		centerPanel.add(numDobleC);
		
		
	}
	private void setSouthPanel()
	{
		southPanel = new JPanel(new FlowLayout());
		southPanel.setBackground(backColor);
		southPanel.setForeground(textColor);
		
		reservaButton = new JButton("Hacer reserva");
        reservaButton.addActionListener(this);
        reservaButton.setActionCommand(ADD_RESERVA);
        reservaButton.setBackground(buttonColor);
        
        check_outButton = new JButton("Hacer Check_Out");
        check_outButton.addActionListener(this);
        check_outButton.setActionCommand(CHECK_OUT);
        check_outButton.setBackground(buttonColor);
        southPanel.add(check_outButton);
	}
	
	private void infoHuespedes()
	{
		
		infohuesped= new JFrame();
		JLabel nombre, apellidos, documento, correo, celular; 
		JTextField nombreTF, apellidosTF, documentoTF, correoTF, celularTF;
		infohuesped.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
		nombre = new JLabel("Nombre del huesped");
		nombre.setForeground(textColor);
		nombre.setBackground(backColor);
		nombreTF = new JTextField(20);
		nombreTF.setForeground(backColor);
		nombreTF.setBackground(textColor);
		
		apellidos = new JLabel("Apellidos del huesped");
		apellidos.setForeground(textColor);
		apellidos.setBackground(backColor);
		apellidosTF = new JTextField(20);
		apellidosTF.setForeground(backColor);
		apellidosTF.setBackground(textColor);
		
		documento = new JLabel("Documento de ID");
		documento.setForeground(textColor);
		documento.setBackground(backColor);
		documentoTF = new JTextField(20);
		documentoTF.setForeground(backColor);
		documentoTF.setBackground(textColor);
		
		correo = new JLabel("Correo electrónico");
		correo.setForeground(textColor);
		correo.setBackground(backColor);
		correoTF = new JTextField(20);
		correoTF.setForeground(backColor);
		correoTF.setBackground(textColor);
		
		celular = new JLabel("Numero de celular");
		celular.setForeground(textColor);
		celular.setBackground(backColor);
		celularTF = new JTextField(20);
		celularTF.setForeground(backColor);
		celularTF.setBackground(textColor);
		
		
		infohuesped.add(nombre);
		infohuesped.add(nombreTF);
		infohuesped.add(apellidos);
		infohuesped.add(apellidosTF);
		infohuesped.add(documento);
		infohuesped.add(documentoTF);
		infohuesped.add(correo);
		infohuesped.add(correoTF);
		infohuesped.add(celular);
		infohuesped.add(celularTF);
		
		String nombreH = nombreTF.getText();
		String apellidosH = apellidosTF.getText();
		String documentoH = documentoTF.getText();
		String correoH = correoTF.getText();
		String celularH = celularTF.getText();
			
		setSize(1000, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		controlador.agregarHuesped(nombreH, apellidosH, documentoH, correoH, celularH);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String documento = idHuesped.getText();
		Integer numeroEstandar = numEstandarC.getSelectedIndex();
		Integer numeroSuite = numSuiteC.getSelectedIndex();
		Integer numeroDoble = numDobleC.getSelectedIndex();
		String fechaInicial = fechaInicioTF.getText();
		String fechaFinal = fechaFinalTF.getText();
		Integer numHuespedes= numeroHuespedesC.getSelectedIndex();
		String command = e.getActionCommand();
		if (command.equals(ADD_RESERVA))
		{
			boolean disponibles = controlador.revisarDisponibilidad(numeroEstandar,numeroSuite, numeroDoble, fechaInicial, fechaFinal);
            if (disponibles) 
            {
                for (int i=0; i<numHuespedes; i++) 
                {
                infoHuespedes();
                }
            
                JOptionPane.showMessageDialog(southPanel, "Reserva Exitosa!");
            }
            else
            JOptionPane.showMessageDialog(southPanel,"No hay habitaciones disponbles para las fechas dadas");
					 
		}
		else	
		{
			
			controlador.checkOut(documento, fechaInicial);
			JOptionPane.showMessageDialog(southPanel, "CheckOut exitoso!");
		
	    }

}
}