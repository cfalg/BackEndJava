package com.dominivideos.model.domain;

public class VideoPlay implements Runnable {

	private Video video;
	static int t = 0;

	public VideoPlay(Video v) {
		video = v;
	}

	public void run() {

		do {

			// Sempre fem un sleep de 1 segon per poder llegir la consola
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			if (video.getStatusVideo().equals(StatusVideo.REPRODUINT_SE)) {
				t++;
				video.setTempsActualReproduccio(t);

				System.out.println(" -- Temps reproducció actual en segons " + video.getTempsActualReproduccio());

			} else if (video.getStatusVideo().equals(StatusVideo.PAUSAT)) {
				System.out.println("Viedo Pausat");
			}

			System.out.println(video.toString());
		} while ((!video.getStatusVideo().equals(StatusVideo.PARAT))
				&& (video.getDuradaVideo() > video.getTempsActualReproduccio()));
		// ||

	}

}
