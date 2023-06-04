package interfazAppHuesped;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import autenticador.AutenticadorDeUsuarios;
import interfazGrafica.ControladorVentanas;
import interfazGrafica.ControladorVentanasPMS;

public class DialogRegistrarHuesped extends JDialog implements ActionListener {
	
	private AutenticadorDeUsuarios autenticador;
	private ControladorVentanas controladorVentanas;
	private Color backColor;
	private Color textColor;
	private Color buttonColor;

	private JPanel centerPanel;
	private JLabel loginLabel;
	private JLabel passwordLabel;
	private JLabel confirmPasswordLabel;
	private JTextField loginTextField;
	private JPasswordField passwordTextField;
	private JPasswordField confirmPasswordTextField;

	private JPanel southPanel;
	private JButton registerButton;
	
	public DialogRegistrarHuesped(ControladorVentanas ventanaPrincipal, AutenticadorDeUsuarios autenticador, Color backColor, Color textColor,
			Color buttonColor)
	{
		this.autenticador = autenticador;
		controladorVentanas = ventanaPrincipal;
		this.backColor = backColor;
		this.textColor = textColor;
		this.buttonColor = buttonColor;

		setBackground(backColor);
		setForeground(backColor);
		setLayout(new BorderLayout());
		
		setCenterPanel();
		setSouthPanel();
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		setTitle("Registrar nuevo huesped");
		setSize(500, 200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void setCenterPanel()
	{

		centerPanel = new JPanel(new GridLayout(3,2, 10, 10));
		centerPanel.setSize(200, 200);
		centerPanel.setBackground(backColor);
		centerPanel.setForeground(textColor);

		loginLabel = new JLabel("Login:");
		loginLabel.setForeground(textColor);
		loginLabel.setBackground(backColor);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(textColor);
		passwordLabel.setBackground(backColor);

		confirmPasswordLabel = new JLabel("Confirmar password:");
		confirmPasswordLabel.setForeground(textColor);
		confirmPasswordLabel.setBackground(backColor);

		loginTextField = new JTextField();
		loginTextField.setForeground(backColor);
		loginTextField.setBackground(textColor);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setForeground(backColor);
		passwordTextField.setBackground(textColor);

		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setForeground(backColor);
		confirmPasswordTextField.setBackground(textColor);

		centerPanel.add(loginLabel);
		centerPanel.add(loginTextField);
		centerPanel.add(passwordLabel);
		centerPanel.add(passwordTextField);
		centerPanel.add(confirmPasswordLabel);
		centerPanel.add(confirmPasswordTextField);
	}

	private void setSouthPanel()
	{
		southPanel = new JPanel(new FlowLayout());
		southPanel.setBackground(backColor);
		southPanel.setForeground(textColor);

		registerButton = new JButton("Registrar");
		registerButton.setForeground(backColor);
		registerButton.setBackground(buttonColor);
		registerButton.addActionListener(this);
		
		southPanel.add(registerButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String tipo = ControladorVentanasPMS.HUESPED;
		String login = loginTextField.getText();
		String password = passwordTextField.getPassword().toString();
		String confirmPassword = confirmPasswordTextField.getPassword().toString();
		try 
		{
			autenticador.registrarUsuario(tipo, login, password, confirmPassword);
			dispose();
			controladorVentanas.dialogLogin();
		} 
		catch (Exception e1) 
		{
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Error de registración", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}