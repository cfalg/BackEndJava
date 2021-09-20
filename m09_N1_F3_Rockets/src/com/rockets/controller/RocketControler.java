package com.rockets.controller;

import com.rockets.model.domain.Propeller;
import com.rockets.model.domain.Rocket;
import com.rockets.model.persistence.RocketRepository;

public class RocketControler {

	private RocketRepository repository;

	public RocketControler() {
		repository = new RocketRepository();
	}

	/**
	 * llistem tots els rockets
	 */
	public String getAllRockets() {
		String allRockets = "\n";

		for (Rocket e : repository.getAllRockets()) {
			allRockets += e.toString() + "\n";
		}
		return allRockets;
	}

	/**
	 * métode per crear el Rocket1
	 */
	public Rocket createRocket1() throws Exception {
		Rocket rocketU = new Rocket("32WESSDS");
		rocketU.addPropeller(new Propeller(1, 10, 8));
		rocketU.addPropeller(new Propeller(2, 30, 25));
		rocketU.addPropeller(new Propeller(3, 80, 60));

		repository.addRocket(rocketU);
		return rocketU;
		//System.out.println(rocketU.toString());
	}

	/**
	 * métode per crear el Rocket2
	 */
	public Rocket createRocket2() throws Exception {
		Rocket rocketDos = new Rocket("LDSFJA32");
		rocketDos.addPropeller(new Propeller(1, 30, 8));
		rocketDos.addPropeller(new Propeller(2, 40, 25));
		rocketDos.addPropeller(new Propeller(3, 50, 30));
		rocketDos.addPropeller(new Propeller(4, 50, 22));
		rocketDos.addPropeller(new Propeller(5, 30, 10));
		rocketDos.addPropeller(new Propeller(6, 10, 2));
		
		repository.addRocket(rocketDos);
		return rocketDos;
		
		//System.out.println(rocketDos.toString());
	}

	//métode que inicialitzará el Rocketu = 0
	public void activarRocket(int i) {
		try {
			repository.getRocket(i).starPropeller();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void pararRocket(int i) {
		try {
			repository.getRocket(i).stopPropeller();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
