package cargador;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import autenticador.AutenticadorDeUsuarios;
import autenticador.Usuario;
import modelo.CoordinadorPMS;
import modelo.HabitacionEstandar;
import modelo.HabitacionSuite;
import modelo.HabitacionSuiteDoble;
import modelo.Producto;
import modelo.Servicio;

public class CargadorDeDatos {
	String nombreArchivoUsuarios;
	HashMap<String, Usuario> mapaUsuarios;
	String nombreArchivoHabitacionesEstandar;
	String nombreArchivoTarifasEstandar;
	String nombreArchivoHabitacionesSuite;
	String nombreArchivoTarifasSuite;
	String nombreArchivoHabitacionesSuiteDoble;
	String nombreArchivoTarifasSuiteDoble;
	String nombreArchivoProducto;
	String nombreArchivoServicio;
	HashMap<String, HabitacionEstandar> mapaHabitacionesEstandar;
	HashMap<String, HabitacionSuite> mapaHabitacionesSuite;
	HashMap<String, HabitacionSuiteDoble> mapaHabitacionesSuiteDoble;
	HashMap<String, Producto> mapaProductos;
	HashMap<String, Servicio> mapaServicios;

	public CargadorDeDatos() {
		this.nombreArchivoUsuarios = "data/usuarios.xml";
		this.nombreArchivoHabitacionesEstandar = "data/habitacionesEstandar.xml";
		this.nombreArchivoTarifasEstandar = "data/tarifasHabitacionesEstandar.xml";
		this.nombreArchivoHabitacionesSuite = "data/habitacionesSuite.xml";
		this.nombreArchivoTarifasSuite = "data/tarifasHabitacionesSuite.xml";
		this.nombreArchivoHabitacionesSuiteDoble = "data/habitacionesSuiteDoble.xml";
		this.nombreArchivoTarifasSuiteDoble = "data/tarifasHabitacionesSuiteDoble.xml";
		this.nombreArchivoProducto = "data/Producto.xml";
		this.nombreArchivoServicio = "data/Servicio.xml";
		this.mapaUsuarios = new HashMap<String, Usuario>();
		this.mapaHabitacionesEstandar = new HashMap<String, HabitacionEstandar>();
		this.mapaHabitacionesSuite = new HashMap<String, HabitacionSuite>();
		this.mapaHabitacionesSuiteDoble = new HashMap<String, HabitacionSuiteDoble>();
		this.mapaProductos = new HashMap<String, Producto>();
		this.mapaServicios = new HashMap<String, Servicio>();
	}

	public void cargarDatosHotel(AutenticadorDeUsuarios autenticador, CoordinadorPMS coordinadorPMS) {
		cargarUsuarios(autenticador);
		cargarHabitaciones(coordinadorPMS);
		cargarProductos(coordinadorPMS);
		cargarServicios(coordinadorPMS);

	}

	private void cargarHabitaciones(CoordinadorPMS coordinadorPMS) {

		cargarHabitacionesEstandar(coordinadorPMS);
		cargarHabitacionesSuite(coordinadorPMS);
		cargarHabitacionesSuiteDoble(coordinadorPMS);

	}

	private void cargarHabitacionesEstandar(CoordinadorPMS coordinadorPMS) {
		try {
			Object obj;
			FileInputStream fis = new FileInputStream(nombreArchivoTarifasEstandar);
			XMLDecoder decoder = new XMLDecoder(fis);

			obj = decoder.readObject();
			if (obj instanceof ArrayList) {
				HabitacionEstandar.setTarifas((ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>) obj);
			} else {
				System.err.println("No esta la lista en el archivo");
			}
			decoder.close();
			fis.close();

			fis = new FileInputStream(nombreArchivoHabitacionesEstandar);
			decoder = new XMLDecoder(fis);

			while (true) {
				try {
					obj = decoder.readObject();

					if (obj instanceof HabitacionEstandar) {
						HabitacionEstandar room = (HabitacionEstandar) obj;
						String id = room.getId();
						mapaHabitacionesEstandar.put(id, room);
					} else {
						System.err.println("objecto inesperado en el archivo");
					}
				} catch (ArrayIndexOutOfBoundsException e3) {
					break;
				}
			}
			decoder.close();
			fis.close();
		} catch (FileNotFoundException e2) {
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (HashMap.Entry<String, HabitacionEstandar> entrada : mapaHabitacionesEstandar.entrySet()) {
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue().getId());
		}

		System.out.println(HabitacionEstandar.getTarifas());

		coordinadorPMS.setHabitacionesEstandar(mapaHabitacionesEstandar);
	}

