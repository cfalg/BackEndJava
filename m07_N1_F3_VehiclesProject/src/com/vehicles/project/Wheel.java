package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	// public Wheel() {
	//
	// }

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;

	}

	/**
	 * Métode sobre escrit per validar si ens entren dues rodes que tenen la mateixa
	 * Brand i diametre les considerarem iguals
	 * 
	 * @param otherWheel
	 *            objecte altre roda
	 * @return si es igual ono
	 */
	// refem el métode equals per qué torni que son ok si la marca y el diamtre
	public boolean equals(Wheel otherWheel) {
		boolean isEqual = false;

		if (this.getBrand() == otherWheel.getBrand() && this.getDiameter() == otherWheel.getDiameter()) {
			isEqual = true;
		}

		return isEqual;
	}

	@Override
	public String toString() {
		return "Wheel [brand=" + brand + ", diameter=" + diameter + "]";
	}

	/**
	 * mètode que validará que Un diametre de la roda ha de ser superior a 0.4 i
	 * inferior a 4
	 * 
	 * @param diameter2
	 * @return true si es ok / false si no ho es
	 */
	public static boolean isDiameterOk(double diameter) {

		return (diameter > 0.4 && diameter < 4) ? true : false;

	}

}
