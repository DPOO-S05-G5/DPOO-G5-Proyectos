package Proyecto3.src.modelo;

public abstract class DetallesHotel {
	
	private boolean parquaderoPago;
	private boolean parquaderoGratuito;
	private boolean tienePiscina;
	private boolean tieneZonasHumedas;
	private boolean tieneBBQ;
	private boolean tieneWIFIGratuito;
	private boolean tieneRecepcion24H;
	private boolean admiteMascotas;
	
	
	public DetallesHotel (boolean parqueaderoPago, boolean parqueaderoGratuito, boolean piscina, boolean zonasHumedas, boolean bBQ, boolean wIFIGratuito, boolean recepcion24H, boolean admiteMascotas)
	
	this.parquaderoPago = parqueaderoPago;
	this.parquaderoGratuito = parqueaderoGratuito;
	this.tienePiscina = piscina;
	this.tieneZonasHumedas = zonasHumedas;
	this.tieneBBQ = bBQ;
	this.tieneWIFIGratuito = wIFIGratuito;
	this.tieneRecepcion24H = recepcion24H;
	this.admiteMascotas = admiteMascotas;
	

}


	public boolean isParquaderoPago() {
		return parquaderoPago;
	}


	public void setParquaderoPago(boolean parquaderoPago) {
		this.parquaderoPago = parquaderoPago;
	}


	public boolean isParquaderoGratuito() {
		return parquaderoGratuito;
	}


	public void setParquaderoGratuito(boolean parquaderoGratuito) {
		this.parquaderoGratuito = parquaderoGratuito;
	}


	public boolean isTienePiscina() {
		return tienePiscina;
	}


	public void setTienePiscina(boolean tienePiscina) {
		this.tienePiscina = tienePiscina;
	}


	public boolean isTieneZonasHumedas() {
		return tieneZonasHumedas;
	}


	public void setTieneZonasHumedas(boolean tieneZonasHumedas) {
		this.tieneZonasHumedas = tieneZonasHumedas;
	}


	public boolean isTieneBBQ() {
		return tieneBBQ;
	}


	public void setTieneBBQ(boolean tieneBBQ) {
		this.tieneBBQ = tieneBBQ;
	}


	public boolean isTieneWIFIGratuito() {
		return tieneWIFIGratuito;
	}


	public void setTieneWIFIGratuito(boolean tieneWIFIGratuito) {
		this.tieneWIFIGratuito = tieneWIFIGratuito;
	}


	public boolean isTieneRecepcion24H() {
		return tieneRecepcion24H;
	}


	public void setTieneRecepcion24H(boolean tieneRecepcion24H) {
		this.tieneRecepcion24H = tieneRecepcion24H;
	}


	public boolean isAdmiteMascotas() {
		return admiteMascotas;
	}


	public void setAdmiteMascotas(boolean admiteMascotas) {
		this.admiteMascotas = admiteMascotas;
	}
