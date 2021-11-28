package com.itacademy.s0501_SpringRestAPI.Model.Services;

import java.util.List;

import com.itacademy.s0501_SpringRestAPI.Model.Dto.ShopDTO;
import com.itacademy.s0501_SpringRestAPI.Model.Entities.Shop;
import com.itacademy.s0501_SpringRestAPI.Model.Repositories.ShopRepository;


public interface ShopService {

	// llistar totes les botigues
	public List<ShopDTO> getAllDTO();

	// Crear una nova botiga
	Shop create(Shop shop);
	
	
	//obtenim totes les botigues sense subentitats
	List<Shop> getAll();

	List<Shop> getByFilter(String nomShopFilter, Integer capacitatShopFilter);
	
	
	void delete(Integer pk_ShopID);

	public Shop getShop(Integer shopID);

}
