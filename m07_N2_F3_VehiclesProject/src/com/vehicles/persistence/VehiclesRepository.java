package com.vehicles.persistence;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.project.Vehicle;


/**
 * Repository on guardar els vehicles
 * @author Carles Falgueras
 *
 */
public class VehiclesRepository {

	private static List<Vehicle> vehicles = new ArrayList<>();
	
	public VehiclesRepository() {
		
	}
	
	public List<Vehicle> getAllVehicles(){
		return new ArrayList<>(vehicles);
	}
	
	
	public void addVehicle(Vehicle vehicle) throws Exception{
		if (vehicle==null) throw new Exception();
		vehicles.add(vehicle);
	}

	public Vehicle getVehicle(int idx) {
		return vehicles.get(idx);
	}
	
}
