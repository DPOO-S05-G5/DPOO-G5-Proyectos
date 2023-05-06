package modelo;

public class Fecha
{
	int mes;
	int dia;
	
	public Fecha()
	{
		
	}
	
	public Fecha(int mes, int dia)
	{
		this.mes = mes;
		this.dia = dia;
	}

	public int getMes()
	{
		return mes;
	}

	public void setMes(int mes)
	{
		this.mes = mes;
	}

	public int getDia()
	{
		return dia;
	}

	public void setDia(int dia)
	{
		this.dia = dia;
	}
	
	
	public String toString()
	{
		return mes + "-" + dia;
	}
	
}
