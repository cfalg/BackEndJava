package com.rockets.model.domain;

import javax.swing.JLabel;

public class Propeller implements Runnable {

	private int id;
	private int potenciaMax;
	private int potenciaActual = 0;
	private int potenciaObjectiu;
	private boolean finalitzarPropeller;
	private JLabel label;

	public Propeller(int id, int potenciaMax) {
		super();
		this.id = id;
		this.potenciaMax = potenciaMax;

	}

	public Propeller(int id, int potenciaMax, int potenciaObjectiu) {
		super();
		this.id = id;
		this.potenciaMax = potenciaMax;
		this.potenciaObjectiu = potenciaObjectiu;
	}

	public int getId() {
		return id;
	}

	public int getPotenciaActual() {
		return potenciaActual;
	}

	public void setPotenciaActual(int potenciaActual) {
		this.potenciaActual = potenciaActual;
	}

	public int getPotenciaObjectiu() {
		return potenciaObjectiu;
	}

	public void setPotenciaObjectiu(int potenciaObjectiu) {
		this.potenciaObjectiu = potenciaObjectiu;
	}

	public int getPotenciaMax() {
		return potenciaMax;
	}

	public void setPotenciaMax(int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}

	public boolean isFinalitzarPropeller() {
		return finalitzarPropeller;
	}

	public void setFinalitzarPropeller(boolean finalitzarPropeller) {
		this.finalitzarPropeller = finalitzarPropeller;
	}

	@Override
	public String toString() {
		return "Propeller [id=" + id + ", potenciaMax=" + potenciaMax + ", potenciaActual=" + potenciaActual
				+ ", potenciaObjectiu=" + potenciaObjectiu + ", finalitzarPropeller=" + finalitzarPropeller + "]";
	}

	//
	public int accelerar() {
		if (potenciaActual < potenciaMax && potenciaActual < potenciaObjectiu) {
			potenciaActual++;
		}
		return potenciaActual;
	}

	public int frenar() {
		if (potenciaActual > 0) {
			potenciaActual--;
		}
		return potenciaActual;
	}


	//Nova versió d'aquest métodes que incrementem la velocitat pel valor de les marxes
	public int accelerar(int marxa) {
		if (potenciaActual < potenciaMax && potenciaActual < potenciaObjectiu) {
			potenciaActual= (potenciaActual==0)? 1 :potenciaActual + marxa;
		}
		//com que ara multipliquem la potencia mirarem que si una vegada multiplicat es superior
		//a la potencia Objectiu o Máxima la forçarem a deixarla sobre aquests valors
		potenciaActual=(potenciaActual>potenciaMax)?potenciaActual=potenciaMax:potenciaActual;
		potenciaActual=(potenciaActual>potenciaObjectiu)?potenciaActual=potenciaObjectiu:potenciaActual;
		
		
		return potenciaActual;
	}

	public int frenar(int marxa) {
		if (potenciaActual > 0) {
			potenciaActual=potenciaActual-marxa;
		}
		//vigilem que la potencia no quedi negativa
		potenciaActual=(potenciaActual<0)?potenciaActual=0:potenciaActual;
		return potenciaActual;
	}

	
	public void run() {
		// mentre no se li digui finalitzar = true ha de funcionar el Thread
		while (!this.isFinalitzarPropeller()) {

			if (this.potenciaActual > 0) {
				System.out.println(this.toString());
			}

			// System.out.println(this.getId() + " -- " + this.getPotenciaActual());
			//
			// fem un sleep de 1 segon per veure que faci alguna cosa
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	public void setTextLabel () {
		label.setText(potenciaActual+"");
	}

}
