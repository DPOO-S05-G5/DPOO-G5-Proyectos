package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class dialogHabitacion extends JDialog implements ActionListener {

    private static final String RESERVAR = "Reservar";
    private static final String PAGAR = "Reservar y pagar (10% de descuento)";
    private static final String CANCELAR = "Cancelar";
    private static final Color COLOR_PAGAR = new Color(147,196,125);
    private static final Color COLOR_TEXTO_PAGAR = Color.BLACK;

    private ControladorVentanas controladorVentanas;
    private Color backColor;
    private Color textColor;
    private Color buttonColor;
    private JTextField infoHabTextField;
    private JLabel titleLabel;
    private JButton cancelarButton;
    private JButton reservarButton;
    private JButton pagarButton;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private String idHabitacion;
    private String infoHabitacion;
    private String tipoHabitacion;

    public dialogHabitacion(ControladorVentanas controladorVentanas, Color backColor, Color textColor, Color buttonColor, String idHabitacion, String infoHabitacion, String tipoHabitacion)
    {
        this.controladorVentanas = controladorVentanas;
        this.backColor = backColor;
        this.textColor = textColor;
        this.buttonColor = buttonColor;
        this.idHabitacion = idHabitacion;
        this.infoHabitacion = infoHabitacion;
        this.tipoHabitacion = tipoHabitacion;

        setBackground(textColor);
        setForeground(Color.BLACK);
        setLayout(new BorderLayout());
        
        setNorthPanel();
        setCenterPanel();
        setSouthPanel();

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        setTitle("Habitacion " + idHabitacion);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setSouthPanel() {

        southPanel = new JPanel(new FlowLayout());
        southPanel.setBackground(backColor);

        pagarButton = new JButton(PAGAR);
        pagarButton.setBackground(COLOR_PAGAR);
        pagarButton.setForeground(COLOR_TEXTO_PAGAR);
        pagarButton.setActionCommand(PAGAR);
        pagarButton.addActionListener(this);

        southPanel.add(pagarButton);

        reservarButton = new JButton(RESERVAR);
        reservarButton.setBackground(buttonColor);
        reservarButton.setForeground(textColor);
        reservarButton.setActionCommand(RESERVAR);
        reservarButton.addActionListener(this);

        southPanel.add(reservarButton);

        cancelarButton = new JButton(CANCELAR);
        cancelarButton.setBackground(buttonColor);
        cancelarButton.setForeground(textColor);
        cancelarButton.setActionCommand(CANCELAR);
        cancelarButton.addActionListener(this);

        southPanel.add(cancelarButton);
    }

    private void setCenterPanel() {

        centerPanel = new JPanel();

        infoHabTextField = new JTextField(infoHabitacion);
        infoHabTextField.setBackground(textColor);
        infoHabTextField.setForeground(backColor);
        infoHabTextField.setEditable(false);
        
        centerPanel.add(infoHabTextField);
    }

    private void setNorthPanel() {

        northPanel = new JPanel();

        titleLabel = new JLabel(tipoHabitacion + " " + idHabitacion);
        titleLabel.setBackground(backColor);
        titleLabel.setForeground(textColor);
        
        northPanel.add(titleLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
    }


    
}
