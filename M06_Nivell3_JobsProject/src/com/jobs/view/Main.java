package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 6000.0);
		controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 4000.0);
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 4500.0);
		//[CFV - 21/07/2021] -- Nous empleats Nivell 2
		controller.createJuniorEmployee("Employee Junior", "Dirección molona 5", "625555555", 1200);
		controller.createMidEmployee("Employee Mid", "Dirección molona 6", "626666666", 2000);
		controller.createSeniorEmployee("Employee Senior", "Dirección molona 7", "627777777", 3000);
		
		controller.payAllEmployeers();
		
		//Nivell 3
		controller.payBonusAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees + " \n");
		
	}

}
