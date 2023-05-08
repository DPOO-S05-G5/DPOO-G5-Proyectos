package InterfazGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginPanel extends JPanel implements ActionListener
{
	private static final String REGISTRAR = "registrar";
	private static final String LOGIN = "login";
	private static final String TIPO = "tipo";
	private static final String[] TIPOS_USUARIO = {"admin", "recepcionista", "empleado"}; 
	
	private ControladorVentanas father;
	private JButton registerButton;
	private JButton loginButton;
	private Color backColor;
	private Color foreColor;
	private Color buttonColor;
	
	public LoginPanel(ControladorVentanas ventanaPrincipal, Color foregroundColor, Color backgroundColor,
			Color buttonColor)
	{
		father = ventanaPrincipal;
		backColor = backgroundColor;
		foreColor = foregroundColor;
		this.buttonColor = buttonColor;
		
		setLayout(new FlowLayout());
		setBackground(backgroundColor);
		setForeground(foregroundColor);
		setOpaque(true);
		
		registerButton = new JButton("Registrar nuevo usuario");
		registerButton.addActionListener(this);
		registerButton.setActionCommand(REGISTRAR);
		registerButton.setForeground(foregroundColor);
		registerButton.setBackground(buttonColor);
		
		loginButton = new JButton("Ingresar");
		loginButton.addActionListener(this);
		loginButton.setActionCommand(LOGIN);
		loginButton.setForeground(foregroundColor);
		loginButton.setBackground(buttonColor);
		
		add(registerButton);
		add(loginButton);		
	}

	private void iniciarPanelRegistrar()
	{
		setLayout(new CardLayout());
		remove(registerButton);
		remove(loginButton);
		
		JPanel card1 = new JPanel();
		JLabel tiposLabel = new JLabel("Seleccione el tipo de empleado:");
		JComboBox tiposComboBox = new JComboBox<String>(TIPOS_USUARIO);
		tiposComboBox.addActionListener(this);
		tiposComboBox.setActionCommand(TIPO);
		tiposComboBox.setForeground(getForeground());
		tiposComboBox.setBackground(buttonColor);
		
		card1.add(tiposLabel);
		card1.add(tiposComboBox);
		
		add(card1);	
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		
		if (command.equals(REGISTRAR))
			iniciarPanelRegistrar();
//		else
//			iniciarPanelLogin();
		
	}


}
