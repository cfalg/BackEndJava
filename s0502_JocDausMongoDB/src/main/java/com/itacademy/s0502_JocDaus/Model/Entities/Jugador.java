package com.itacademy.s0502_JocDaus.Model.Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
//@Table(name = "Jugadors")
@Document(collection = "Jugador")
public class Jugador {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private String id;
//
//	@Column(name = "NomJugador", length = 100, unique = false, nullable = false)
//	private String nomJugador;
//
//	@Column(name = "dataRegistre")
//	private LocalDateTime dataRegistre;
//
//	@Column(name = "anonymous")
//	private boolean anonymous;
//
//	//el nom de mappedby "jugador" ha de ser el atribut de l'altre clase
//	@OneToMany(mappedBy = "jugador", cascade = { CascadeType.ALL })
//	private List<Partida> partidesList;
//	
//	
//	@Column(name = "numPartidesGuanyades")
//	private int numPartidesGuanyades;
//	
//	@Column(name = "numPartidesPerdudes")
//	private int numPartidesPerdudes;
//	
//	@Column(name = "ratiVictories")
//	private double ratiVictories;
	
	@Id
	private String id;


	private String nomJugador;
	private LocalDateTime dataRegistre;
	private boolean anonymous;

	private List<Partida> partidesList;
	
	private int numPartidesGuanyades;
	private int numPartidesPerdudes;
	private double ratiVictories;
	

	public Jugador() {
	}

	public Jugador(String nomJugador, LocalDateTime dataRegistre, boolean anonymous) {
		super();
		this.nomJugador = nomJugador;
		this.dataRegistre = dataRegistre;
		this.anonymous = anonymous;
		this.numPartidesGuanyades = 0;
		this.numPartidesPerdudes = 0;
		this.ratiVictories=0;
		
	}

	public String getId_jugador() {
		return id;
	}

	public void setId_jugador(String id_jugador) {
		this.id = id_jugador;
	}

	public String getNomJugador() {
		return nomJugador;
	}

	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}

	public LocalDateTime getDataRegistre() {
		return dataRegistre;
	}

	public void setDataRegistre(LocalDateTime dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nomJugador=" + nomJugador + ", dataRegistre=" + dataRegistre
				+ ", anonymous=" + anonymous + ", numPartidesGuanyades=" + numPartidesGuanyades
				+ ", numPartidesPerdudes=" + numPartidesPerdudes + ", ratiVictories=" + ratiVictories + "]";
	}

	public void setTirada(Jugador jugador) {
		Partida p = new Partida(jugador);
		System.out.println(p.toString());

		if (partidesList == null)
			partidesList = new ArrayList<Partida>();
		partidesList.add(p);
		p.setFk_Jugador(jugador);
	}

//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Partida")
//	public List<Partida> getPartidesList() {
//		return partidesList;
//	}
//
//	public void setPartidesList(List<Partida> partidesList) {
//		this.partidesList = partidesList;
//	}

//	//returnem la última partida realitzada
//	public Partida getUltimaPartidaRealitzada() {
//		
//		if (partidesList.size()!=0) {
//			return partidesList.get(partidesList.size()-1);
//		} else {
//		return null;
//		}
//	}

	

	
	public int getNumPartidesGuanyades() {
		return numPartidesGuanyades;
	}

	public void setNumPartidesGuanyades(int numPartidesGuanyades) {
		this.numPartidesGuanyades = numPartidesGuanyades;
	}

	public int getNumPartidesPerdudes() {
		return numPartidesPerdudes;
	}

	public void setNumPartidesPerdudes(int numPartidesPerdudes) {
		this.numPartidesPerdudes = numPartidesPerdudes;
	}

	public double getRatiVictories() {
		return ratiVictories;
	}

	public void setRatiVictories(int ratiVictories) {
		this.ratiVictories = ratiVictories;
	}	
	
	public void setRatiVictories(int numPartidesGuanyades, int numPartidesPerdudes) {
		this.ratiVictories =  ((double)numPartidesGuanyades / (double)(numPartidesGuanyades+numPartidesPerdudes)) * 100 ;
		System.out.println("RATI VICTORIOES " + this.ratiVictories + " " + numPartidesGuanyades + " "+numPartidesPerdudes);
	}
	
	
}
