package interfazGrafica;

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

public class DialogLogin extends JDialog implements ActionListener
{
	private AutenticadorDeUsuarios autenticador;
	private ControladorVentanas padre;
	private Color backColor;
	private Color textColor;
	private Color buttonColor;

	JPanel northPanel;
	JLabel usuarioLabel;
	JTextField usuarioTextField;

	JPanel centerPanel;
	JLabel passwordLabel;
	JPasswordField passwordTextField;

	JPanel southPanel;
	JButton loginButton;

	public DialogLogin(ControladorVentanas ventanaPrincipal, AutenticadorDeUsuarios autenticador, Color backColor, Color textColor,
			Color buttonColor)
	{
		this.autenticador = autenticador;
		padre = ventanaPrincipal;
		this.backColor = backColor;
		this.textColor = textColor;
		this.buttonColor = buttonColor;

		setBackground(backColor);
		setForeground(textColor);
		setLayout(new GridLayout(3,1));
		
		setNorthPanel();
		setCenterPanel();
		setSouthPanel();
		add(northPanel);
		add(centerPanel);
		add(southPanel);

		setTitle("Iniciar sesión");
		setSize(500, 200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void setNorthPanel()
	{
		northPanel = new JPanel();
		northPanel.setBackground(backColor);
		northPanel.setForeground(textColor);
		northPanel.setLayout(new FlowLayout());

		usuarioLabel = new JLabel("Usuario: ");
		usuarioLabel.setForeground(textColor);
		usuarioTextField = new JTextField(20);
		usuarioTextField.setForeground(backColor);
		usuarioTextField.setBackground(textColor);

		

		northPanel.add(usuarioLabel);
		northPanel.add(usuarioTextField);

	}

	private void setCenterPanel()
	{
		centerPanel = new JPanel();
		centerPanel.setBackground(backColor);
		centerPanel.setForeground(textColor);
		centerPanel.setLayout(new FlowLayout());
		
		passwordLabel = new JLabel("Contraseña: ");
		passwordLabel.setForeground(textColor);
		passwordTextField = new JPasswordField(20);
		passwordTextField.setForeground(backColor);
		passwordTextField.setBackground(textColor);

		centerPanel.add(passwordLabel);
		centerPanel.add(passwordTextField);
	}

	private void setSouthPanel()
	{
		southPanel = new JPanel();
		southPanel.setBackground(backColor);
		southPanel.setForeground(textColor);
		southPanel.setLayout(new FlowLayout());

		loginButton = new JButton("Iniciar sesión");
		loginButton.setForeground(textColor);
		loginButton.setBackground(buttonColor);
		loginButton.addActionListener(this);

		southPanel.add(loginButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String login = usuarioTextField.getText();
		String password = passwordTextField.getPassword().toString();
		String tipo = null;
		try
		{
			tipo = autenticador.iniciarSesion(login, password);
		}
		catch (Exception e1)
		{
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Error de registración", JOptionPane.ERROR_MESSAGE);
		}

		dispose();
		padre.actualizar(tipo);
	}

}
