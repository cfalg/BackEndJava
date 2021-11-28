package com.itacademy.s0501_SpringRestAPI.Model.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.s0501_SpringRestAPI.Model.Entities.Quadre;
import com.itacademy.s0501_SpringRestAPI.Model.Repositories.QuadreRepository;

@Service
public class QuadreServiceImpl implements QuadreService {

	public QuadreServiceImpl() {
	}

	@Autowired
	QuadreRepository quadreRepository;
	
	@Override
	public Quadre create(Quadre quadre) {
		return quadreRepository.save(quadre);
	}

	@Override
	public List<Quadre> getAll() {
		return quadreRepository.findAll();
	}

}
