package com.vehicles.application;

import com.vehicles.persistence.PersonesRepository;
import com.vehicles.project.AbsPersona;
import com.vehicles.project.Conductor;
import com.vehicles.project.LLicenciaConduir;
import com.vehicles.project.TipusLlicencia;
import com.vehicles.project.TitularVehicle;
import com.vehicles.project.VehicleException;
import com.vehicles.utilities.Utilities;

public class PersonesControler {

	private PersonesRepository repository;

	public PersonesControler() {
		repository = new PersonesRepository();
	}

	public void createConductor(String nom, String cognoms, int dia, int mes, int any,
			LLicenciaConduir llicenciaConduir) throws Exception {
		Conductor conductor = new Conductor(nom, cognoms, dia, mes, any, llicenciaConduir);
		repository.addMember(conductor);
	}

	public void createTitularVehicle(String nom, String cognoms, int dia, int mes, int any,
			LLicenciaConduir llicenciaConduir, boolean siTeAsseguranca, boolean siTeGaratgePropi) throws Exception {
		TitularVehicle titular = new TitularVehicle(nom, cognoms, dia, mes, any, llicenciaConduir, siTeAsseguranca,
				siTeGaratgePropi);
		repository.addMember(titular);
	}

	public String getAllPersones() {
		String allPersones = " \n";

		for (AbsPersona e : repository.getAllMembers()) {
			allPersones += e.toString() + " \n";
		}

		return allPersones;
	}

	public void createConductorAuto() throws Exception {
		String nom = "Albert";
		String cognoms = "Jordana Perez";
		int dia = 1;
		int mes = 1;
		int any = 1970;
		// dades per la llicencia
		TipusLlicencia tipusLlicencia = TipusLlicencia.COTXE;
		String nomComplert = nom + " " + cognoms;
		int diaCaducitat = 1;
		int mesCaducitat = 1;
		int anyCaducitat = 2022;
		LLicenciaConduir llicenciaConduir = new LLicenciaConduir(tipusLlicencia, nomComplert, diaCaducitat,
				mesCaducitat, anyCaducitat);

		Conductor conductor = new Conductor(nom, cognoms, dia, mes, any, llicenciaConduir);
		repository.addMember(conductor);
	}

	public void createTitularVehicleAuto() throws Exception {
		String nom = "Maria";
		String cognoms = "Gomez Ferrer";
		int dia = 2;
		int mes = 2;
		int any = 1974;
		// dades per la llicencia
		TipusLlicencia tipusLlicencia = TipusLlicencia.COTXE;
		String nomComplert = nom + " " + cognoms;
		int diaCaducitat = 2;
		int mesCaducitat = 2;
		int anyCaducitat = 2023;
		LLicenciaConduir llicenciaConduir = new LLicenciaConduir(tipusLlicencia, nomComplert, diaCaducitat,
				mesCaducitat, anyCaducitat);
		// Dades extres del Titular del Vehicle
		boolean siTeAsseguranca = true;
		boolean siTeGaratgePropi = false;

		TitularVehicle titular = new TitularVehicle(nom, cognoms, dia, mes, any, llicenciaConduir, siTeAsseguranca,
				siTeGaratgePropi);
		repository.addMember(titular);
	}

	public void createTitularVehicleByUser() throws Exception {
		String nom = Utilities.getUserInput("Introdueix el nom del Conductor:");
		String cognoms = "Gomez Ferrer";
		int dia = 2;
		int mes = 2;
		int any = 1974;
		// dades per la llicencia
		TipusLlicencia tipusLlicencia = TipusLlicencia.MOTO;
		String nomComplert = nom + " " + cognoms;
		int diaCaducitat = 2;
		int mesCaducitat = 2;
		int anyCaducitat = 2023;
		LLicenciaConduir llicenciaConduir = new LLicenciaConduir(tipusLlicencia, nomComplert, diaCaducitat,
				mesCaducitat, anyCaducitat);
		// Dades extres del Titular del Vehicle
		boolean siTeAsseguranca = true;
		boolean siTeGaratgePropi = false;

		TitularVehicle titular = new TitularVehicle(nom, cognoms, dia, mes, any, llicenciaConduir, siTeAsseguranca,
				siTeGaratgePropi);
		repository.addMember(titular);
	}

	public AbsPersona getPersona(int idx) {
		return repository.getMember(idx);
	}

	public void createConductorAuto(String opcio) throws Exception {
		try {
			String nom = "Albert";
			String cognoms = "Jordana Perez";
			int dia = 1;
			int mes = 1;
			int any = 1970;
			// dades per la llicencia
			TipusLlicencia tipusLlicencia = TipusLlicencia.COTXE;
			if (!TeLlicenciaElConductor(opcio, tipusLlicencia)) {
				throw new VehicleException(
						"El conductor NO te la llicencia per dur el Vehicle. No es crea el conductor");
			}

			String nomComplert = nom + " " + cognoms;
			int diaCaducitat = 1;
			int mesCaducitat = 1;
			int anyCaducitat = 2022;
			LLicenciaConduir llicenciaConduir = new LLicenciaConduir(tipusLlicencia, nomComplert, diaCaducitat,
					mesCaducitat, anyCaducitat);

			Conductor conductor = new Conductor(nom, cognoms, dia, mes, any, llicenciaConduir);
			repository.addMember(conductor);

		} catch (VehicleException e) {

			System.out.println(e.getMessage());
		}

	}

	public boolean TeLlicenciaElConductor(String Opcio, TipusLlicencia tipusLlicencia) {
		boolean retorn = false;

		if (Opcio.equals("1") && tipusLlicencia.equals(TipusLlicencia.COTXE)) {
			retorn = true;
		} else if (Opcio.equals("2") && tipusLlicencia.equals(TipusLlicencia.MOTO)) {
			retorn = true;
		} else if (Opcio.equals("3") && tipusLlicencia.equals(TipusLlicencia.CAMIO)) {
			retorn = true;
		} else {
			retorn = false;
		}

		return retorn;
	}
}
