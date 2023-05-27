package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DialogAddTarifa extends JDialog implements ActionListener
{
    private static final String[] TIPOS_HABITACION = {ControladorVentanas.ESTANDAR, ControladorVentanas.SUITE, ControladorVentanas.SUITEDOBLE};
    private static final String ADD = "Agregar tarifa";
    
    private ControladorVentanas controladorVentanas;
    private Color backColor;
    private Color textColor;
    private Color buttonColor;

    private JPanel northPanel;
    private JLabel tiposLabel;
    private JComboBox<String> tiposComboBox;
    private JLabel precioLabel;
    private JTextField preciotextField;

    private JPanel centerPanel;
    // TODO date picker

    private JPanel southPanel;
    private JLabel seleccionarDiasLabel;
    private JRadioButton lunesButton;
    private JRadioButton martesButton;
    private JRadioButton miercolesButton;
    private JRadioButton juevesButton;
    private JRadioButton viernesButton;
    private JRadioButton sabadoButton;
    private JRadioButton domingoButton;
    private ButtonGroup diasButtonGroup;
    private JButton addButton;


    public DialogAddTarifa(ControladorVentanas ventanaPrincipal, Color backColor, Color textColor,
    Color buttonColor) 
    {
        this.controladorVentanas = ventanaPrincipal;
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
        // add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        setTitle("Agregar tarifa");
        setSize(800, 400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    
    private void setNorthPanel() 
    {
        northPanel = new JPanel(new FlowLayout());
        northPanel.setBackground(backColor);
        northPanel.setForeground(textColor);

        tiposLabel = new JLabel("Tipo de habitacion: ");
        tiposLabel.setForeground(textColor);
        
        tiposComboBox = new JComboBox<String>(TIPOS_HABITACION);
        tiposComboBox.setForeground(backColor); 
        tiposComboBox.setBackground(textColor);

        precioLabel = new JLabel("Precio: ");
        precioLabel.setForeground(textColor);
        precioLabel.setBackground(backColor);

        preciotextField = new JTextField(20);
        preciotextField.setForeground(backColor);
        preciotextField.setBackground(textColor);

        northPanel.add(tiposLabel);
        northPanel.add(tiposComboBox);
        northPanel.add(precioLabel);
        northPanel.add(preciotextField);
    }
    
    private void setCenterPanel() 
    {

    }

    private void setSouthPanel() 
    {
        southPanel = new JPanel(new GridLayout(3, 1));
        southPanel.setBackground(backColor);
        southPanel.setForeground(textColor);

        seleccionarDiasLabel = new JLabel("Seleccione los días:");
        seleccionarDiasLabel.setBackground(backColor);
        seleccionarDiasLabel.setForeground(textColor);

        lunesButton = new JRadioButton("L");
        lunesButton.setBackground(backColor);
        lunesButton.setForeground(textColor);

        martesButton = new JRadioButton("M");
        martesButton.setBackground(backColor);
        martesButton.setForeground(textColor);

        miercolesButton = new JRadioButton("I");
        miercolesButton.setBackground(backColor);
        miercolesButton.setForeground(textColor);

        juevesButton = new JRadioButton("J");
        juevesButton.setBackground(backColor);
        juevesButton.setForeground(textColor);

        viernesButton = new JRadioButton("V");
        viernesButton.setBackground(backColor);
        viernesButton.setForeground(textColor);

        sabadoButton = new JRadioButton("S");
        sabadoButton.setBackground(backColor);
        sabadoButton.setForeground(textColor);

        domingoButton = new JRadioButton("D");
        domingoButton.setBackground(backColor);
        domingoButton.setForeground(textColor);

        diasButtonGroup = new ButtonGroup();
        diasButtonGroup.add(lunesButton);
        diasButtonGroup.add(martesButton);
        diasButtonGroup.add(miercolesButton);
        diasButtonGroup.add(juevesButton);
        diasButtonGroup.add(viernesButton);
        diasButtonGroup.add(sabadoButton);
        diasButtonGroup.add(domingoButton);

        addButton = new JButton(ADD);
        addButton.setBackground(buttonColor);
        addButton.setForeground(textColor);

        JPanel row1 = new JPanel(new FlowLayout());
        row1.setBackground(backColor);
        row1.setForeground(textColor);

        JPanel row2 = new JPanel(new FlowLayout());
        row2.setBackground(backColor);
        row2.setForeground(textColor);

        JPanel row3 = new JPanel(new FlowLayout());
        row3.setBackground(backColor);
        row3.setForeground(textColor);

        row1.add(seleccionarDiasLabel);
        row1.add(lunesButton);
        row1.add(martesButton);
        row1.add(miercolesButton);

        row2.add(juevesButton);
        row2.add(viernesButton);
        row2.add(sabadoButton);
        row2.add(domingoButton);

        row3.add(addButton);

        southPanel.add(row1);
        southPanel.add(row2);
        southPanel.add(row3);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }

}
