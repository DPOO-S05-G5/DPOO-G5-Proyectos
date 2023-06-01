package creadores;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.Servicio;

public class CrearServicios {

	public static void main(String[] args) 
	{
		Servicio p1 = new Servicio(true, false, "Masaje sencillo", 150000, "01", true, 100); 
		Servicio p2 = new Servicio(true, false, "Exfoliacion", 80000, "02", true, 80); 
		Servicio p3 = new Servicio(true, false, "Relajación", 120000, "03", true, 120); 
		Servicio p4 = new Servicio(false, true, "historico", 70000, "04", true, 4); 
		Servicio p5 = new Servicio(false, true, "caminata", 70000, "05", true, 3); 
		Servicio p6 = new Servicio(false, true, "taller", 70000, "06", true, 2); 
		
		ArrayList<Servicio> Servicios = new ArrayList<Servicio>(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		try
		{
			FileOutputStream fos = new FileOutputStream("data/servicios.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			
			
			for (Servicio p : Servicios)
			{
				encoder.writeObject(p);
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
