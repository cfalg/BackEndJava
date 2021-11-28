package com.itacademy.s0402_simpleHttpService.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.s0402_simpleHttpService.Model.Entities.Empleat;
import com.itacademy.s0402_simpleHttpService.Model.Services.EmpleatImplService;
import com.itacademy.s0402_simpleHttpService.Model.Services.EmpleatService;
import com.itacademy.s0402_simpleHttpService.Model.filtros.EmpleatFiltre;

//Aqui le indicamos que es aquest el controler
@Controller
public class EmpleatController {

	private static final String ID_FORM_EMPLEATS = "EmpleatsForm";
	private static final String ID_LISTA_EMPLEATS = "EmpleatsLlista";
	private static final String ID_FILTRE_EMPLEAT = "EmpleatFiltre";

	@Autowired
	private EmpleatService empleatService;

	// Responderá a una petición GET
	@GetMapping("/LlistaEmpleats")
	public ModelAndView listaEmpleats() {
		System.out.println("********** LlistaEmpleats");

		ModelAndView modelAndView = new ModelAndView();
		ArrayList<Empleat> empleats = empleatService.getAllEmpleats();
		modelAndView.addObject(ID_LISTA_EMPLEATS, empleats);
		modelAndView.addObject(ID_FILTRE_EMPLEAT, new EmpleatFiltre());
		// nom de la pàgina HTML que volem obrir
		modelAndView.setViewName("LlistaEmpleats");

		return modelAndView;
	}

	// Responderá a una petición POST
	@PostMapping("/FiltrarEmpleats")
	public ModelAndView filtrarEmpleat(@ModelAttribute(ID_FILTRE_EMPLEAT) EmpleatFiltre empleatFiltre) {
		System.out.println("********** FiltrarEmpleats");

		ModelAndView modelAndView = new ModelAndView();
		ArrayList<Empleat> empleats = empleatService.getEmpleatByFiltre(empleatFiltre.getNom());
		modelAndView.addObject(ID_LISTA_EMPLEATS, empleats);
		modelAndView.addObject(ID_FILTRE_EMPLEAT, new EmpleatFiltre());
		modelAndView.setViewName("LlistaEmpleats");

		return modelAndView;
	}

	// Responderá a una petición GET per esborrar a un Empleat
	@GetMapping("/BorrarEmpleat/{id}")
	public ModelAndView borrarEmpleat(@PathVariable("id") Integer id) {
		System.out.println("********** BorrarEmpleat/" + id);

		empleatService.borrarById(id);
		return new ModelAndView("redirect:/LlistaEmpleats");
	}

	// Responderá a una petición GET per crear un nou Empleat
	@GetMapping("/NouEmpleat")
	public ModelAndView paginaNouEmpleat() {
		System.out.println("********** NouEmpleat");

		ModelAndView modelAndView = new ModelAndView();
		Empleat empleat = new Empleat();
		modelAndView.addObject(ID_FORM_EMPLEATS, empleat);
		// nom de la pàgina HTML que volem obrir
		modelAndView.setViewName("EdicioEmpleat");
		return modelAndView;

	}

	// Responderá a una petición GET
	@GetMapping("/EditarEmpleat/{id}")
	public ModelAndView editarEmpleat(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		Empleat e = empleatService.getEmpleatById(id);
		modelAndView.addObject(ID_FORM_EMPLEATS, e);
		modelAndView.setViewName("EdicioEmpleat");
		return modelAndView;
	}

	// Responderá a una petición POST
	@PostMapping("/GuardarEmpleat")
	public ModelAndView guardarEmpleat(@ModelAttribute(ID_FORM_EMPLEATS) Empleat empleat) {
		System.out.println("********** GuardarEmpleat ");

//		Empleat e = new Empleat(empleat.getNom(), empleat.getFeina());
//		empleatService.guardarEmpleat(e);
		empleatService.guardarEmpleat(empleat);

		return new ModelAndView("redirect:/LlistaEmpleats");
	}

	@GetMapping(path = "/UploadFoto")
	public String showUploadForm() {
		return "UploadFile"; // nom pàgina web "UploadFile.html"
	}

	@PostMapping(path = "/obtenirFitxer", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> uploadFile(@RequestParam("documento") MultipartFile document) {

		// inicializamos resultado a null de la clase RespuestaEntidad
		ResponseEntity<?> result = null;

		try {
			EmpleatImplService.uploadFile(document);
			// si el resultado es HttpStatus.ok=200 entonces pintamos en el Body de la Web
			// "Archivo subido"
			result = ResponseEntity.status(HttpStatus.OK).body("Foto pujada.");
		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

		return result;

	}

}
