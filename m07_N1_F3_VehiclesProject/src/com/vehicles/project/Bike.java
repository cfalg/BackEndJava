package com.vehicles.project;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	
	/**
	 * Creem unètode per afegir les 2 rodes. 1 de Davand i l'altre del darrera
	 * 
	 * @param frontWheel Roda del davant
	 * @param backWheel Roda del darrera
	 */
	public void addWheels(Wheel frontWheel, Wheel backWheel ) {
		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}


	@Override
	public String toString() {
		return "Bike [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + "]";
	}
	
	
	
	
}
