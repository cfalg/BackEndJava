package com.itacademy. s0501_SpringRestAPI.Model.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itacademy.s0501_SpringRestAPI.Model.Entities.Quadre;
import com.itacademy.s0501_SpringRestAPI.Model.Entities.Shop;

public interface QuadreRepository  extends JpaRepository<Quadre, Integer>{

	public List<Quadre> getQuadresByShops(Shop fk_Shop);
}
