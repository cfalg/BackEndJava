package com.vehicles.project;

import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
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
		return "Car [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + "]";
	}

	/**
	 * Métode que validará el format de la matrícula
	 * 
	 * @param plate
	 *            matrícula
	 * @return si es format correcte o no
	 */
	public static boolean isPlateOk(String plate) {
		boolean isOk = false;

		// validem que la mida de la matricula ha de ser entre
		if (plate.length() == 6 || plate.length() == 7) {
			isOk = true;
		}

		// validem que els 4 primers caracters siguin numeros
		if (isOk == true) {

			for (int i = 0; i < 3; i++) {

				isOk = (Character.isDigit(plate.charAt(i))) ? true : false;
				if (isOk == false) {
					break;
				}
			}
		}

		// validem que els 2 o 3 últims caracters siguin lletres
		if (isOk == true) {
			for (int i = 4; i < plate.length(); i++) {
				isOk = (Character.isLetter(plate.charAt(i))) ? true : false;
				if (isOk == false) {
					break;
				}
			}
		}

		return isOk;

	}

}
