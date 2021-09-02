package com.dominivideos.application;

import com.dominivideos.persistence.UsuarisRepository;
import com.dominivideos.project.Usuari;


/**
 * Clase UsuarisControler: Clase controladora pels usuaris
 * 
 * @author Carles Falgueras
 * @version M8.N1.20210901
 * 
 */

public class UsuarisControler {

	private UsuarisRepository repository;

	public UsuarisControler() {
		repository = new UsuarisRepository();
	}

	/**
	 * Llistem tots el usuaris
	 */
	public String getAllUsuaris() {
		String allUsuaris = "\n";

		for (Usuari e : repository.getAllUsuaris()) {
			allUsuaris += e.toString() + " \n";
		}
		return allUsuaris;
	}

	/**
	 * mètode per afegir un usuari
	 */
	public void createUser(String nom, String cognom, String password) throws Exception {
		Usuari usuari = new Usuari(nom, cognom, password);
		repository.addUsuari(usuari);
	}

	/**
	 * Mètode per afegir un usuari de forma automática (per les proves)
	 */
	public void createUsuariAuto() {
		String nom = "Albert";
		String cognom = "Mercader Planes";
		String password = "12345";

		System.out.println("AUTO les dades de un Usuari: \n");
		try {
			createUser(nom, cognom, password);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

}
