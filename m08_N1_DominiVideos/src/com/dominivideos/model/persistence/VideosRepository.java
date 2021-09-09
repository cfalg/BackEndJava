package com.dominivideos.model.persistence;

import java.util.ArrayList;
import java.util.List;

import com.dominivideos.model.domain.Video;

/**
 * Repository on guardar els usuaris
 * 
 * @author Carles Falgueras
 *
 */

public class VideosRepository {

	private static List<Video> videos = new ArrayList<Video>();

	public VideosRepository() {

	}

	public List<Video> getAllVideos() {
		return new ArrayList<Video>(videos);
	}

	public void addVideo(Video video) throws Exception {
		if (video == null)
			throw new Exception();
		videos.add(video);
	}

	public Video getVideo(int idx) {
		return videos.get(idx);
	}
}
