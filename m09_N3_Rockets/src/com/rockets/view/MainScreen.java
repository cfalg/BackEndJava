package com.rockets.view;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import com.rockets.controller.RocketControler;
import com.rockets.model.domain.Rocket;

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributs
	RocketScreen rocketScreen1, rocketScreen2;
	PanelControl panelControl1, panelControl2;

	public MainScreen(Rocket rocket1, Rocket rocket2, RocketControler rocketControler) {

		this.setBounds(100, 100, 1365, 660);
		setTitle("Gestió de Coets");

		/*****
		 * instancio para cada rocket una clase screen y otra de control
		 * ********************
		 */
		rocketScreen1 = new RocketScreen(rocket1);
		rocketScreen1.setBounds(0, 0, 650, 500);
		rocketScreen1.setBackground(Color.BLUE);
		add(rocketScreen1);

		rocketScreen2 = new RocketScreen(rocket2);
		rocketScreen2.setBounds(700, 0, 650, 500);
		rocketScreen2.setBackground(Color.BLUE);
		add(rocketScreen2);

		panelControl1 = new PanelControl(rocket1, rocketControler);
		panelControl1.setBounds(0, 500, 650, 120);
		this.add(panelControl1);

		panelControl2 = new PanelControl(rocket2, rocketControler);
		panelControl2.setBounds(700, 500, 650, 120);
		this.add(panelControl2);

		/*********************************************************************************/
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);

	}

}
