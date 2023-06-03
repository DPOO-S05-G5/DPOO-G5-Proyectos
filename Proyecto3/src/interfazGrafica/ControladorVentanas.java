package interfazGrafica;

import modelo.CoordinadorPMS;

public interface ControladorVentanas {
	
	public void dialogRegistrar();
	public void dialogLogin();
	public void actualizar(String tipo);
	public CoordinadorPMS getCoordinadorPMS();
	public void logout();
    public void filtrarFechas();
}
