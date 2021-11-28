package com.itacademy.s0501_SpringRestAPI.Model.Entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Quadres")
public class Quadre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_QuadreID")
	private Integer pk_QuadreID;
	
	@Column(name = "NomQuadre", length = 100, unique = false, nullable = false)
	private String nomQuadre;
	
	@Column(name="NomAutorQuadre", length = 100, unique = false, nullable = true)
	private String nomAutorQuadre;
	
	@Column(name="PreuQuadre")
	private Integer preuQuadre;
	
	@Column(name="DataEntradaQuadre")
	private LocalDateTime dataEntradaQuadre;

	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="FK_ShopID")
	private Shop fk_Shop;

	

	public Integer getPreuQuadre() {
		return preuQuadre;
	}


	public void setPreuQuadre(Integer preuQuadre) {
		this.preuQuadre = preuQuadre;
	}


	
	

	public Quadre() {
		// TODO Auto-generated constructor stub
	}
	

	public Quadre(String nomQuadre) {
		super();
		this.nomQuadre = nomQuadre;
	}


	public Integer getPk_QuadreID() {
		return pk_QuadreID;
	}

	public void setPk_QuadreID(Integer pk_QuadreID) {
		this.pk_QuadreID = pk_QuadreID;
	}

	public String getNomQuadre() {
		return nomQuadre;
	}

	public void setNomQuadre(String nomQuadre) {
		this.nomQuadre = nomQuadre;
	}



	public String getNomAutorQuadre() {
		return nomAutorQuadre;
	}



	public void setNomAutorQuadre(String nomAutorQuadre) {
		this.nomAutorQuadre = nomAutorQuadre;
	}



	public LocalDateTime getDataEntradaQuadre() {
		return dataEntradaQuadre;
	}



	public void setDataEntradaQuadre(LocalDateTime dataEntradaQuadre) {
		this.dataEntradaQuadre = dataEntradaQuadre;
	}


	
	

	public Shop getFk_Shop() {
		return fk_Shop;
	}


	public void setFk_Shop(Shop fk_Shop) {
		this.fk_Shop = fk_Shop;
	}


	@Override
	public String toString() {
		return "Quadre [pk_QuadreID=" + pk_QuadreID + ", nomQuadre=" + nomQuadre + ", nomAutorQuadre=" + nomAutorQuadre
				+ ", preuQuadre=" + preuQuadre + ", dataEntradaQuadre=" + dataEntradaQuadre + ", fk_Shop=" + fk_Shop
				+ "]";
	}



	
	
}
