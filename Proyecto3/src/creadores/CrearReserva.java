package Proyecto3.src.creadores;

public class CrearReserva {
	
	
	public static void main(String[] args) 
	{
		Reserva r1 = new Reserva("Lorena Vargas", "12345", "01", "2022-03-12", "2022-03-18", 12000,()); 
		Reserva r2 = new Reserva("Juan Perez", "73874", "02", "2022-05-02", "2022-05-10", 20000, ()); 
		Reserva r3 = new Reserva("Claudia Gil", "95382", "03", "2022-05-03", "2022-05-09", 11000, ()); 
		Reserva r4 = new Reserva("Santiago Lopez", "16352", "04", "2022-06-12", "2022-06-14", 6000, ()); 
		Reserva r5 = new Reserva("Sonia Marquez", "84592", "05", "2022-06-12", "2022-06-30", 34000, ()); 
		Reserva r6 = new Reserva("Mateo Mesa", "98952", "06", "2022-08-10", "2022-08-16", 10000, ()); 
		
		ArrayList<Producto> reservas = new ArrayList<Reserva>(Arrays.asList(r1,r2,r3,r4,r5,r6));
		
		try
		{
			FileOutputStream fos = new FileOutputStream("data/reservas.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			
			
			for (Reserva r : reservas)
			{
				encoder.writeObject(r);
			}
			encoder.close();
			fos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
