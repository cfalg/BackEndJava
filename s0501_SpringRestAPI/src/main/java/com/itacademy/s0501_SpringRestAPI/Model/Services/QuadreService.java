package com.itacademy.s0501_SpringRestAPI.Model.Services;

import java.util.List;

import com.itacademy.s0501_SpringRestAPI.Model.Entities.Quadre;

public interface QuadreService {

	//Per crear un nou Quadres
	public Quadre create(Quadre quadre);

	//Per llistar tots els Quadres
	List<Quadre> getAll();
	
}
