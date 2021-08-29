package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicles.persistence.VehiclesRepository;
import com.vehicles.project.AbsPersona;
import com.vehicles.project.Bike;
import com.vehicles.project.Camio;
import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.VehicleException;
import com.vehicles.project.Wheel;
import com.vehicles.utilities.Utilities;

/**
 * Clase per controlar els Vehicles
 * 
 * @author Carles Falgueras
 *
 */
public class VehiclesControler {

	private VehiclesRepository repository;
	private static Scanner reader;

	public VehiclesControler() {
		repository = new VehiclesRepository();
	}

	//
	/**
	 * llistem tots els vehicles
	 */
	public String getAllVehicles() {
		String allVehicles = " \n";

		// [CFV-29/07/2021] Recorrem tot el repository per reseguir un a un tots els
		// Vehicles
		for (Vehicle e : repository.getAllVehicles()) {
			allVehicles += e.toString() + " \n";
		}

		return allVehicles;
	}

	/**
	 * Creem el mètode per afegir un cotxe
	 */
	public void createCotxe(String plate, String brand, String color) throws Exception {
		Car cotxe = new Car(plate, brand, color);
		addRodes(cotxe);
		repository.addVehicle(cotxe);

	}

	/**
	 * Crearem un cotxe a partir de les dades que ens ompli el usuari
	 */
	public void createCotxeAuto() {
		
		// introduim els valors a hardcode per fer proves
		String plate = "1111AAA"; // null;
		String brand = "Renault";
		String color = "Blau";

		System.out.println("Introduïm AUTO les dades de un cotxe");

		try {
			createCotxe(plate, brand, color);
		
		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
		}

	}	
	
	/**
	 * Crearem un cotxe a partir de les dades que ens ompli el usuari
	 */
	public void createCotxeByUser() {
		Scanner reader = new Scanner(System.in);
		// introduim els valors a hardcode per fer proves
		String plate = "1111AAA"; // null;
		String brand = "Renault";
		String color = "Blau";

		System.out.println("Introdueix les dades de un cotxe");

		// System.out.println("Introdueix #1 la matrícula = ");
		// plate = reader.next();
		plate = getPlate("Introdueix #1 la matrícula = " + " \n");

		System.out.println("Introdueix #2 la marca del cotxe = " + " \n");
		brand = reader.next();

		System.out.println("Introdueix #3 el Color del cotxe = " + " \n");
		color = reader.next();

		try {
			createCotxe(plate, brand, color);
		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
		} 
//			finally {
//			reader.close();
//		}

	}

