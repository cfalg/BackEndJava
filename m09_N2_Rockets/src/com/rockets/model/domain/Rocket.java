package com.rockets.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String id;
	private List<Propeller> propulsores = new ArrayList<Propeller>();
	private double velocitat = 0;

	public Rocket(String codigo, int[] prop) {

		super();
		this.id = codigo;
		int i = 0;
		for (Integer potencia : prop) {
			i++;
			propulsores.add(new Propeller(i, potencia));
		}
	}

	public Rocket(String codigo) {
		super();
		this.id = codigo;
	}

	public String getCodigo() {
		return id;
	}

	public void setCodigo(String codigo) {
		this.id = codigo;
	}

	public List<Propeller> getPropulsores() {
		return propulsores;
	}

	public void setPropulsores(List<Propeller> propulsores) {
		this.propulsores = propulsores;
	}

	public String getAllMaxPotPropulsores() {
		String allPropeller = "";
		for (Propeller propeller : propulsores) {
			allPropeller += " " + propeller.getPotenciaMax();
		}

		return "[" + allPropeller + "]";
	}

	@Override
	public String toString() {
//		return "Rocket [id=" + id + ", propulsores=" + propulsores + ", velocitat=" + velocitat + "]";
		return "Rocket [id=" + id + "\n" + " Potència Màxima propulsors  " + getAllMaxPotPropulsores() + ", velocitat="
				+ velocitat + "]";
	}

	public void addPropeller(Propeller propulsor) {
		if (propulsor != null)
			this.propulsores.add(propulsor);

	}

	public void accelerar(int idPropeller) {
		if (idPropeller <= this.getPropulsores().size() - 1) {
			this.propulsores.get(idPropeller).accelerar();
		} else {
			System.out.println("Propulsor no trobat");
		}
		// cridem al métode per actualitzar la velocitat del Coet
		actualitzarVelocitat();
	}

	public void frenar(int idPropeller) {
		if (idPropeller <= this.getPropulsores().size() - 1) {
			this.propulsores.get(idPropeller).frenar();
		} else {
			System.out.println("Propulsor no trobat");
		}
		// cridem al métode per actualitzar la velocitat del Coet
		actualitzarVelocitat();

	}

	// métode per iniciar els propulsors
	public void starPropeller() {
		if (this.propulsores != null) {
			for (Propeller propeller : propulsores) {
				new Thread(propeller).start();
				System.out.println("Star Rocket " + this.getCodigo() + " - " + propeller.toString());
			}
		}

		System.out.println("\n");
	}

	// métode per parar els propulsors, activem el parametro boleà pq s'enteri
	// l'objecte propulsor que haurà de parar
	public void stopPropeller() {
		if (this.propulsores != null) {
			for (Propeller propeller : propulsores) {
				propeller.setFinalitzarPropeller(true);
				System.out.println("Stop Rocket " + this.getCodigo() + " - " + propeller.getId() + " ");
			}
		}
		System.out.println("\n");
	}

	public double getVelocitat() {
		return velocitat;
	}

	public void setVelocitat(int potenciaTotal) {
		this.velocitat = 100 * Math.sqrt(potenciaTotal);
	}

	void actualitzarVelocitat() {
		int potenciaTotal = 0;

		for (Propeller p : this.getPropulsores()) {
			potenciaTotal += p.getPotenciaActual();
		}
		this.setVelocitat(potenciaTotal);
		System.out.println("Velocitat Rocket " + this.id + " = " + this.getVelocitat());

	}
}
