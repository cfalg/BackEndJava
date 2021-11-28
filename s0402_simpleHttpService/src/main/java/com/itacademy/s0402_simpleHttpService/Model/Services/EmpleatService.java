package com.itacademy.s0402_simpleHttpService.Model.Services;

import java.util.ArrayList;

import com.itacademy.s0402_simpleHttpService.Model.Entities.Empleat;

public interface EmpleatService {

	//Servei per obtenir tots els empelats
	ArrayList<Empleat> getAllEmpleats();
	
	//Servei per buscar un Empelat
	ArrayList<Empleat> getEmpleatByFiltre(String nom);
	
	
	//Servei per borrar un Empleat per ID
	void borrarById(Integer id);

	Integer guardarEmpleat(Empleat empleat);

	//Buscar un empleat per ID
	Empleat getEmpleatById(Integer id);
	
	
	//Pujar foto Empleat
	//static void uploadFile(MultipartFile document) throws IOException;
	
}
