package InterfazGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogLogin extends JDialog implements ActionListener
{

	public DialogLogin(VentanaPrincipal ventanaPrincipal, Color foregroundColor, Color backgroundColor,
			Color buttonColor)
	{
		setLayout(new GridLayout(2,1));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 2));
		
		JLabel usuarioLabel = new JLabel("Usuario:");
		JTextField usuarioField = new JTextField();
		JLabel passwordLabel = new JLabel("Contraseña:");
		JTextField passwordField = new JTextField();
		
		panel1.add(usuarioLabel);
		panel1.add(usuarioField);
		panel1.add(passwordLabel);
		panel1.add(passwordField);
		
		JButton loginButton = new JButton("Iniciar sesión");
		loginButton.addActionListener(this);
		loginButton.setForeground(foregroundColor);
		loginButton.setBackground(buttonColor);
				
		add(panel1);
		add(loginButton);
		
		setTitle("Iniciar sesión");
		setSize(300, 150);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

}
