package com.vehicles.view;

import com.vehicles.application.VehiclesControler;

/**
 * Clase main per on començarà el projecte
 * 
 * @author Carles Falgueras
 * @version M7.N1.F2.20210729
 *
 *          Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.
 *          Crear el cotxe amb les dades anteriors. Afegir-li dues rodes
 *          traseres demanant a l’usuari la marca i el diametre. Afegir-li dues
 *          rodes davanteres demanant a l’usuari la marca i el diametre.
 * 
 *          Una matrícula ha de tenir 4 números i dues o tres lletres. Un
 *          diametre de la roda ha de ser superior a 0.4 i inferior a 4
 *
 */

public class Main {

	private static VehiclesControler controller = new VehiclesControler();

	public static void main(String[] args) throws Exception {

		// controller.createCotxe("1111AAA", "Renault", "Blau");

		// Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.
		// Crear el cotxe amb les dades anteriors.
		// Afegir-li dues rodes traseres demanant a l’usuari la marca i el diametre.
		// Afegir-li dues rodes davanteres demanant a l’usuari la marca i el diametre.
		controller.createCotxeByUser();

		String allVehicles = controller.getAllVehicles();
		System.out.println("Vehicles" + allVehicles + " \n");

		System.out.println("**PROGRAMA FINALITZAT**");
	}

}
