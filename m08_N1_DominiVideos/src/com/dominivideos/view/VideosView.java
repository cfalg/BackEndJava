package com.dominivideos.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		String message = "Introdueix Titol del Video: " + "\n";
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
		ArrayList<String> tags = new ArrayList<String>();

		String message = "Vols introduir un altre Tag?  " + "\n";
		int resultat = 0;

		do {
			tags.add(addOneTag());

			resultat = JOptionPane.showConfirmDialog(null, message, "Add Tags", JOptionPane.YES_NO_OPTION);
			//Yes=0 y NO=1

		} while ((JOptionPane.YES_OPTION) == resultat);

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

	public int getUsuariVideoId() {
		int resultat = 0;
		String message = "Introdueix el ID del Usuari del Video: " + "\n";
		boolean isOk = false;

		do {
			String preResultat = u.getUserInput(message);

			if (u.isNumeric(preResultat)) {
				resultat = Integer.parseInt(preResultat);
				isOk = true;
			} else {
				message = "Error. El valor introduit ha de ser numéric \n" + message;
			}

		} while (!isOk);

		return resultat;
	}

}
