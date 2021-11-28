package com.itacademy.s0501_SpringRestAPI.Model.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.s0501_SpringRestAPI.Model.Dto.ShopDTO;
import com.itacademy.s0501_SpringRestAPI.Model.Entities.Shop;
import com.itacademy.s0501_SpringRestAPI.Model.Repositories.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {
	
	private ShopServiceImpl() {
	}

	@Autowired
	ShopRepository shopRepository;


	@Override
	public List<ShopDTO> getAllDTO() {
		return this.getDtoByShops(shopRepository.findAll());
	}

	
	private ArrayList<ShopDTO> getDtoByShops(List<Shop> shops){
		ArrayList<ShopDTO> resultado = null;
		
		if (shops != null ) {
			resultado = new ArrayList<ShopDTO>();
			
			for (Shop s : shops) {
				ShopDTO dto = new ShopDTO();
				
				dto.setPk_ShopID(s.getPk_ShopID());
				dto.setNomShop(s.getNomShop());
				dto.setCapacitatShop(s.getCapacitatShop());
			
				resultado.add(dto);
			}
			
		}
		return resultado;
	}


	@Override
	public List<Shop> getByFilter(String nomShopFilter, Integer capacitatShopFilter){
		return shopRepository.findByNomShopContaining(nomShopFilter);
	}
	
	


	@Override
	public Shop create(Shop shop) {
		return shopRepository.save(shop);
	}


	@Override
	public List<Shop> getAll() {
		return shopRepository.findAll();
	}


	@Override
	public void delete(Integer pk_ShopID) {
		shopRepository.deleteById(pk_ShopID);
	}


	@Override
	public Shop getShop(Integer shopID) {
		return shopRepository.getById(shopID);
	}
	
	
}
