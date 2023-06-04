package interfazGrafica;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import modelo.CoordinadorPMS;

public interface ControladorVentanas {
	
	public void dialogRegistrar();
	public void dialogLogin();
	public void actualizar(String tipo);
	public CoordinadorPMS getCoordinadorPMS();
	public void logout();
    public JPanel filtrarFechas(ActionListener padre, String fechaIncial, String fechaFinal);
    public void pagarHab(String id);
    public void reservarHab(String id);
    public String getInfoHabitacion(String id);
    public String getTipoHabitacion(String id);
	
}
