package com.dominivideos.project; //o Model

import java.util.ArrayList;

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

	public Video(String url, String titol) {
		super();
		this.url = url;
		this.titol = titol;
		this.tags = null;
	}
	
	

	public Video(String url, String titol, ArrayList<String> tags) {
		super();
		this.url = url;
		this.titol = titol;
		this.tags = tags;
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

	@Override
	public String toString() {
		return "Video [url=" + url + ", titol=" + titol + ", tags=" + tags + "]";
	}

}
