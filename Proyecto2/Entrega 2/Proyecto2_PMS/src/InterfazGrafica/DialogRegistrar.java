package InterfazGrafica;

import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import autenticador.AutenticadorDeUsuarios;
import controlador.Controlador;

public class DialogRegistrar extends JDialog implements ActionListener
{

	private static final String TIPO = "tipo";
	private static final String[] TIPOS_USUARIO = {"admin", "recepcionista", "empleado"};
	
	private AutenticadorDeUsuarios autenticador;
	private ControladorVentanas controladorVentanas;
	private Color backColor;
	private Color textColor;
	private Color buttonColor;

	JPanel northPanel;
	JLabel tiposLabel;
	JComboBox tiposComboBox;

	JPanel centerPanel;
	JLabel loginLabel;
	JLabel passwordLabel;
	JLabel confirmPasswordLabel;
	JTextField loginTextField;
	JTextField passwordTextField;
	JTextField confirmPasswordTextField;

	JPanel southPanel;
	JButton registerButton;

	public DialogRegistrar(ControladorVentanas ventanaPrincipal, AutenticadorDeUsuarios autenticador, Color backColor, Color textColor,
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
		
		setNorthPanel();
		setCenterPanel();
		setSouthPanel();
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		add(southPanel, BorderLayout.SOUTH);

		setTitle("Registrar nuevo empleado");
		setSize(500, 200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void setNorthPanel()
	{
		northPanel = new JPanel(new FlowLayout());
		northPanel.setBackground(backColor);
		northPanel.setForeground(textColor);

		tiposLabel = new JLabel("Seleccione el tipo de empleado:");
		tiposLabel.setForeground(textColor);
		tiposLabel.setBackground(backColor);
		tiposComboBox = new JComboBox<String>(TIPOS_USUARIO);
		tiposComboBox.addActionListener(this);
		tiposComboBox.setActionCommand(TIPO);
		tiposComboBox.setForeground(backColor);
		tiposComboBox.setBackground(textColor);
		
		northPanel.add(tiposLabel);
		northPanel.add(tiposComboBox);
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
		
		passwordTextField = new JTextField();
		passwordTextField.setForeground(backColor);
		passwordTextField.setBackground(textColor);

		confirmPasswordTextField = new JTextField();
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
		String tipo = TIPOS_USUARIO[tiposComboBox.getSelectedIndex()];
		String login = loginTextField.getText();
		String password = passwordTextField.getText();
		String confirmPassword = confirmPasswordTextField.getText();
		try 
		{
			autenticador.registrarUsuario(tipo, login, password, confirmPassword);
		} 
		catch (Exception e1) 
		{
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Error de registración", JOptionPane.ERROR_MESSAGE);
		}
		dispose();
		controladorVentanas.dialogLogin();
	}

}
