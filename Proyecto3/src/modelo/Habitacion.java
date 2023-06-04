package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Habitacion
{
	private String tipo;
	private boolean tieneCocina;
	private boolean tieneBalcon;
	private boolean tieneVista;
	private String torre;
	private int piso;
	private String id;
	private ArrayList<Cama> camas;
	private int capacidadAdultos;
	private int capacidadNinios;
	private HashMap<String, Huesped> huespedes;
	private Reserva reservaActual;
	private HashMap<String, Reserva> reservas;
	private int tamanoHab; 
	private boolean tieneAC;
	private boolean tieneCalefaccion; 
	private int tamanoCama;
	private boolean tieneTV;
	private boolean tieneCafetera;
	private boolean tieneRopCama_TapHipoaler;
	private boolean tienePlancha;
	private boolean tieneSecadorPelo;
	private int voltajeAC;
	private boolean tieneTomaUSBA;
	private boolean tieneTomaUSBC;
	private boolean incluyeDesayuno;

	

	public Habitacion()
	{
		
	}
	
	
	public Habitacion(String tipo, boolean cocina, boolean balcon, boolean vista, String torre, int piso, String id, int tamanoHab, boolean aire_acondicionado, boolean calefaccion, int tamanoCama, boolean tv, boolean cafetera, boolean ropCama_TapHipoaler, boolean plancha, boolean secadorPelo, int voltajeAC, boolean tomaUSBA, boolean tomaUSBC, boolean incluyeDesayuno)
	{
		this.tipo = tipo;
		this.tieneCocina = cocina;
		this.tieneBalcon = balcon;
		this.tieneVista = vista;
		this.torre = torre;
		this.piso = piso;
		this.id = id;
		this.reservas = new HashMap<String, Reserva>();
		this.tamanoHab = tamanoHab;
		this.tieneAC = aire_acondicionado;
		this.tieneCalefaccion = calefaccion;
		this.tamanoCama = tamanoCama;
		this.tieneTV = tv;
		this.tieneCafetera = cafetera;
		this.tieneRopCama_TapHipoaler = ropCama_TapHipoaler;
		this.tienePlancha = plancha;
		this.tieneSecadorPelo = secadorPelo;
		this.voltajeAC = voltajeAC;
		this.tieneTomaUSBA = tomaUSBA;
		this.tieneTomaUSBC = tomaUSBC;
		this.incluyeDesayuno = incluyeDesayuno;
		

	}


	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public boolean isTieneCocina()
	{
		return tieneCocina;
	}

	public void setTieneCocina(boolean tieneCocina)
	{
		this.tieneCocina = tieneCocina;
	}

	public boolean isTieneBalcon()
	{
		return tieneBalcon;
	}

	public void setTieneBalcon(boolean tieneBalcon)
	{
		this.tieneBalcon = tieneBalcon;
	}

	public boolean isTieneVista()
	{
		return tieneVista;
	}

	public void setTieneVista(boolean tieneVista)
	{
		this.tieneVista = tieneVista;
	}

	public String getTorre()
	{
		return torre;
	}

	public void setTorre(String torre)
	{
		this.torre = torre;
	}

	public int getPiso()
	{
		return piso;
	}

	public void setPiso(int piso)
	{
		this.piso = piso;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public ArrayList<Cama> getCamas()
	{
		return camas;
	}

	public void setCamas(ArrayList<Cama> camas)
	{
		this.camas = camas;
	}

	public int getCapacidadAdultos()
	{
		return capacidadAdultos;
	}

	public void setCapacidadAdultos(int capacidadAdultos)
	{
		this.capacidadAdultos = capacidadAdultos;
	}

	public int getCapacidadNinios()
	{
		return capacidadNinios;
	}

	public void setCapacidadNinios(int capacidadNinios)
	{
		this.capacidadNinios = capacidadNinios;
	}

	public HashMap<String, Reserva> getReservas()
	{
		return reservas;
	}


	public void setReservas(HashMap<String, Reserva> reservas)
	{
		this.reservas = reservas;
	}

	public void addReserva(Reserva reserva)
	{
		this.reservas.put(reserva.getId(), reserva);
	}
	
	public Reserva getReservaActual()
	{
		return reservaActual;
	}

	public void setReservaActual(Reserva reserva)
	{
		this.reservaActual = reserva;
	}

	public HashMap<String, Huesped> getHuespedes()
	{
		return huespedes;
	}

	public void setHuespedes(HashMap<String, Huesped> huespedes)
	{
		this.huespedes = huespedes;
	}

	public void addHuesped(Huesped huesped)
	{
		this.huespedes.put(huesped.getId(), huesped);
	}

	public int getTamanoHab() {
		return tamanoHab;
	}


	public void setTamanoHab(int tamanoHab) {
		this.tamanoHab = tamanoHab;
	}


	public boolean isTieneAC() {
		return tieneAC;
	}


	public void setTieneAC(boolean tieneAC) {
		this.tieneAC = tieneAC;
	}


	public boolean isTieneCalefaccion() {
		return tieneCalefaccion;
	}


	public void setTieneCalefaccion(boolean tieneCalefaccion) {
		this.tieneCalefaccion = tieneCalefaccion;
	}


	public int getTamanoCama() {
		return tamanoCama;
	}


	public void setTamanoCama(int tamanoCama) {
		this.tamanoCama = tamanoCama;
	}


	public boolean isTieneTV() {
		return tieneTV;
	}


	public void setTieneTV(boolean tieneTV) {
		this.tieneTV = tieneTV;
	}


	public boolean isTieneCafetera() {
		return tieneCafetera;
	}


	public void setTieneCafetera(boolean tieneCafetera) {
		this.tieneCafetera = tieneCafetera;
	}


	public boolean isTieneRopCama_TapHipoaler() {
		return tieneRopCama_TapHipoaler;
	}


	public void setTieneRopCama_TapHipoaler(boolean tieneRopCama_TapHipoaler) {
		this.tieneRopCama_TapHipoaler = tieneRopCama_TapHipoaler;
	}


	public boolean isTienePlancha() {
		return tienePlancha;
	}


	public void setTienePlancha(boolean tienePlancha) {
		this.tienePlancha = tienePlancha;
	}


	public boolean isTieneSecadorPelo() {
		return tieneSecadorPelo;
	}


	public void setTieneSecadorPelo(boolean tieneSecadorPelo) {
		this.tieneSecadorPelo = tieneSecadorPelo;
	}


	public int getVoltajeAC() {
		return voltajeAC;
	}


	public void setVoltajeAC(int voltajeAC) {
		this.voltajeAC = voltajeAC;
	}


	public boolean isTieneTomaUSBA() {
		return tieneTomaUSBA;
	}


	public void setTieneTomaUSBA(boolean tieneTomaUSBA) {
		this.tieneTomaUSBA = tieneTomaUSBA;
	}


	public boolean isTieneTomaUSBC() {
		return tieneTomaUSBC;
	}


	public void setTieneTomaUSBC(boolean tieneTomaUSBC) {
		this.tieneTomaUSBC = tieneTomaUSBC;
	}


	public boolean isIncluyeDesayuno() {
		return incluyeDesayuno;
	}


	public void setIncluyeDesayuno(boolean incluyeDesayuno) {
		this.incluyeDesayuno = incluyeDesayuno;
	}


	@Override
	public String toString()
	{
		String info = "Habitacion " + tipo + " " + id + ":";
		
		info += "\n\tTorre: " + torre;
		info += "\n\tPiso: " + piso;

		return info;
	}	
	
}
