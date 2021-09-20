package com.dominivideos.model.domain;

public class VideoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VideoException(String arg0) {
		super(" *** "+arg0);
	}

}
