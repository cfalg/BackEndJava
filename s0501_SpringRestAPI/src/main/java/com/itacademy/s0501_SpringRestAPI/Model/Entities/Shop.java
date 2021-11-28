package com.itacademy.s0501_SpringRestAPI.Model.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Shops")
public class Shop {

	//Definim els camps de la Taula Shops
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ShopID")
	private Integer pk_ShopID;
	
	//@Column(name = "NomShop", length = 100, unique = true, nullable = false)
	@Column(name = "NomShop", length = 100, unique = false, nullable = false)
	private String nomShop;
	
	@Column(name = "CapacitatShop")
	private Integer capacitatShop;
	
	//@OneToMany(targetEntity = Quadre.class)
	@OneToMany(mappedBy = "fk_Shop", cascade = {CascadeType.ALL})
	private List<Quadre> quadresList;
		
	
	public Shop() {
		
	}
	
	

	public Shop(String nomShop, Integer capacitatShop) {
		super();
		this.nomShop = nomShop;
		this.capacitatShop = capacitatShop;
	}

	public Integer getPk_ShopID() {
		return pk_ShopID;
	}

	public void setPk_ShopID(Integer pk_ShopID) {
		this.pk_ShopID = pk_ShopID;
	}

	public String getNomShop() {
		return nomShop;
	}

	public void setNomShop(String nomShop) {
		this.nomShop = nomShop;
	}

	public Integer getCapacitatShop() {
		return capacitatShop;
	}

	public void setCapacitatShop(Integer capacitatShop) {
		this.capacitatShop = capacitatShop;
	}

	@Override
	public String toString() {
		return "Shop [pk_ShopID=" + pk_ShopID + ", nomShop=" + nomShop + ", capacitatShop=" + capacitatShop + "]";
	}
	
	
	
	public void setQuadresList(Quadre unQuadre) {
		if(quadresList ==null ) quadresList = new ArrayList<Quadre>();
		quadresList.add(unQuadre);
		unQuadre.setFk_Shop(this);
	}

}
