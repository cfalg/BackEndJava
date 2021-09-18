package com.rockets.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String id;
	private List<Propeller> propulsores = new ArrayList<Propeller>();

	public Rocket(String codigo, int[] prop) {
		super();
		this.id = codigo;
		for (Integer potencia : prop) {
			propulsores.add(new Propeller(potencia));

		}
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
			allPropeller +=" "+ propeller.getPotenciaMax();
		}
		
		return "["+ allPropeller + "]";
	}
	
	@Override
	public String toString() {
		//return "Rocket [id=" + id + "\n" + " Potència Màxima propulsors  " + propulsores + " propulsors" + "]";
		return "Rocket [id=" + id + "\n" + " Potència Màxima propulsors  " + getAllMaxPotPropulsores() + "" + "]";
	}

}
