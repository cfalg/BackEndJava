package com.itacademy.s0501_SpringRestAPI.Model.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.s0501_SpringRestAPI.Model.Entities.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

	public List<Shop> findByNomShopContaining(String nomShop);
	
	
}
