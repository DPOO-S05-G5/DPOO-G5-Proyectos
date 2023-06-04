package interfazAppHuesped;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogFiltrarFechas extends JDialog implements ActionListener{

    private static final String SELECCIONAR = "Seleccionar fechas";

    private InterfazHuesped padre;
    private JLabel fechaIncialLabel;
    private JLabel fechaFinalLabel;
    private JTextField fechaInicialTextField;
    private JTextField fechaFinalTextField;
    private JButton seleccionarFechasButton;
    private JButton filtrarButton;
    private JButton cancelarButton;

    public DialogFiltrarFechas(InterfazHuesped padre, Color backColor, Color textColor,
            Color buttonColor) {

        setTitle("Filtrar fechas");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.padre = padre;

        setBackground(backColor);
        setForeground(textColor);
        
        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBackground(backColor);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        fechaIncialLabel = new JLabel("Fecha inicial");
        fechaIncialLabel.setForeground(textColor);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel1.add(fechaIncialLabel, constraints);

        fechaInicialTextField = new JTextField(20);
        fechaInicialTextField.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel1.add(fechaInicialTextField, constraints);

        fechaFinalLabel = new JLabel("Fecha final");
        fechaFinalLabel.setForeground(textColor);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel1.add(fechaFinalLabel, constraints);

        fechaFinalTextField = new JTextField(20);
        fechaFinalTextField.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel1.add(fechaFinalTextField, constraints);

        seleccionarFechasButton = new JButton(SELECCIONAR);
        seleccionarFechasButton.setBackground(buttonColor);
        seleccionarFechasButton.setForeground(textColor);
        seleccionarFechasButton.addActionListener(this);
        seleccionarFechasButton.setActionCommand(SELECCIONAR);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        panel1.add(seleccionarFechasButton, constraints);
        
        cancelarButton = new JButton(InterfazHuesped.CANCELAR);
        cancelarButton.setBackground(buttonColor);
        cancelarButton.setForeground(textColor);
        cancelarButton.addActionListener(this);
        cancelarButton.setActionCommand(InterfazHuesped.CANCELAR);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        panel1.add(cancelarButton, constraints);

        filtrarButton = new JButton(InterfazHuesped.FILTRAR);
        filtrarButton.setBackground(buttonColor);
        filtrarButton.setForeground(textColor);
        filtrarButton.addActionListener(this);
        filtrarButton.setActionCommand(InterfazHuesped.FILTRAR);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel1.add(filtrarButton, constraints);

        getContentPane().add(panel1);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if (comando.equals(SELECCIONAR)) {
            LocalDatePickerDialog datePicker = new LocalDatePickerDialog(DialogFiltrarFechas.this);
            datePicker.setVisible(true);

            LocalDate initialDate = datePicker.getInitialDate();
            LocalDate endDate = datePicker.getEndDate();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            fechaInicialTextField.setText(initialDate.format(formatter));
            fechaFinalTextField.setText(endDate.format(formatter));
        }
        else if (comando.equals(InterfazHuesped.FILTRAR)) 
        {
            String fechaInicial = fechaInicialTextField.getText();
            String fechaFinal = fechaFinalTextField.getText();
            padre.filtrarFechas(fechaInicial, fechaFinal);
            dispose();
        }
        else if (comando.equals(InterfazHuesped.CANCELAR)) {
            dispose();
        }
    }
}
