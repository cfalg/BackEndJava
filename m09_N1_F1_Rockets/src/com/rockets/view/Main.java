package com.rockets.view;

import com.rockets.model.domain.Rocket;

public class Main {

	public static void main(String[] args) {

		System.out.println("INICI PROGRAMA");
		
		int[] propulsores1 = { 10, 30, 80 };
		int[] propulsores2 = { 30, 40, 50, 50, 30, 10 };

		Rocket rocketU = new Rocket("32WESSDS", propulsores1);
		Rocket rocketDos = new Rocket("LDSFJA32", propulsores2);
		
		System.out.println(rocketU.toString());
		System.out.println(rocketDos.toString());

		System.out.println("FI DEL PROGRAMA");
	}
}
