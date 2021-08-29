package com.vehicles.application;

import com.vehicles.utilities.Utilities;

public class MenuControler {

	public MenuControler() {
		// TODO Auto-generated constructor stub
	}

	
	public String getOption() {
		boolean isOk = false;
		String option = null;
		String messageToUser = null;
		
		messageToUser = "Escull quin Vehicle vols crear: " + " \n";
		messageToUser += "1 = si vols crear un Cotxe." + " \n"; 
		messageToUser += "2 = si vols crear una Moto"+ " \n";
		
		
		while (!isOk) {
			try {
				option = Utilities.getUserInput(messageToUser);
				if (Utilities.isNumeric(option)) {
					if (option.equals("1")) {
						isOk=true;
						//return option;
					} else if (option.equals("2")) {
						isOk=true;
						//return option;
					}  else {
						System.out.println("Opció no correcte" + "\n");
						isOk=false;
					}
					
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		return option;
		
	}
}
