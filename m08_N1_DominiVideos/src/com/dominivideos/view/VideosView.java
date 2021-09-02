package com.dominivideos.view;

import java.util.ArrayList;

/**
 * Clase VideosView: Clase Vista pels videos
 * 
 * @author Carles Falgueras
 * @version M8.N1.20210901
 * 
 */

import com.dominivideos.utilities.Utilities;


/**
 * Clase VideosView: La Vista dels Videos
 * 
 * @author Carles Falgueras
 * @version M8.N1.20210831
 *
 *
 */


public class VideosView {

	Utilities u = new Utilities();

	public String getVideoTitol() {
		String field = "Titol";
		String message = "Introdueix Titul del Video: " + "\n";
		String resultat = "";
		try {
			resultat = u.getUserInput(message);
			u.checkField(field, resultat);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}

	public String getVideoURL() {
		String field = "URL";
		String message = "Introdueix la URL del Video: " + "\n";
		String resultat = "";
		try {
			resultat = u.getUserInput(message);
			u.checkField(field, resultat);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}

	public ArrayList<String> addTags() {
		ArrayList<String> tags = new ArrayList<>();

		String message = "Vols introduir un altre Tag?  ( 'N' per sortir / un altre tecle per continuar) : " + "\n";
		String resultat = "";

		do {
			tags.add(addOneTag());

			resultat = u.getUserInput(message);

		} while (!resultat.toUpperCase().equals("N"));

		return tags;
	}

	public String addOneTag() {
		String field = "Tag";
		String message = "Introdueix el Tag del Video: " + "\n";
		String resultat = "";

		boolean isOk;
		do {
			isOk = false;

			try {
				resultat = u.getUserInput(message);
				u.checkField(field, resultat);
				isOk = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (!isOk);
		return resultat;
	}

}
