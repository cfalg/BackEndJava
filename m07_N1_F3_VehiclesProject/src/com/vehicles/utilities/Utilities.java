package com.vehicles.utilities;

import java.util.Scanner;

public class Utilities {

//	public Utilities() {
//		// TODO Auto-generated constructor stub
//	}

	
	private static Scanner reader;

	/**
	 * Mètode per mostrar missatge al usuari i obtenir la resposta d'aquest
	 * 
	 * @param messageToUser
	 *            Missatge a mostrar al usuari
	 * @return Valor que ha introduït el usuari
	 */
	public static String getUserInput(String messageToUser) {
		
		System.out.print(messageToUser);
		reader = new Scanner(System.in);
		String s = reader.nextLine();
		// sc.close(); NO entec el pq però ho he de deixar obert
		return s;
	}
	
	
	/**
	 * Funció per validar si un text es un númeric o no
	 * 
	 * @param str
	 *            string
	 * @return True si es un nunéric / False si no ho és
	 */
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	
}
