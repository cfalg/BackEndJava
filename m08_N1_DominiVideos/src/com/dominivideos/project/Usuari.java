package com.dominivideos.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase Usuari: està format per un nom, cognom, password i una data de registre
 * 
 * @author Carles Falgueras
 * @version M8.N1.20210831
 * 
 */

public class Usuari {

	private String nom;
	private String cognom;
	private String password;
	private Date dataRegistre;
	private List<Video> videos = new ArrayList<Video>();

	public Usuari(String nom, String cognom, String password) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.password = password;
		this.dataRegistre = new Date();
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	@Override
	public String toString() {
		return "Usuari [nom=" + nom + ", cognom=" + cognom + ", password=" + password + ", dataRegistre=" + dataRegistre.toString()
				+ ", videos=" + videos + "]";
	}

	
	
	
}
