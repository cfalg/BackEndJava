package com.dominivideos.model.domain;

public class VideoPlay implements Runnable {
	
	private Video video;
	static int t=0;
	
	public VideoPlay(Video v) {
		video = v;
	}
	
	public void run() {
		
		do {
			try {
				
				Thread.sleep(1000);
				t++;
				video.setTempsActualReproduccio(t);
				
				System.out.println(" -- Temps reproducció actual en segons "+ video.getTempsActualReproduccio());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(video.toString());
		} while (video.getDuradaVideo()>= video.getTempsActualReproduccio() || video.getStatusVideo().equals(StatusVideo.PARAT));
	}

}
