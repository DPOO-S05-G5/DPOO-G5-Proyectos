package creadores;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import modelo.Producto;

public class CrearProductos {

	public static void main(String[] args) 
	{
		Producto p1 = new Producto("Hamburguesa", "01", 35000, 12, 22, true, false, "plato"); 
		Producto p2 = new Producto("Pizza", "02", 20000, 12, 22, true, false, "plato"); 
		Producto p3 = new Producto("Gaseosa", "03", 5000, 10, 22, true, true, "bebida"); 
		Producto p4 = new Producto("Agua", "04", 4000, 0, 24, true, true, "bebida"); 
		Producto p5 = new Producto("Brownie", "05", 8000, 10, 22, true, true, "postre"); 
		Producto p6 = new Producto("Helado", "06", 7000, 14, 20, true, true, "postre"); 
		
		ArrayList<Producto> productos = new ArrayList<Producto>(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		try
		{
			FileOutputStream fos = new FileOutputStream("data/Producto.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			
			
			for (Producto p : productos)
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
