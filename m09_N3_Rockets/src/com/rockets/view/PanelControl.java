package com.rockets.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.rockets.controller.RocketControler;
import com.rockets.model.domain.Propeller;
import com.rockets.model.domain.Rocket;
import com.rockets.model.persistence.RocketRepository;

public class PanelControl extends JPanel {

	private Rocket rocket;
	private RocketControler rocketControler;
	int marxa = 1;

	// Creem els botons per interactuar amb el Coet
	JButton arrancar = new JButton("arrancar");
	JButton acelerar = new JButton("acelerar");
	JButton frenar = new JButton("frenar");
	JButton stop = new JButton("stop");

	public PanelControl(Rocket rocket, RocketControler rocketControler) {
		this.rocket = rocket;
		this.rocketControler = rocketControler;

		setLayout(null);
		acelerar.setEnabled(false);
		frenar.setEnabled(false);
		stop.setEnabled(false);
		setBackground(Color.WHITE);
		Font miFuente = new Font("Arial", Font.BOLD, 16);

		// Pintem el botó d'arrancar
		arrancar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				arrancar.setEnabled(false);
				acelerar.setEnabled(true);
				frenar.setEnabled(true);
				stop.setEnabled(true);
				accionBotones(e);
			}
		});
		arrancar.setBounds(100, 40, 100, 40);

		// Pintem el botó accelerar
		acelerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				arrancar.setEnabled(false);
				acelerar.setEnabled(true);
				frenar.setEnabled(true);
				accionBotones(e);
			}
		});
		acelerar.setBounds(210, 40, 100, 40);

		// Pintem el botó frenar
		frenar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				arrancar.setEnabled(false);
				acelerar.setEnabled(true);
				frenar.setEnabled(true);

				accionBotones(e);
			}
		});
		frenar.setBounds(320, 40, 100, 40);

		// Pintem el botó de parar el coet
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				arrancar.setEnabled(true);
				acelerar.setEnabled(false);
				frenar.setEnabled(false);

				accionBotones(e);
			}
		});
		stop.setBounds(430, 40, 100, 40);

		/*******************************************************************************/
		
		
		/**
		 * Afegim les marxes
		 */
		/*******************************************************************************/
		// add(listMarchas);
		add(arrancar);
		add(acelerar);
		add(frenar);
		add(stop);

		setVisible(true);

		//Configuració de les Marxes
		JLabel marxes = new JLabel("Marxes ", SwingConstants.CENTER);
		marxes.setFont(miFuente);
		marxes.setForeground(Color.BLACK);
		marxes.setBounds(20, 10, 70, 20);
		this.add(marxes);
		
		/* box de eleccion de marcha ******************************/
		String[] mach = { "X 1", "X 2", "X 3", "X 4", "X 5" };

		JList<String> listMarxes = new JList<>(mach);
		listMarxes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMarxes.setSelectedIndex(0);
		listMarxes.setFixedCellHeight(15);
		listMarxes.setFixedCellWidth(50);
		listMarxes.setVisibleRowCount(5);
		listMarxes.setBounds(30, 30, 50, 80);
		
		listMarxes.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				JList list = (JList) e.getSource();
				marxa = list.getSelectedIndex() + 1;  // sumo 1 porque el array comienza con 0
			}
		});
		add(listMarxes); 
		
	}

	/**
	 * Aqui definim que farà cada botó
	 * @param e
	 */
	protected void accionBotones(ActionEvent e) {

		
		if (e.getSource() == arrancar) {
			for (Propeller p : rocket.getPropulsores()) {
				this.rocketControler.activarRocket(this.rocketControler.getRocketIdx(this.rocket.getCodigo()));
			}
		}

		if (e.getSource() == acelerar) { // cuando el acelerar viene desde el "rocket 1

			for (Propeller p : rocket.getPropulsores()) {
				// accelerem cada un dels propulsors
				//rocket.accelerar(p.getId() - 1);
				rocket.accelerar(p.getId() - 1, marxa);
				// forcem que pinti la pontencia del Propulsor
				p.setTextLabel();
			}
			//System.out.println(rocket.getLabel());
		} else if (e.getSource() == frenar) {

			for (Propeller p : rocket.getPropulsores()) {
				//rocket.frenar(p.getId() - 1);
				rocket.frenar(p.getId() - 1, marxa);
				// forcem que pinti la pontencia del Propulsor
				p.setTextLabel();
			}
		}

		if (e.getSource() == stop) {
			for (Propeller p : rocket.getPropulsores()) {
				this.rocketControler.pararRocket(this.rocketControler.getRocketIdx(this.rocket.getCodigo()));
				// modifiquem las labels pq apareixi que la velocitat ara es 0
				p.setTextLabel();
			}
		}

	}

}
