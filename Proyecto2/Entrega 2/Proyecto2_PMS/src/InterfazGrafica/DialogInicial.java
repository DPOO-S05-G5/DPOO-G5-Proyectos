package InterfazGrafica;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class DialogInicial extends JDialog implements ActionListener
{
	
	private static final String REGISTRAR = "registrar";
	private static final String LOGIN = "login";
	
	private VentanaPrincipal padre;
	
	public DialogInicial(VentanaPrincipal ventanaPrincipal, Color foregroundColor, Color backgroundColor, Color buttonColor)
	{
		padre = ventanaPrincipal;
		
		getContentPane().setBackground(backgroundColor);
		getContentPane().setForeground(foregroundColor);
		
		setLayout(new FlowLayout());
		
		JButton registerButton = new JButton("Registrar nuevo usuario");
		registerButton.addActionListener(this);
		registerButton.setActionCommand(REGISTRAR);
		registerButton.setForeground(foregroundColor);
		registerButton.setBackground(buttonColor);
		
		JButton loginButton = new JButton("Ingresar con usuario existente");
		loginButton.addActionListener(this);
		loginButton.setActionCommand(LOGIN);
		loginButton.setForeground(foregroundColor);
		loginButton.setBackground(buttonColor);
		
		add(registerButton);
		add(loginButton);
		
		setTitle("Inicio");
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		
		if (command.equals(REGISTRAR))
		{
			dispose();
			padre.dialogoRegistrar();
		}
		else
		{
			dispose();
			padre.dialogLogin();
		}
		
	}
}
