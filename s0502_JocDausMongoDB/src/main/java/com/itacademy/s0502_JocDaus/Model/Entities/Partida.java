package com.itacademy.s0502_JocDaus.Model.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
//@Table(name = "Partides")
@Document(collection = "Partida")
public class Partida {

//	@Id
//	@Column(name = "id")
//	@GeneratedValue
//	private String id;
//
//	//@ManyToOne(cascade = { CascadeType.ALL })
//	@ManyToOne
//	@JoinColumn(name = "Jugador")
//	private Jugador jugador;
//
//	@Column(name = "ResultatTirada")
//	private int resultatTirada;
//
//	@Column(name = "PartidaGuanyada", nullable = false)
//	private boolean partidaGuanyada;
//
//	@Column(name = "Dau1")
//	private int dau1;
//	@Column(name = "Dau2")
//	private int dau2;


	
	@Id
	private String id;

	@DBRef
	private Jugador jugador;

	private int resultatTirada;
	private boolean partidaGuanyada;
	private int dau1;
	private int dau2;	
	
	
	public Partida() {
		super();
	}

	public Partida(Jugador jugador) {
		// fk_Jugador = jugador;
		// tira dau 1;
		dau1 = (int) (Math.random() * 6) + 1;
		// tira dau 2;
		dau2 = (int) (Math.random() * 6) + 1;

		// si suma de dau1+dau2=7 llavors tirada guanyada
		// sino tirada perduda

		resultatTirada = dau1 + dau2;
		if (resultatTirada == 7) {
			partidaGuanyada = true;
		} else {
			partidaGuanyada = false;
		}

	}

	public String getId_partida() {
		return id;
	}

	public void setId_partida(String id_partida) {
		this.id = id_partida;
	}

	public Jugador getFk_Jugador() {
		return jugador;
	}

	public void setFk_Jugador(Jugador fk_Jugador) {
		this.jugador = fk_Jugador;
	}

	public int getResultatTirada() {
		return resultatTirada;
	}

	public void setResultatTirada(int resultatTirada) {
		this.resultatTirada = resultatTirada;
	}

	public boolean isPartidaGuanyada() {
		return partidaGuanyada;
	}

	public void setPartidaGuanyada(boolean partidaGuanyada) {
		this.partidaGuanyada = partidaGuanyada;
	}

	public int getDau1() {
		return dau1;
	}

	public void setDau1(int dau1) {
		this.dau1 = dau1;
	}

	public int getDau2() {
		return dau2;
	}

	public void setDau2(int dau2) {
		this.dau2 = dau2;
	}

	@Override
	public String toString() {
		return "Partida [id="
				+ id  + ", fk_Jugador=" + jugador + ", resultatTirada="
				+ resultatTirada + ", partidaGuanyada=" + partidaGuanyada + ", dau1=" + dau1 + ", dau2=" + dau2 + "]";
	}


}
