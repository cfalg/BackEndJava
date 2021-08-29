package com.vehicles.application;

import com.vehicles.project.TipusLlicencia;
import com.vehicles.project.TitularVehicle;
import com.vehicles.project.VehicleException;
import com.vehicles.utilities.Utilities;

public class MenuControler {

	public MenuControler() {
		// TODO Auto-generated constructor stub
	}

	public String getOption() {
		boolean isOk = false;
		String option = null;
		String messageToUser = null;

		messageToUser = "Escull quin Vehicle vols crear: " + " \n";
		messageToUser += "1 = si vols crear un Cotxe." + " \n";
		messageToUser += "2 = si vols crear una Moto" + " \n";
		messageToUser += "3 = si vols crear un Camió" + " \n";

		while (!isOk) {
			try {
				option = Utilities.getUserInput(messageToUser);
				if (Utilities.isNumeric(option)) {
					if (option.equals("1")) {
						isOk = true;
						// return option;
					} else if (option.equals("2")) {
						isOk = true;
						// return option;
					} else if (option.equals("3")) {
						isOk = true;
					} else {
						System.out.println("Opció no correcte" + "\n");
						isOk = false;
					}

				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return option;

	}

	public String getOption(TitularVehicle titular) {
		boolean isOk = false;
		String option = null;

		while (!isOk) {
			option = getOption();
			switch (option) {
			case "1":
				if (titular.getLlicenciaConduir().getTipusLlicencia().equals(TipusLlicencia.COTXE)) {
					isOk = true;
				} else {
					System.out.println("El titular no té la llicencia de COTXE");
				}
				break;
			case "2":
				if (titular.getLlicenciaConduir().getTipusLlicencia().equals(TipusLlicencia.MOTO)) {
					isOk = true;
				} else {
					System.out.println("El titular no té la llicencia de MOTO");
				}
				break;
			case "3":
				if (titular.getLlicenciaConduir().getTipusLlicencia().equals(TipusLlicencia.CAMIO)) {
					isOk = true;
				} else {
					System.out.println("El titular no té la llicencia de CAMIO");
				}
				break;
			default:
				System.out.println("El titular del vehicle no te cap de les llicencies soportadas");
				break;
			}

		}

		return option;

	}

	public boolean IsTitularAlsoConductor() {
		boolean retorn = false;
		String option = null;
		boolean isOk = false;

		while (!isOk) {
			try {
				option = Utilities.getUserInput("El Titular també serà el conductor (S/N)").toUpperCase();
				switch (option) {
				case "S":

					isOk = true;
					retorn = true;
					break;
				case "N":
					isOk = true;
					retorn = false;
					break;
				default:
					throw new VehicleException("**** Opció No correcte");
				}

			} catch (VehicleException e) {
				System.out.println(e.getMessage());
			}

		}
		return retorn;

	}

}
