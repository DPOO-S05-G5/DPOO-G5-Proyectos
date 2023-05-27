package interfazGrafica;

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
	
	private ControladorVentanas padre;
	
	public DialogInicial(ControladorVentanas ventanaPrincipal, Color backColor, Color textColor, Color buttonColor)
	{
		padre = ventanaPrincipal;
		
		getContentPane().setBackground(backColor);
		getContentPane().setForeground(textColor);
		
		setLayout(new FlowLayout());
		
		JButton registerButton = new JButton("Registrar nuevo usuario");
		registerButton.addActionListener(this);
		registerButton.setActionCommand(REGISTRAR);
		registerButton.setForeground(textColor);
		registerButton.setBackground(buttonColor);
		
		JButton loginButton = new JButton("Iniciar sesión");
		loginButton.addActionListener(this);
		loginButton.setActionCommand(LOGIN);
		loginButton.setForeground(textColor);
		loginButton.setBackground(buttonColor);
		
		add(registerButton);
		add(loginButton);
		
		setTitle("Inicio");
		setSize(200, 120);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public DialogInicial(interfaz.ControladorVentanas controladorVentanas, Color backColor, Color textColor,
            Color buttonColor) {
    }

    @Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		
		if (command.equals(REGISTRAR))
		{
			dispose();
			padre.dialogRegistrar();
		}
		else
		{
			dispose();
			padre.dialogLogin();
		}
		
	}
}