	/**
	 * Crear el mètode per insertar 2 rodes al cotxe
	 * 
	 * @param cotxe
	 */
	public void addRodes(Car cotxe) {
		reader = new Scanner(System.in);

		// introduim els valors a hardcode per fer proves
		String frontWheelBrand = "Dunlop";
		double frontWheelDiameter = 2;

		String backWheelBrand = "Pirelli";
		double backWheelDiameter = 3;

		System.out.println("Introdueix les dades de les rodes del cotxe");

		// System.out.println(" Introdueix la marca de les rodes davanteres = ");
		// frontWheelBrand = reader.next();
		frontWheelBrand = getUserInput(" Introdueix la marca de les rodes davanteres = ");

		// System.out.println(" Introdueix la mida de les rodes davanteres =");
		// frontWheelDiameter = reader.next();
		frontWheelDiameter = getWheelDiameter(" Introdueix la mida de les rodes davanteres =");

		// System.out.println(" Introdueix la marca de les rodes del darrera = ");
		// backWheelBrand = reader.next();
		backWheelBrand = getUserInput(" Introdueix la marca de les rodes del darrera = ");

		// System.out.println(" Introdueix la mida de les rodes del darrera =");
		// backWheelDiameter = reader.next();
		backWheelDiameter = getWheelDiameter(" Introdueix la mida de les rodes del darrera =");

		List<Wheel> frontWheels = new ArrayList<Wheel>();
		frontWheels.add(new Wheel(frontWheelBrand, frontWheelDiameter));
		frontWheels.add(new Wheel(frontWheelBrand, frontWheelDiameter));

		List<Wheel> backWheels = new ArrayList<Wheel>();
		backWheels.add(new Wheel(backWheelBrand, backWheelDiameter));
		backWheels.add(new Wheel(backWheelBrand, backWheelDiameter));

		try {
			cotxe.addWheels(frontWheels, backWheels);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Bucle que fins que el usuari no informi el valor correcte del diametre
	 * quedará aqui. I també validem que el valor introduit per el usuari sigui un
	 * numèric
	 * 
	 * @param messageToUser
	 *            Text que li surtirá al usuari cada cop
	 * @return double el valor correcte del diametre de la roda
	 */
	private double getWheelDiameter(String messageToUser) {
		boolean isOk = false;
		String diameter = null;

		while (!isOk) {
			try {
				diameter = getUserInput(messageToUser);
				if (isNumeric(diameter)) {
					if (Wheel.isDiameterOk(Double.parseDouble(diameter))) {
						isOk = true;
					} else {
						throw new VehicleException("El diametre ha de estar compres entre 0.4 y 4.");
					}
				} else {
					throw new VehicleException("El diametre ha de ser un numèric.");
				}

			} catch (VehicleException e) {
				System.out.println(e.getMessage());
			}

		}
		return Double.parseDouble(diameter);

	}

	/**
	 * Mètode per mostrar missatge al usuari i obtenir la resposta d'aquest
	 * 
	 * @param messageToUser
	 *            Missatge a mostrar al usuari
	 * @return Valor que ha introduït el usuari
	 */
	private static String getUserInput(String messageToUser) {

		System.out.print(messageToUser);
		Scanner reader = new Scanner(System.in);
		String s = reader.nextLine();
		// sc.close(); NO entec el pq però ho he de deixar obert
		return s;
	}

	/**
	 * Bucle per obtenir de part del usuari les dades de una matricula en format
	 * correcte Si el usuari no ho entra amb el patró que toca es queda en el bucle
	 * 
	 * @param messageToUser
	 *            Missatge demanant al usuari les dades de la matrícula
	 * @return matrícula
	 */
	private String getPlate(String messageToUser) {
		boolean isOk = false;
		String plate = null;

		while (!isOk) {
			try {
				plate = getUserInput(messageToUser);
				if (Car.isPlateOk(plate)) {
					isOk = true;
				} else {
					throw new VehicleException("Una matrícula ha de tenir 4 números i dues o tres lletres.");
				}

			} catch (VehicleException e) {
				System.out.println(e.getMessage());
			}

		}
		return plate;

	}

	/**
	 * Funció per validar si un text es un númeric o no
	 * 
	 * @param str
	 *            string
	 * @return True si es un nunéric / False si no ho és
	 */
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Métode per crear una Moto a partir de les dades el usuari
	 */
	public void createBikeByUser() {
		// introduim els valors a hardcode per fer proves
		String plate = "9999ZZZ"; // null;
		String brand = "Yamaha";
		String color = "Negre";
		String messageToUser = "";

		System.out.println("Introdueix les dades de una Moto");

		// System.out.println("Introdueix #1 la matrícula = ");
		// plate = reader.next();
		messageToUser = "Introdueix #1 la matrícula = " + " \n";
		plate = getPlate(messageToUser);

		messageToUser = "Introdueix #2 la marca = " + " \n";
		brand = getUserInput(messageToUser);

		messageToUser = "Introdueix #3 la color = " + " \n";
		color = getUserInput(messageToUser);

		try {
			createBike(plate, brand, color);
		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
		} 
//		finally {
//			reader.close();
//		}

	}

	/**
	 * Creem el mètode per afegir una moto
	 */
	public void createBike(String plate, String brand, String color) throws Exception {
		Bike moto = new Bike(plate, brand, color);
		addRodes(moto);
		repository.addVehicle(moto);

	}

	/**
	 * Crear el mètode per insertar 2 rodes a la moto
	 * 
	 * @param cotxe
	 */
	public void addRodes(Bike moto) {
		reader = new Scanner(System.in);

		// introduim els valors a hardcode per fer proves
		String frontWheelBrand = "Dunlop";
		double frontWheelDiameter = 2;

		String backWheelBrand = "Pirelli";
		double backWheelDiameter = 3;

		System.out.println("Introdueix les dades de les rodes de la moto");

		// System.out.println(" Introdueix la marca de les rodes davanteres = ");
		// frontWheelBrand = reader.next();
		frontWheelBrand = getUserInput(" Introdueix la marca de la roda davantera = ");

		// System.out.println(" Introdueix la mida de les rodes davanteres =");
		// frontWheelDiameter = reader.next();
		frontWheelDiameter = getWheelDiameter(" Introdueix la mida de la roda davantera =");

		// System.out.println(" Introdueix la marca de les rodes del darrera = ");
		// backWheelBrand = reader.next();
		backWheelBrand = getUserInput(" Introdueix la marca de la roda del darrera = ");

		// System.out.println(" Introdueix la mida de les rodes del darrera =");
		// backWheelDiameter = reader.next();
		backWheelDiameter = getWheelDiameter(" Introdueix la mida de la roda del darrera =");

		// List<Wheel> frontWheels = new ArrayList<Wheel>();
		// frontWheels.add(new Wheel(frontWheelBrand, frontWheelDiameter));
		//// frontWheels.add(new Wheel(frontWheelBrand, frontWheelDiameter));
		//
		// List<Wheel> backWheels = new ArrayList<Wheel>();
		// backWheels.add(new Wheel(backWheelBrand, backWheelDiameter));
		// backWheels.add(new Wheel(backWheelBrand, backWheelDiameter));

		try {
			moto.addWheels(new Wheel(frontWheelBrand, frontWheelDiameter),
					new Wheel(backWheelBrand, backWheelDiameter));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Crearem un Camió a partir de les dades que ens ompli el usuari
	 */
	public void createCamioByUser() {
		Scanner reader = new Scanner(System.in);
		// introduim els valors a hardcode per fer proves
		String plate = "1111AAA"; // null;
		String brand = "Renault";
		String color = "Blau";

		System.out.println("Introdueix les dades de un Camió");

		// System.out.println("Introdueix #1 la matrícula = ");
		// plate = reader.next();
		plate = getPlate("Introdueix #1 la matrícula = " + " \n");

		System.out.println("Introdueix #2 la marca del cotxe = " + " \n");
		brand = reader.next();

		System.out.println("Introdueix #3 el Color del cotxe = " + " \n");
		color = reader.next();

		try {
			createCamio(plate, brand, color);
		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
		} 
//		finally {
//			reader.close();
//		}

	}

	/**
	 * Creem el mètode per afegir un cotxe
	 */
	public void createCamio(String plate, String brand, String color) throws Exception {
		Camio camio = new Camio(plate, brand, color);
		addRodes(camio);
		repository.addVehicle(camio);

	}

	/**
	 * Crear el mètode per insertar 2 rodes al cotxe
	 * 
	 * @param camio
	 */
	public void addRodes(Camio camio) {
		reader = new Scanner(System.in);

		// introduim els valors a hardcode per fer proves
		String frontWheelBrand = "Dunlop";
		double frontWheelDiameter = 2;

		String backWheelBrand = "Pirelli";
		double backWheelDiameter = 3;

		String backWheelBrand2 = "Pirelli";
		double backWheelDiameter2 = 3;

		System.out.println("Introdueix les dades de les rodes del cotxe");

		// System.out.println(" Introdueix la marca de les rodes davanteres = ");
		// frontWheelBrand = reader.next();
		frontWheelBrand = getUserInput(" Introdueix la marca de les rodes davanteres = ");

		// System.out.println(" Introdueix la mida de les rodes davanteres =");
		// frontWheelDiameter = reader.next();
		frontWheelDiameter = getWheelDiameter(" Introdueix la mida de les rodes davanteres =");

		// System.out.println(" Introdueix la marca de les rodes del darrera = ");
		// backWheelBrand = reader.next();
		backWheelBrand = getUserInput(" Introdueix la marca de les rodes del darrera = ");

		// System.out.println(" Introdueix la mida de les rodes del darrera =");
		// backWheelDiameter = reader.next();
		backWheelDiameter = getWheelDiameter(" Introdueix la mida de les rodes del darrera =");

		// Afegirm la opció d'introduir el segon joc de rodes de darrera
		backWheelBrand2 = getUserInput(" Introdueix la marca de les Segones rodes del darrera = ");
		backWheelDiameter2 = getWheelDiameter(" Introdueix la mida de les Segones rodes del darrera =");

		List<Wheel> frontWheels = new ArrayList<Wheel>();
		frontWheels.add(new Wheel(frontWheelBrand, frontWheelDiameter));
		frontWheels.add(new Wheel(frontWheelBrand, frontWheelDiameter));

		List<Wheel> backWheels = new ArrayList<Wheel>();
		backWheels.add(new Wheel(backWheelBrand, backWheelDiameter));
		backWheels.add(new Wheel(backWheelBrand, backWheelDiameter));

		// 2º joc de rodes de darrera
		List<Wheel> backWheels2 = new ArrayList<Wheel>();
		backWheels2.add(new Wheel(backWheelBrand2, backWheelDiameter2));
		backWheels2.add(new Wheel(backWheelBrand2, backWheelDiameter2));

		try {
			camio.addWheels(frontWheels, backWheels, backWheels2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}
	
	
	public Vehicle getVehicle(int idx) {
		return repository.getVehicle(idx);
	}

}
