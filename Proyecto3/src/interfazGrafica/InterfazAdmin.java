package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfazAdmin extends JFrame implements ActionListener
{   
    private static final String ADD_TARIFA = "Agregar tarifa";
    private static final String FECHAS_SIN_TARIFA = "Fechas sin tarifa";
    private static final String ADD_HAB = "Agregar habitación";
    private static final String REMOVE_HAB = "Quitar habitación";
    private static final String SHOW_HABS = "Catálogo de habitaciones";
    private static final String SHOW_MATRIX = "Mostrar matriz de ocupación";
    private static final String GO_TO_RECEPCION = "Ir a recepción";
    private static final String GO_TO_SERVICIOS = "Ir a servicios";

    private ControladorVentanasPMS padre;
	private Color backColor;
	private Color textColor;
	private Color buttonColor;

    private JPanel westPanel;
    private JButton crearTarifaButton;
    private JButton mostrarFechasSinTarifaButton;
    private JButton crearHabButton;
    private JButton eliminarHabButton;
    private JButton mostrarCatalogoButton;
    private JButton mostrarMatrizButton;
    private JButton goToRecepcionButton;
    private JButton goToServiciosButton;

    private JPanel eastPanel;

    public InterfazAdmin(ControladorVentanasPMS ventanaPrincipal)
    {
        setTitle("Administrador");
        padre = ventanaPrincipal;   
        backColor = ControladorVentanasPMS.BACK_COLOR;
        textColor = ControladorVentanasPMS.TEXT_COLOR;
        buttonColor = ControladorVentanasPMS.BUTTON_COLOR;
        
        setLayout(new BorderLayout());
        setBackground(backColor);
        setForeground(textColor);

		setWestPanel();
        setEastPanel();

		add(westPanel, BorderLayout.WEST);
        add(eastPanel, BorderLayout.EAST);
		setSize(1200, 800);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setWestPanel()
    {
        JPanel westPanelButtons = new JPanel();
		westPanelButtons.setBackground(backColor);
		westPanelButtons.setForeground(textColor);
		westPanelButtons.setLayout(new BoxLayout(westPanelButtons, BoxLayout.Y_AXIS));

        crearTarifaButton = new JButton(ADD_TARIFA);
		crearTarifaButton.addActionListener(this);
		crearTarifaButton.setActionCommand(ADD_TARIFA);
		crearTarifaButton.setForeground(getForeground());
		crearTarifaButton.setBackground(buttonColor);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(backColor);
		panel1.add(crearTarifaButton);
		westPanelButtons.add(panel1);
		
		mostrarFechasSinTarifaButton = new JButton(FECHAS_SIN_TARIFA);
		mostrarFechasSinTarifaButton.addActionListener(this);
		mostrarFechasSinTarifaButton.setActionCommand(FECHAS_SIN_TARIFA);
		mostrarFechasSinTarifaButton.setForeground(getForeground());
		mostrarFechasSinTarifaButton.setBackground(buttonColor);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(backColor);
		panel2.add(mostrarFechasSinTarifaButton);
		westPanelButtons.add(panel2);
		
		crearHabButton = new JButton(ADD_HAB);
		crearHabButton.addActionListener(this);
		crearHabButton.setActionCommand(ADD_HAB);
		crearHabButton.setForeground(getForeground());
		crearHabButton.setBackground(buttonColor);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(backColor);
		panel3.add(crearHabButton);
		westPanelButtons.add(panel3);
		
		eliminarHabButton = new JButton(REMOVE_HAB);
		eliminarHabButton.addActionListener(this);
		eliminarHabButton.setActionCommand(REMOVE_HAB);
		eliminarHabButton.setForeground(getForeground());
		eliminarHabButton.setBackground(buttonColor);
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(backColor);
		panel4.add(eliminarHabButton);
		westPanelButtons.add(panel4);

        mostrarCatalogoButton = new JButton(SHOW_HABS);
        mostrarCatalogoButton.addActionListener(this);
        mostrarCatalogoButton.setActionCommand(SHOW_HABS);
        mostrarCatalogoButton.setForeground(getForeground());
        mostrarCatalogoButton.setBackground(buttonColor);

        JPanel panel5 = new JPanel();
        panel5.setBackground(backColor);
        panel5.add(mostrarCatalogoButton);
        westPanelButtons.add(panel5);

        mostrarMatrizButton = new JButton(SHOW_MATRIX);
        mostrarMatrizButton.addActionListener(this);
        mostrarMatrizButton.setActionCommand(SHOW_MATRIX);
        mostrarMatrizButton.setForeground(getForeground());
        mostrarMatrizButton.setBackground(buttonColor);

        JPanel panel6 = new JPanel();
        panel6.setBackground(backColor);
        panel6.add(mostrarMatrizButton);
        westPanelButtons.add(panel6);

        goToRecepcionButton = new JButton(GO_TO_RECEPCION);
        goToRecepcionButton.addActionListener(this);
        goToRecepcionButton.setActionCommand(GO_TO_RECEPCION);
        goToRecepcionButton.setForeground(getForeground());
        goToRecepcionButton.setBackground(buttonColor);

        JPanel panel7 = new JPanel();
        panel7.setBackground(backColor);
        panel7.add(goToRecepcionButton);
        westPanelButtons.add(panel7);

        goToServiciosButton = new JButton(GO_TO_SERVICIOS);
        goToServiciosButton.addActionListener(this);
        goToServiciosButton.setActionCommand(GO_TO_SERVICIOS);
        goToServiciosButton.setForeground(getForeground());
        goToServiciosButton.setBackground(buttonColor);

        JPanel panel8 = new JPanel();
        panel8.setBackground(backColor);
        panel8.add(goToServiciosButton);
        westPanelButtons.add(panel8);

        westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        westPanel.setBackground(backColor);
        westPanel.setForeground(textColor);
        westPanel.add(westPanelButtons);
    }

    private void setEastPanel()
    {
        eastPanel = new JPanel(new CardLayout());
        eastPanel.setBackground(backColor);
        eastPanel.setForeground(textColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();

        switch (comando)
        {
            case ADD_TARIFA:
                new DialogAddTarifa(padre, backColor, textColor, buttonColor);
                break;
            case FECHAS_SIN_TARIFA:
                mostrarFechasSinTarifa();
            case ADD_HAB:
                new DialogAddHab(padre, backColor, textColor, buttonColor);
            case REMOVE_HAB:
                new DialogRemoveHab(padre, backColor, textColor, buttonColor);
            case SHOW_HABS:
                mostrarCatalogoHabs();
            case SHOW_MATRIX:
                mostarMatrix();
                break;
            case GO_TO_RECEPCION:
                padre.iniciarInterfazRecepcionista();
                dispose();
                break;
            case GO_TO_SERVICIOS:
                padre.iniciarInterfazServicios();
                dispose();
        }  
    }

    private void mostarMatrix()
    {
    	JFrame panelMatriz = new FrameMatriz(padre, backColor, textColor);
        panelMatriz.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        panelMatriz.setVisible(true);
        panelMatriz.pack();
    }

    private void mostrarCatalogoHabs() {
    }

    private void mostrarFechasSinTarifa() {
    }    
}
