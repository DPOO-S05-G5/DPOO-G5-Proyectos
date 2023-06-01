package interfazAppHuesped;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import controlador.Controlador;
import modelo.Habitacion;
import modelo.Tarifas;

public class BotonHabitacion extends JButton {

    Habitacion habitacion;
    JLabel idLabel;
    JLabel tipoLabel;
    JLabel precioLabel;
    JLabel torreLabel;
    JLabel pisoLabel;

    public BotonHabitacion(Habitacion habitacion, Color buttonColor, Color textColor) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(buttonColor);
        this.setForeground(textColor);
        this.habitacion = habitacion;

        idLabel = new JLabel("ID: " + habitacion.getId());
        idLabel.setForeground(textColor);
        tipoLabel = new JLabel("Tipo: " + habitacion.getTipo());
        tipoLabel.setForeground(textColor);
        // TODO calcular precio
        precioLabel = new JLabel("Precio: ");
        precioLabel.setForeground(textColor);
        torreLabel = new JLabel("Torre: " + habitacion.getTorre());
        torreLabel.setForeground(textColor);
        pisoLabel = new JLabel("Piso: " + habitacion.getPiso());
        pisoLabel.setForeground(textColor);

        this.add(idLabel);
        this.add(tipoLabel);
        this.add(precioLabel);
        this.add(torreLabel);
        this.add(pisoLabel);        
    }
    
}
