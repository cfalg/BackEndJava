package com.dominivideos.model.domain;

import javax.swing.JOptionPane;

public class VideoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VideoException(String arg0) {
		super(" *** "+arg0);
		JOptionPane.showMessageDialog(null, " *** "+arg0);
	}

}
