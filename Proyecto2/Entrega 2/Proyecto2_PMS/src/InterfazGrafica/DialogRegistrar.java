package InterfazGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogRegistrar extends JDialog implements ActionListener
{

	private static final String TIPO = "tipo";
	private static final String[] TIPOS_USUARIO = {"admin", "recepcionista", "empleado"};
	
	public DialogRegistrar(VentanaPrincipal ventanaPrincipal, Color foregroundColor, Color backgroundColor,
			Color buttonColor)
	{
		setLayout(new CardLayout());
		
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
		
		setTitle("Registrar nuevo empleado");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		
	}

}
