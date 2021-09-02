package com.dominivideos.view;

import com.dominivideos.application.UsuarisControler;
import com.dominivideos.application.VideosControler;

/**
 * Clase main per on començarà el projecte
 * 
 * @author Carles Falgueras
 * @version M8.N1.20210831
 *
 *
 */

public class Main {

	private static UsuarisControler userControler = new UsuarisControler();
	private static VideosControler videoControler = new VideosControler();

	public static void main(String[] args) {

		System.out.println("Inici programa");

		// creem un usuari Auto
		userControler.createUsuariAuto();
		// imprimim els usuaris que tenem (1 en aquest cas)
		System.out.println("Usuaris " + userControler.getAllUsuaris());

		// creem un video Auto
		videoControler.createVideoAuto();
		// imprimir els videos ((1 en aquest cas)
		System.out.println("Videos " + videoControler.getAllVideos());

		// creem un video Auto
		videoControler.createVideoUser();

		// imprimir els videos ((1 en aquest cas)
		System.out.println("Videos " + videoControler.getAllVideos());
	}

}
