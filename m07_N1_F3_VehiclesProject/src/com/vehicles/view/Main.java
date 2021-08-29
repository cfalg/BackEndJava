package com.vehicles.view;

import com.vehicles.application.MenuControler;
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
 *          FASE 3:
 *          Modifica el projecte anterior afegint els mètodes necessaris a Bike,
 *          de manera que es pugui afegir rodes davanteres i traseres.
 *          Modificar el Main anterior, afegint la opció de Bike o Car:
 *          0) Preguntar a l’usuari si vol crear un cotxe o una moto. 1) Demanar
 *          a l’usuari la matrícula, la marca i el seu color.
 *          2) Crear el vehícle amb les dades anteriors.
 *          3) Afegir-li les rodes traseres corresponents, demanant a l’usuari
 *          la marca i el diametre.
 *          4) Afegir-li les rodes davanteres corresponents, demanant a l’usuari
 *          la marca i el diametre.
 *
 */

public class Main {

	private static VehiclesControler controller = new VehiclesControler();
	private static MenuControler menuController = new MenuControler();

	public static void main(String[] args) throws Exception {

		// controller.createCotxe("1111AAA", "Renault", "Blau");

		// Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.
		// Crear el cotxe amb les dades anteriors.
		// Afegir-li dues rodes traseres demanant a l’usuari la marca i el diametre.
		// Afegir-li dues rodes davanteres demanant a l’usuari la marca i el diametre.

		String opcio = menuController.getOption();

		if (opcio.equals("1")) {
			controller.createCotxeByUser();
		} else // if (opcio.equals("2"))
		{
			controller.createBikeByUser();

		}

		String allVehicles = controller.getAllVehicles();
		System.out.println("Vehicles" + allVehicles + " \n");

		System.out.println("**PROGRAMA FINALITZAT**");
	}

}
