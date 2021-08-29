package com.vehicles.application;

import com.vehicles.persistence.PersonesRepository;
import com.vehicles.project.AbsPersona;
import com.vehicles.project.Conductor;
import com.vehicles.project.LLicenciaConduir;
import com.vehicles.project.TitularVehicle;

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
		String tipusLlicencia = "A";
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
		String tipusLlicencia = "B";
		String nomComplert = nom + " " + cognoms;
		int diaCaducitat = 2;
		int mesCaducitat = 2;
		int anyCaducitat = 2023;
		LLicenciaConduir llicenciaConduir = new LLicenciaConduir(tipusLlicencia, nomComplert, diaCaducitat,
				mesCaducitat, anyCaducitat);
		//Dades extres del Titular del Vehicle
		boolean siTeAsseguranca= true;
		boolean siTeGaratgePropi=false;
		

		TitularVehicle titular = new TitularVehicle(nom, cognoms, dia, mes, any, llicenciaConduir, siTeAsseguranca,
				siTeGaratgePropi);
		repository.addMember(titular);
	}

}
