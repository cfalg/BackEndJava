package com.rockets.model.persistence;

import java.util.ArrayList;
import java.util.List;

import com.rockets.model.domain.Rocket;

/**
 * Repository on guardar els Rockets
 * 
 * @author Carles Falgueras
 *
 */

public class RocketRepository {

	private static List<Rocket> rockets = new ArrayList<Rocket>();
	
	
	public RocketRepository() {
		
	}
	
	public List<Rocket> getAllRockets(){
		return new ArrayList<Rocket>(rockets);
	}
	
	public void addRocket(Rocket rocket) throws Exception {
		if (rocket == null)
			throw new Exception();
		rockets.add(rocket);
	}
	
	public Rocket getRocket(int idx) throws Exception{
		try {
			return rockets.get(idx);
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
