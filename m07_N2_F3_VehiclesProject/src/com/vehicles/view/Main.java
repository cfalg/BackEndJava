package com.vehicles.view;

import com.vehicles.application.MenuControler;
import com.vehicles.application.PersonesControler;
import com.vehicles.application.VehiclesControler;
import com.vehicles.project.TitularVehicle;

/**
 * Clase main per on començarà el projecte
 * 
 * @author Carles Falgueras
 * @version M7.N2.F3.20210826
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
 *          Nivell 2
 *          FASE 1:
 *          Modifica l’exercici per afegir camió com a vehicle disponible.
 * 
 *          FASE 2:
 *          Crea dos classes: Titular de Vehicle i Conductor (també fes una
 *          classe Persona com a herència). El conductor ha de tenir, nom,
 *          cognoms, data de naixement i llicencia de conduir. Aquest ultima
 *          també serà una classe a part que tindrà: ID, tipus de llicència, nom
 *          complet i data de caducitat. El Titular ha de tenir els mateixos
 *          valors que el conductor, però també s'ha de registrar si té
 *          assegurança i garatge propi.
 * 
 *          FASE 3:
 *          Abans de seleccionar el vehicle has de crear l'usuari (tipus
 *          Titular) amb totes les dades ja emplenades. Per poder crear un
 *          vehicle has de tenir la llicència adequada, de no tenir-la t'ha
 *          d'avisar amb una excepció. A l'acabar de crear el vehicle, ha de
 *          demanar si el titular també serà el conductor. De no ser així has de
 *          crear un nou usuari. En fer-ho hi ha de comprovar si la llicència
 *          del conductor li permet conduir el vehicle creat.
 */

public class Main {

	private static VehiclesControler controller = new VehiclesControler();
	private static MenuControler menuController = new MenuControler();
	private static PersonesControler personesController = new PersonesControler();

	public static void main(String[] args) throws Exception {

		// controller.createCotxe("1111AAA", "Renault", "Blau");

		// Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.
		// Crear el cotxe amb les dades anteriors.
		// Afegir-li dues rodes traseres demanant a l’usuari la marca i el diametre.
		// Afegir-li dues rodes davanteres demanant a l’usuari la marca i el diametre.

		// Creem un Titular del Vehicle abans de seleccionar el Vehicle
		personesController.createTitularVehicleAuto();
		// p
		System.out.println("Persones " + personesController.getAllPersones() + "\n");

		String opcio = menuController.getOption((TitularVehicle) personesController.getPersona(0));

		switch (opcio) {
		case "1": // cotxe
			controller.createCotxeByUser();
			// controller.createCotxeAuto();
			break;
		case "2": // moto
			controller.createBikeByUser();
			break;
		case "3": // camio
			controller.createCamioByUser();
			break;

		default:
			break;
		}

		String allVehicles = controller.getAllVehicles();
		System.out.println("Vehicles" + allVehicles + " \n");

		// A l'acabar de crear el vehicle, ha de demanar si el titular també serà el
		// conductor. De no ser així has de crear un nou usuari. En fer-ho hi ha de
		// comprovar si la llicència del conductor li permet conduir el vehicle creat.
		if (!menuController.IsTitularAlsoConductor()) {
			// Creem un Conductor per veure que funciona
			personesController.createConductorAuto(opcio);

		}

		// Creem un Titular del Vehicle per veure que funciona
		// personesController.createTitularVehicleAuto();

		// pintem totes les persones
		System.out.println("Persones " + personesController.getAllPersones() + "\n");

		System.out.println("**PROGRAMA FINALITZAT**");
	}

}
