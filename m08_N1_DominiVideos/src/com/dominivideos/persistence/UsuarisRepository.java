package com.dominivideos.persistence;

import java.util.ArrayList;
import java.util.List;

import com.dominivideos.project.Usuari;

/**
 * Repository on guardar els usuaris
 * 
 * @author Carles Falgueras
 *
 */

public class UsuarisRepository {

	private static List<Usuari> usuaris = new ArrayList<>();

	public UsuarisRepository() {

	}

	public List<Usuari> getAllUsuaris() {
		return new ArrayList<>(usuaris);
	}

	public void addUsuari(Usuari usuari) throws Exception {
		if (usuari == null)
			throw new Exception();
		usuaris.add(usuari);
	}

	public Usuari getUsuari(int idx) {
		return usuaris.get(idx);
	}
}
