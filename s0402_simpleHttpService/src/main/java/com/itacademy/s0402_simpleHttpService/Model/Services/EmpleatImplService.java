package com.itacademy.s0402_simpleHttpService.Model.Services;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itacademy.s0402_simpleHttpService.Model.Entities.Empleat;
import com.itacademy.s0402_simpleHttpService.Model.Repositories.EmpleatsRepository;

@Service
public class EmpleatImplService implements EmpleatService {

	@Autowired
	EmpleatsRepository empleatsRepository;

	@Override
	public ArrayList<Empleat> getAllEmpleats() {
		ArrayList<Empleat> result = null;

		ArrayList<Empleat> empleats = empleatsRepository.getAllEmpleats();
		if (empleats != null && empleats.size() > 0) {
			result = new ArrayList<Empleat>();
			for (Empleat emp : empleats) {
				result.add(emp);
			}
		}

		return result;
	}

	@Override
	public ArrayList<Empleat> getEmpleatByFiltre(String nom) {
		ArrayList<Empleat> result = null;

		ArrayList<Empleat> empleats = empleatsRepository.findByNombreEmpleatContaining(nom);
		if (empleats != null && empleats.size() > 0) {
			result = new ArrayList<Empleat>();
			for (Empleat e : empleats) {
				result.add(e);
			}
		}

		return result;
	}

	@Override
	public void borrarById(Integer id) {
		empleatsRepository.deleteById(id);
	}
	
	
	@Override
	public Empleat getEmpleatById(Integer id) {
		Empleat e = empleatsRepository.findById(id);
		
		if (e != null) {
			return e;
		} else {
			return new Empleat();
		}
		
	}

	@Override
	public Integer guardarEmpleat(Empleat empleat) {
		//Empleat e = empleat;
		
		empleatsRepository.save(empleat);
		return empleat.getId();
	}
	
	
	//@Override
	public static void uploadFile(MultipartFile document) throws IOException {
		EmpleatsRepository.uploadFile(document);
	}	
	

}
