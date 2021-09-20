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
	// Nivell 3
	private StatusVideo statusVideo;
	private long duradaVideo;
	private long tempsActualReproduccio;

	// creem un constructor private i buit per inicializar valors del video
	private Video() {
		this.dataPujada = new Date();
		this.estatVideo = EstatVideo.UPLOADING;
		this.statusVideo = StatusVideo.PARAT;
	}

	public Video(String url, String titol) {
		this();
		this.url = url;
		this.titol = titol;
		this.tags = null;

	}

	public Video(String url, String titol, ArrayList<String> tags) {
		this(url, titol);
		this.tags = tags;
		this.dataPujada = new Date();
	}

	public Video(String url, String titol, ArrayList<String> tags, long duradaVideo) {
		this(url, titol, tags);
		this.duradaVideo = duradaVideo;
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

		// System.out.println(diferencia);

		if (diferencia < (60 * 1000)) {
			this.estatVideo = EstatVideo.UPLOADING;
		} else if (diferencia < (60 * 1000 * 3)) {
			this.estatVideo = EstatVideo.VERIFYING;
		} else {
			this.estatVideo = EstatVideo.PUBLIC;
		}

		return estatVideo;

	}

	public void setEstatVideo(EstatVideo estatVideo) {
		this.estatVideo = estatVideo;
	}

	public StatusVideo getStatusVideo() {
		return statusVideo;
	}

	public void setStatusVideo(StatusVideo statusVideo) {
		this.statusVideo = statusVideo;
	}

	public long getDuradaVideo() {
		return duradaVideo;
	}

	public void setDuradaVideo(long duradaVideo) {
		this.duradaVideo = duradaVideo;
	}

	public Date getDataPujada() {
		return dataPujada;
	}

	public long getTempsActualReproduccio() {
		return tempsActualReproduccio;
	}

	public void setTempsActualReproduccio(long tempsActualReproduccio) {
		this.tempsActualReproduccio = tempsActualReproduccio;
	}

	public void play() {

		if (t==null || !t.isAlive()) {
			r = new VideoPlay(this);
			t = new Thread(r);
			t.start();
			this.setStatusVideo(StatusVideo.REPRODUINT_SE);
		}
		
	}

	public void stop() {
		if (t.isAlive()) {
			t.interrupt();
			this.setStatusVideo(StatusVideo.PARAT);
		}
	}

	public void pause() {
		if (t.isAlive()) {
			try {
				t.wait();
				this.setStatusVideo(StatusVideo.PAUSAT);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				t.join();
				this.setStatusVideo(StatusVideo.REPRODUINT_SE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Video [url=" + url + ", titol=" + titol + ", tags=" + tags + ", dataPujada=" + dataPujada
				+ ", estatVideo=" + this.getEstatVideo() + ", statusVideo=" + statusVideo + ", duradaVideo="
				+ duradaVideo + ", tempsActualReproduccio=" + tempsActualReproduccio + "]";
	}

	private Runnable r;
	private Thread t;
	
}
