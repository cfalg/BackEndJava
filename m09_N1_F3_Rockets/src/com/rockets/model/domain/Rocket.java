package com.rockets.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String id;
	private List<Propeller> propulsores = new ArrayList<Propeller>();

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
		// return "Rocket [id=" + id + "\n" + " Potència Màxima propulsors " +
		// propulsores + " propulsors" + "]";
		return "Rocket [id=" + id + "\n" + " Potència Màxima propulsors  " + getAllMaxPotPropulsores() + "" + "]";
	}

	public void addPropeller(Propeller propulsor) {
		if (propulsor != null)
			this.propulsores.add(propulsor);

	}

	public void accelerar(int idPropeller) {
		if (idPropeller<= this.getPropulsores().size()-1) {
			this.propulsores.get(idPropeller).accelerar();
		} else
		{
			System.out.println("Propulsor no trobat");
		}
	}

	public void frenar(int idPropeller) {
		if (idPropeller<= this.getPropulsores().size()-1) {
			this.propulsores.get(idPropeller).frenar();
		} else
		{
			System.out.println("Propulsor no trobat");
		}

	}

	// métode per iniciar els propulsors
	public void starPropeller() {
		if (this.propulsores != null) {
			for (Propeller propeller : propulsores) {
				new Thread(propeller).start();
				 System.out.println("Star Rocket "+ this.getCodigo() +" - " +
				 propeller.toString() );
			}
		}

	}

	// métode per parar els propulsors, activem el parametro boleà pq s'enteri
	// l'objecte propulsor que haurà de parar
	public void stopPropeller() {
		if (this.propulsores != null) {
			for (Propeller propeller : propulsores) {
				propeller.setFinalitzarPropeller(true);
				System.out.println("Stop Rocket " + this.getCodigo() +" - " +propeller.getId() + " ");
			}
		}
	}
}
