package com.rockets.model.domain;

public class Propeller {

	private	int    potenciaMax;

	public Propeller(int potenciaMax) {
		super();
		this.potenciaMax = potenciaMax;
	}

	public int getPotenciaMax() {
		return potenciaMax;
	}

	public void setPotenciaMax(int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}

	@Override
	public String toString() {
		return "Propeller [potenciaMax=" + potenciaMax + "]";
	}
	
	
}
