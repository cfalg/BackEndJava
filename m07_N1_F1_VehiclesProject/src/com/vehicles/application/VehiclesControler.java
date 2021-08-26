
package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicles.persistence.VehiclesRepository;
import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

/**
 * Clase per controlar els Vehicles
 * 
 * @author Carles Falgueras
 *
 */
public class VehiclesControler {

	private VehiclesRepository repository;

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
	public void createCotxeByUser() {
		Scanner reader = new Scanner(System.in);
		//introduim els valors a hardcode per fer proves
		String plate="1111AAA"; //null;
		String brand="Renault";
		String color="Blau";
		
		System.out.println("Introdueix les dades de un cotxe");

		System.out.println("Introdueix #1 la matrícula = ");
		plate = reader.next();

		System.out.println("Introdueix #2 la marca del cotxe = ");
		brand = reader.next();

		System.out.println("Introdueix #3 el Color del cotxe = ");
		color = reader.next();
		
		
		

		try {
			createCotxe(plate, brand, color);
		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
		} finally {
			reader.close();
		}

	}

	
	public void addRodes(Car cotxe) {
		Scanner reader = new Scanner(System.in);
	
		//introduim els valors a hardcode per fer proves
		String frontWheelBrand = "Dunlop";
		String frontWheelDiameter = "22";
		
		String backWheelBrand = "Pirelli";
		String backWheelDiameter = "23";

		
		System.out.println("Introdueix les dades de les rodes del cotxe");

		System.out.println("   Introdueix la marca de les rodes davanteres = ");
		frontWheelBrand = reader.next();

		System.out.println("   Introdueix la mida de les rodes davanteres =");
		frontWheelDiameter = reader.next();

		
		System.out.println("   Introdueix la marca de les rodes del darrera = ");
		backWheelBrand = reader.next();

		System.out.println("   Introdueix la mida de les rodes del darrera =");
		backWheelDiameter = reader.next();

		
		
		

		List<Wheel> frontWheels = new ArrayList<Wheel>();
		frontWheels.add(new Wheel(frontWheelBrand, Double.parseDouble(frontWheelDiameter)));
		frontWheels.add(new Wheel(frontWheelBrand, Double.parseDouble(frontWheelDiameter)));
		
		
		
		List<Wheel> backWheels = new ArrayList<Wheel>();
		backWheels.add(new Wheel(backWheelBrand, Double.parseDouble(backWheelDiameter)));
		backWheels.add(new Wheel(backWheelBrand, Double.parseDouble(backWheelDiameter)));
		
		
		
		
		
		try {
			cotxe.addWheels(frontWheels, backWheels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		reader.close();
		
	}
}
