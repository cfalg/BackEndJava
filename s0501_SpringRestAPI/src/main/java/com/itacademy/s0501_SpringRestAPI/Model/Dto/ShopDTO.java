package com.itacademy.s0501_SpringRestAPI.Model.Dto;

import java.io.Serializable;

//DTO: Data Transfer Object
public class ShopDTO implements Serializable {

	// Definim els camps de la Taula Shops
	private Integer pk_ShopID;
	private String nomShop;
	private Integer capacitatShop;
	
	//private List<Quadre> quadres;
	
	
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
		return "ShopDTO [pk_ShopID=" + pk_ShopID + ", nomShop=" + nomShop + ", capacitatShop=" + capacitatShop + "]";
	}

	
	

}
