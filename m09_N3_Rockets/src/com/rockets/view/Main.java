package com.rockets.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.rockets.controller.RocketControler;
import com.rockets.model.domain.Rocket;

public class Main {

	private static RocketControler rocketControler = new RocketControler();
	private static Rocket rocket1;
	private static Rocket rocket2;

	public static void main(String[] args) {

		System.out.println("INICI PROGRAMA");

		// Crem els dos Coets
		try {
			rocket1 = rocketControler.createRocket1();
			rocket2 = rocketControler.createRocket2();

			System.out.println("Rockets creats " + rocketControler.getAllRockets() + "\n");

			// activem propulsors dels coetes
//			rocketControler.activarRocket(0);
//			rocketControler.activarRocket(1);


			//Creem la pantalla o Frame principal
			JFrame marco = new MainScreen(rocket1, rocket2, rocketControler);
			marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			marco.setVisible(true);
			
			
//			gestionarRockets(rocket1, rocket2);

			
//			rocketControler.pararRocket(0);
//			rocketControler.pararRocket(1);					

			

			//System.out.println("FI DEL PROGRAMA");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void gestionarRockets(Rocket rocket1, Rocket rocket2) {
		boolean continuar = true;

//		Object[] options1 = new ArrayList<String>();
//		for (Propeller e : rocket1.getPropulsores()) {
//			options1.add(rocket1.getCodigo() + " - " + e.getId() + " +");
//			options1.add(rocket1.getCodigo() + " - " + e.getId() + " -");
//		}
//
//		ArrayList<String> options2 = new ArrayList<String>();
//		for (Propeller e : rocket2.getPropulsores()) {
//			options1.add(rocket2.getCodigo() + " - " + e.getId() + " +");
//			options1.add(rocket2.getCodigo() + " - " + e.getId() + " -");
//		}

		String[] options = { "32WESSDS 1 +", "32WESSDS 1 -", "32WESSDS 2 +", "32WESSDS 2 -", "32WESSDS 3 +",
				"32WESSDS 3 -", "LDSFJA32 1 +", "LDSFJA32 1 -", "LDSFJA32 2 +", "LDSFJA32 2 -", "LDSFJA32 3 +",
				"LDSFJA32 3 -", "LDSFJA32 4 +", "LDSFJA32 4 -", "LDSFJA32 5 +", "LDSFJA32 5 -", "LDSFJA32 6 +",
				"LDSFJA32 6 -", "Sortir",

		};

//
//				
		while (continuar) {

			int seleccion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
																							// defecto.
					options, null);

			switch (seleccion) {
			case 0:
				rocket1.accelerar(0);
				break;
			case 1:
				rocket1.frenar(0);
				break;
			case 2:
				rocket1.accelerar(1);
				break;
			case 3:
				rocket1.frenar(1);
				break;
			case 4:
				rocket1.accelerar(2);
				break;
			case 5:
				rocket1.frenar(2);
				break;
			case 6:
				rocket2.accelerar(0);
				break;
			case 7:
				rocket2.frenar(0);
				break;
			case 8:
				rocket2.accelerar(1);
				break;
			case 9:
				rocket2.frenar(1);
				break;
			case 10:
				rocket2.accelerar(2);
				break;
			case 11:
				rocket2.frenar(2);
				break;
			case 12:
				rocket2.accelerar(3);
				break;
			case 13:
				rocket2.frenar(3);
				break;
			case 14:
				rocket2.accelerar(4);
				break;
			case 15:
				rocket2.frenar(4);
				break;
			case 16:
				rocket2.accelerar(5);
				break;
			case 17:
				rocket2.frenar(5);
				break;
			case 18:
				continuar = false;
				//System.out.println("seleccionada opcion Sortir ");
				break;

			}
		}

	}
}
