package com.dominivideos.application;

import java.util.ArrayList;

import com.dominivideos.persistence.VideosRepository;
import com.dominivideos.project.Video;
import com.dominivideos.view.VideosView;

/**
 * Clase VideosControler: Clase controladora pels Videos
 * 
 * @author Carles Falgueras
 * @version M8.N1.20210901
 * 
 */

public class VideosControler {

	private VideosRepository repository;

	private VideosView videosView = new VideosView();

	public VideosControler() {
		repository = new VideosRepository();
	}

	/**
	 * Llistem tots el Videos
	 */
	public String getAllVideos() {
		String allVideos = "\n";

		for (Video e : repository.getAllVideos()) {
			allVideos += e.toString() + " \n";
		}
		return allVideos;
	}

	/**
	 * mètode per afegir un Video
	 */
	public void createVideo(String url, String titol, ArrayList<String> tags) throws Exception {
		Video video = new Video(url, titol, tags);
		repository.addVideo(video);
	}

	/**
	 * Mètode per afegir un Video de forma automática (per les proves)
	 */
	public void createVideoAuto() {
		String url = "http://wwww.video.cat/1";
		String titol = "Video1";

		System.out.println("AUTO les dades de un Video: \n");
		try {
			createVideo(url, titol, null);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	/**
	 * Mètode per afegir un Video per part del Usuari
	 */
	public void createVideoUser() {
		String url = videosView.getVideoURL();
		String titol = videosView.getVideoTitol();
		ArrayList<String> tags = videosView.addTags();

		try {
			createVideo(url, titol, tags);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

}
