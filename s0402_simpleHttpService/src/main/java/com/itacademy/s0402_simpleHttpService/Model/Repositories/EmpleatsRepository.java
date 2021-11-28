package com.itacademy.s0402_simpleHttpService.Model.Repositories;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.itacademy.s0402_simpleHttpService.Model.Entities.Empleat;
import com.itacademy.s0402_simpleHttpService.Model.Entities.EnumFeines;

@Repository
public class EmpleatsRepository {
	
	private static ArrayList<Empleat> empleats = new ArrayList<>();

	public EmpleatsRepository() {
		//inicialitzem el repository per tenir dades
		this.addEmpleat(new Empleat("Emp1", EnumFeines.ADMINISTRATIU));
		this.addEmpleat(new Empleat("Emp2", EnumFeines.COMERCIAL));
		this.addEmpleat(new Empleat("Emp3", EnumFeines.DIRECTIU));
		this.addEmpleat(new Empleat("Emp4", EnumFeines.DISSENYADOR));
		this.addEmpleat(new Empleat("Emp5", EnumFeines.OPERACIONS));
		this.addEmpleat(new Empleat("Emp5", EnumFeines.PRODUCCIO));
	}
	
	
	//retornem un ArrayList amb tots els empleats
	public ArrayList<Empleat> getAllEmpleats(){
		return empleats;
	}
	
	
	public ArrayList<Empleat> findByNombreEmpleatContaining(String name) {
		ArrayList<Empleat> empleatFound = new ArrayList<Empleat>();
		Empleat empleat;
		
		for (int i=0; i<empleats.size();i++) {
			if (empleats.get(i).getNom().contains(name)) {
				empleat = empleats.get(i);
				empleatFound.add(empleat);
			}
		}
		
		
		return empleatFound;
	}
	
	
	public void deleteById(int id) {
//		ArrayList<Empleat> empleatFound = new ArrayList<Empleat>();
//		Empleat empleat;
		
		for (int i=0; i<empleats.size();i++) {
			if (i == id) {
				empleats.remove(i-1);
				break;
			}
		}
	}


	public Empleat findById(Integer id) {
		Empleat e=null;
		
		for (int i=0; i<empleats.size(); i++) {
			if (empleats.get(i).getId() == id) {
				e= empleats.get(i);
			}
		}
		return e;
	}
	

	public void save(Empleat e) {
		Empleat empleat = this.findById(e.getId());
		
		if (empleat != null) {
			e.setSalari(empleat.getFeina());
			empleats.set(e.getId()-1, e);
		} else {
			empleat = new Empleat(e.getNom(), e.getFeina());
			this.addEmpleat(empleat);
		}
		
	}

	private static int COMPTADOR_ID = 0;
	private void addEmpleat(Empleat e)
	{
		COMPTADOR_ID++;
		e.setId(COMPTADOR_ID);
		empleats.add(e);
		
	}
	
	
	
	public static void uploadFile(MultipartFile document) throws IOException {

//		System.out.println(document.getName());
//		System.out.println(document.getOriginalFilename());
		System.err.println(document.getContentType());
		System.err.println(document.getSize());

		File file = new File("src/main/resources/templates/Fotos");
		
		String rutaArchivo = file.getAbsolutePath() + "/"	+ document.getOriginalFilename();

		//utilizando el FileOutputStream compiamos al fichero del cliente al Servidor o path que hemos puesto
		FileOutputStream output;
		try {
			output = new FileOutputStream(rutaArchivo);
			output.write(document.getBytes());
			output.close();
		} catch (IOException e) {
			throw e;
		}

	}
	
}
