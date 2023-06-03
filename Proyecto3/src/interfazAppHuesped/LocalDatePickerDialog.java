package interfazAppHuesped;

import java.awt.Dialog;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

class LocalDatePickerDialog extends JDialog implements ActionListener {

    private static final String CANCELAR = "Cancelar";
	private static final String SELECCIONAR = "Seleccionar";
	
	private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    private JButton cancelButton;
    private JButton selectButton;

    public LocalDatePickerDialog(Dialog parent) {
        super(parent, "Escoger fechas", true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel startDateLabel = new JLabel("Fecha inicial:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(startDateLabel, constraints);

        startDatePicker = new DatePicker(LocalDate.now());
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(startDatePicker, constraints);

        JLabel endDateLabel = new JLabel("Fecha final:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(endDateLabel, constraints);

        endDatePicker = new DatePicker(LocalDate.now());
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(endDatePicker, constraints);

        // Cancel Button
        cancelButton = new JButton(CANCELAR);
        constraints.gridx = 0;
        constraints.gridy = 2;
        cancelButton.addActionListener(this);
        cancelButton.setActionCommand(CANCELAR);
        panel.add(cancelButton, constraints);

 

        selectButton = new JButton(SELECCIONAR);
        constraints.gridx = 1;
        constraints.gridy = 2;
        selectButton.addActionListener(this);
        selectButton.setActionCommand(SELECCIONAR);
        panel.add(selectButton, constraints);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        if (command.equals(SELECCIONAR)) {
            dispose();
        } else if (command.equals(CANCELAR)) {
            dispose();
        }
    }

    public LocalDate getInitialDate() {
        return startDatePicker.getDate();
    }

    public LocalDate getEndDate() {
        return endDatePicker.getDate();
    }
}
