
package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

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

	// refem el métode equals per qué torni que son ok si la marca y el diamtre
	// sonigual
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

}