	private void cargarHabitacionesSuite(CoordinadorPMS coordinadorPMS) {
		try {
			Object obj;
			FileInputStream fis = new FileInputStream(nombreArchivoTarifasSuite);
			XMLDecoder decoder = new XMLDecoder(fis);

			obj = decoder.readObject();
			if (obj instanceof ArrayList) {
				HabitacionSuite.setTarifas((ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>) obj);
			} else {
				System.err.println("No esta la lista en el archivo");
			}
			decoder.close();
			fis.close();

			fis = new FileInputStream(nombreArchivoHabitacionesSuite);
			decoder = new XMLDecoder(fis);

			while (true) {
				try {
					obj = decoder.readObject();

					if (obj instanceof HabitacionSuite) {
						HabitacionSuite room = (HabitacionSuite) obj;
						String id = room.getId();
						mapaHabitacionesSuite.put(id, room);
					} else {
						System.err.println("objecto inesperado en el archivo");
					}
				} catch (ArrayIndexOutOfBoundsException e3) {
					break;
				}
			}
			decoder.close();
			fis.close();
		} catch (FileNotFoundException e2) {
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (HashMap.Entry<String, HabitacionSuite> entrada : mapaHabitacionesSuite.entrySet()) {
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue().getId());
		}

		System.out.println(HabitacionSuite.getTarifas());

		coordinadorPMS.setHabitacionesSuite(mapaHabitacionesSuite);

	}

	private void cargarHabitacionesSuiteDoble(CoordinadorPMS coordinadorPMS) {
		try {
			Object obj;
			FileInputStream fis = new FileInputStream(nombreArchivoTarifasSuiteDoble);
			XMLDecoder decoder = new XMLDecoder(fis);

			obj = decoder.readObject();
			if (obj instanceof ArrayList) {
				HabitacionSuiteDoble.setTarifas((ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>) obj);
			} else {
				System.err.println("No esta la lista en el archivo");
			}
			decoder.close();
			fis.close();

			fis = new FileInputStream(nombreArchivoHabitacionesSuiteDoble);
			decoder = new XMLDecoder(fis);

			while (true) {
				try {
					obj = decoder.readObject();

					if (obj instanceof HabitacionSuiteDoble) {
						HabitacionSuiteDoble room = (HabitacionSuiteDoble) obj;
						String id = room.getId();
						mapaHabitacionesSuiteDoble.put(id, room);
					} else {
						System.err.println("objecto inesperado en el archivo");
					}
				} catch (ArrayIndexOutOfBoundsException e3) {
					break;
				}
			}
			decoder.close();
			fis.close();
		} catch (FileNotFoundException e2) {
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (HashMap.Entry<String, HabitacionSuiteDoble> entrada : mapaHabitacionesSuiteDoble.entrySet()) {
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue().getId());
		}

		System.out.println(HabitacionSuiteDoble.getTarifas());

		coordinadorPMS.setHabitacionesSuiteDoble(mapaHabitacionesSuiteDoble);

	}

	private void cargarProductos(CoordinadorPMS coordinadorPMS) {
		try {
			Object obj;
			FileInputStream fis = new FileInputStream(nombreArchivoProducto);
			XMLDecoder decoder = new XMLDecoder(fis);

			while (true) {
				try {
					obj = decoder.readObject();

					if (obj instanceof Producto) {
						Producto producto = (Producto) obj;
						String id = producto.getID();
						mapaProductos.put(id, producto);
					} else {
						System.err.println("objecto inesperado en el archivo");
					}
				} catch (ArrayIndexOutOfBoundsException e3) {
					break;
				}
			}
			decoder.close();
			fis.close();
		} catch (FileNotFoundException e2) {
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (HashMap.Entry<String, Producto> entrada : mapaProductos.entrySet()) {
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue().getNombre());
		}
		
		coordinadorPMS.setProductos(mapaProductos);

	}

	private void cargarUsuarios(AutenticadorDeUsuarios autenticador) {
		try {
			FileInputStream fis = new FileInputStream(nombreArchivoUsuarios);
			XMLDecoder decoder = new XMLDecoder(fis);
			Object obj;

			while (true) {
				try {
					obj = decoder.readObject();

					if (obj instanceof Usuario) {
						Usuario usuario = (Usuario) obj;
						String login = usuario.getLogin();
						mapaUsuarios.put(login, usuario);
					} else {
						System.err.println("objecto inesperado en el archivo");
					}
				} catch (ArrayIndexOutOfBoundsException e3) {
					break;
				}
			}
			decoder.close();
			fis.close();
		} catch (FileNotFoundException e2) {
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		autenticador.setMapaUsuarios(mapaUsuarios);

	}
	
	
	private void cargarServicios(CoordinadorPMS coordinadorPMS) {
		try {
			Object obj;
			FileInputStream fis = new FileInputStream(nombreArchivoServicio);
			XMLDecoder decoder = new XMLDecoder(fis);

			obj = decoder.readObject();
			decoder.close();
			fis.close();

			fis = new FileInputStream(nombreArchivoServicio);
			decoder = new XMLDecoder(fis);

			while (true) {
				try {
					obj = decoder.readObject();

					if (obj instanceof Servicio) {
						Servicio servicio = (Servicio) obj;
						String id = servicio.getID();
						mapaServicios.put(id, servicio);
					} else {
						System.err.println("objecto inesperado en el archivo");
					}
				} catch (ArrayIndexOutOfBoundsException e3) {
					break;
				}
			}
			decoder.close();
			fis.close();
		} catch (FileNotFoundException e2) {
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (HashMap.Entry<String, Servicio> entrada : mapaServicios.entrySet()) {
			System.out.println(entrada.getKey());
			System.out.println(entrada.getValue().getNombre());
		}
		coordinadorPMS.setServicios(mapaServicios);
	}
}
