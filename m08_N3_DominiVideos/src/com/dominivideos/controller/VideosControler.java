package com.dominivideos.controller;

import java.util.ArrayList;

import com.dominivideos.model.domain.Usuari;
import com.dominivideos.model.domain.Video;
import com.dominivideos.model.persistence.UsuarisRepository;
import com.dominivideos.model.persistence.VideosRepository;
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

		Usuari user;
		try {
			// obtenir el id usuari
			int id = videosView.getUsuariVideoId();
			UsuarisRepository ur = new UsuarisRepository();

			// obtenir objecte usuari desde un metode dela Classe repository
			user = ur.getUsuari(id);

			String url = videosView.getVideoURL();
			String titol = videosView.getVideoTitol();
			ArrayList<String> tags = videosView.addTags();
			long duradaVideo = videosView.getDuradaVideo();

			Video video = new Video(url, titol, tags, duradaVideo);
			user.addVideo(video);

			this.playVideoUser(video);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void playVideoUser(Video v) {
		boolean continuar = true;
		int seleccio = videosView.playVideo();

		while (continuar) {

			switch (seleccio) {
			case 0: // Play
			{
				v.play();
				break;
			}
			case 1: // Pause
			{
				v.pause();

				break;
			}
			case 2: // Stop
			{
				v.stop();
				continuar = false;
				break;

			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + seleccio);
			}

		}

	}

}
