package com.rockets.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.rockets.model.domain.Propeller;
import com.rockets.model.domain.Rocket;

public class RocketScreen extends javax.swing.JPanel {
	Rocket rocket;
	private JLabel nameLabel;
	private JLabel speed;
	
	public RocketScreen( Rocket rocket) {
		this.rocket = rocket;
		//definim la mida del marc
		setBounds(600, 0, 500, 500);
		
		Font miFuente = new Font("Arial", Font.BOLD, 20);
		setLayout(null);				

		//Creem el text que posa el nom del rocket
		nameLabel = new JLabel( "ROCKET "+rocket.getCodigo(), SwingConstants.CENTER);
		nameLabel.setFont(miFuente);
		nameLabel.setForeground(Color.RED);
		nameLabel.setBounds(0, 0, 600, 100);				
		this.add(nameLabel);
		
		//Creem el laber que informará de la velocitat
		JLabel speedLabel = new JLabel("Velocidad: ", SwingConstants.RIGHT);
		speedLabel.setFont(miFuente);
		speedLabel.setForeground(Color.BLACK);
		speedLabel.setBounds(0, 100, 300, 50);			
		this.add(speedLabel);
		
		//informem el Text que pintará el valor de la velocitat en aquell moment
		speed = new JLabel("0 Km/h", SwingConstants.LEFT);
		speed.setFont(miFuente);
		speed.setForeground(Color.BLACK);
		speed.setBounds(300, 100, 250, 50);		
		this.add(speed);

		//Creem la label/columna del noms de propulsors
		JLabel titPropulsor= new JLabel("Propulsor " , SwingConstants.LEFT);
		titPropulsor.setFont(miFuente);
		titPropulsor.setForeground(Color.BLACK);
		titPropulsor.setBounds(10, 150 , 140, 50);
		this.add(titPropulsor);		
		
		//pintem el label/Columna de la potencia d'aquest propulsor en aquest moment
		JLabel titPotencia= new JLabel("<html>Potencia<br> actual</html>" , SwingConstants.LEFT);
		titPotencia.setFont(miFuente);
		titPotencia.setForeground(Color.BLACK);
		titPotencia.setBounds(180, 150 , 150, 50);
		this.add(titPotencia);		
		
		//pintem el label/Columna de la Potencia Màxima
		JLabel titMaxPotencia= new JLabel("<html>Potencia <br>maxima</html>" , SwingConstants.LEFT);
		titMaxPotencia.setFont(miFuente);
		titMaxPotencia.setForeground(Color.BLACK);
		titMaxPotencia.setBounds(330, 150 , 150, 50);
		this.add(titMaxPotencia);
		
		//Pintem el label/Columna 
		JLabel titObjPotencia= new JLabel("<html>Potencia <br>objectiu</html>" , SwingConstants.LEFT);
		titObjPotencia.setFont(miFuente);
		titObjPotencia.setForeground(Color.BLACK);
		titObjPotencia.setBounds(480, 150 , 150, 50);
		this.add(titObjPotencia);		
		
		
		//Pintem els propulsors
		int x=0;  // 
		for( Propeller propeller:rocket.getPropulsores()) {		//para cada propulsor de cada rocket y instancio 3 JLabel para su numero,  
																//su actual potencia y su maxima potencia
			x++;
			JLabel  nroPropulsor= new JLabel(x + " " , SwingConstants.CENTER);
			 nroPropulsor.setFont(miFuente);
			 nroPropulsor.setForeground(Color.BLACK);
			 nroPropulsor.setBounds(0, 150 + x*50, 150, 50);				
			this.add( nroPropulsor);
			
			JLabel potPropulsor= new JLabel(propeller.getPotenciaActual() + " " , SwingConstants.CENTER);
			potPropulsor.setFont(miFuente);
			potPropulsor.setForeground(Color.BLACK);
			potPropulsor.setBounds(150, 150 + x*50, 150, 50);				
			this.add( potPropulsor);
			
			JLabel maxPotencia= new JLabel(propeller.getPotenciaMax() + " " , SwingConstants.CENTER);
			maxPotencia.setFont(miFuente);
			maxPotencia.setForeground(Color.BLACK);
			maxPotencia.setBounds(300, 150 + x*50, 150, 50);				
			this.add( maxPotencia);

			
			JLabel objPotencia= new JLabel(propeller.getPotenciaObjectiu() + " " , SwingConstants.CENTER);
			objPotencia.setFont(miFuente);
			objPotencia.setForeground(Color.BLACK);
			objPotencia.setBounds(450, 150 + x*50, 150, 50);				
			this.add( objPotencia);			
			
			propeller.setLabel(potPropulsor);					
		}		
		
		
		//actualitcem el valor de la velocitat
		rocket.setLabel(speed);
		
		//fem visible el marc
		setVisible(true); 
	}

}
