package com.dominivideos.model.domain;

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

	private static int ID_CONTADOR = 0;
	protected int id;
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
        this.id = ID_CONTADOR;
        ID_CONTADOR++;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public void addVideo(Video video) {
		this.videos.add(video);
	}
	
	@Override
	public String toString() {
		return "Usuari [id="+ String.valueOf(id) +" nom= " + nom + ", cognom=" + cognom + ", password=" + password + ", dataRegistre=" + dataRegistre.toString()
				+ ", videos=" + videos + "]";
	}

	
	
	
	
}
