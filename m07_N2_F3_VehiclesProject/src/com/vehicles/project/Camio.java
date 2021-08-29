package com.vehicles.project;

import java.util.List;

public class Camio extends Vehicle {

	public Camio(String plate, String brand, String color) {
		super(plate, brand, color);
		
	}
	
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels, List<Wheel> backWheels2) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
		addTwoWheels(backWheels2);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}

	
	@Override
	public String toString() {
		return "Truck [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + "]";
	}

}
