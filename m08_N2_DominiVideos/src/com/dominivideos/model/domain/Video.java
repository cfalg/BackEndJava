package com.dominivideos.model.domain; //o Model

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Video: està format por una URL, un títol i una llista de tags*.
 * 
 * @author Carles Falgueras
 * @version M8.N1.20210831
 * 
 */

public class Video {

	private String url;
	private String titol;
	private ArrayList<String> tags;
	// Nivell 2
	private Date dataPujada;
	private EstatVideo estatVideo;

	
	
	public Video(String url, String titol) {
		super();
		this.url = url;
		this.titol = titol;
		this.tags = null;
		this.dataPujada = new Date();
		this.estatVideo = EstatVideo.UPLOADING;
	}

	public Video(String url, String titol, ArrayList<String> tags) {
		super();
		this.url = url;
		this.titol = titol;
		this.tags = tags;
		this.dataPujada = new Date();
		this.estatVideo = EstatVideo.UPLOADING;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public EstatVideo getEstatVideo() {
//		en funcio de la data que es crida obtenim un valor o l'altre
		Date dataConsulta = new Date();

		long fechaInicialMs = this.dataPujada.getTime();
		long fechaFinalMs = dataConsulta.getTime();
		long diferencia = fechaFinalMs - fechaInicialMs;
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));

		//System.out.println(diferencia);
		
		if (diferencia<(60*1000)) {
			this.estatVideo=EstatVideo.UPLOADING;
		} else if (diferencia<(60*1000*3)) {
			this.estatVideo=EstatVideo.VERIFYING;
		} else {
			this.estatVideo=EstatVideo.PUBLIC;
		}

		return estatVideo;

	}
	
	public void setEstatVideo(EstatVideo estatVideo) {
		this.estatVideo = estatVideo;
	}
	

	@Override
	public String toString() {
		return "Video [titol=" + titol + ", url=" + url + ", tags=" + tags + ", dataPujada=" + dataPujada
				+ ", estatVideo=" + this.getEstatVideo() + "]";
	}

}
