package com.dominivideos.model.persistence;

import java.util.ArrayList;
import java.util.List;

import com.dominivideos.model.domain.Usuari;
import com.dominivideos.model.domain.VideoException;

/**
 * Repository on guardar els usuaris
 * 
 * @author Carles Falgueras
 *
 */

public class UsuarisRepository {

	private static List<Usuari> usuaris = new ArrayList<Usuari>();

	public UsuarisRepository() {

	}

	public List<Usuari> getAllUsuaris() {
		return new ArrayList<Usuari>(usuaris);
	}

	public void addUsuari(Usuari usuari) throws Exception {
		if (usuari == null)
			throw new Exception();
		usuaris.add(usuari);
	}

	public Usuari getUsuari(int idx) throws Exception {

		try {
			return usuaris.get(idx);
		} catch (IndexOutOfBoundsException e) {
			throw new VideoException("Usuari inexistent");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}
}
