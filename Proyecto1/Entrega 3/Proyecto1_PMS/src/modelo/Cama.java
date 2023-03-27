package modelo;

public class Cama
{
	private String tipo;
	private int capacidadAdultos;
	private int capacidadNinos;
	
	public Cama()
	{
		
	}
	
	public Cama(String tipo)
	{
		this.tipo = tipo;
		
		if (this.tipo == "doble")
		{
			capacidadAdultos = 2;
			capacidadNinos = 3;
		}
		else if (this.tipo == "sencilla")
		{
			capacidadAdultos = 1;
			capacidadNinos = 2;
		}
		else if (this.tipo == "nino")
		{
			capacidadAdultos = 0;
			capacidadNinos = 1;
		}
		else if (this.tipo == "sofacama")
		{
			capacidadAdultos = 1;
			capacidadNinos = 1;
		}	
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public int getCapacidadAdultos()
	{
		return capacidadAdultos;
	}

	public void setCapacidadAdultos(int capacidadAdultos)
	{
		this.capacidadAdultos = capacidadAdultos;
	}

	public int getCapacidadNinos()
	{
		return capacidadNinos;
	}

	public void setCapacidadNinos(int capacidadNinos)
	{
		this.capacidadNinos = capacidadNinos;
	}

	@Override
	public String toString()
	{
		return "Cama [tipo=" + tipo + ", capacidadAdultos=" + capacidadAdultos + ", capacidadNinos=" + capacidadNinos
				+ "]";
	}
}
