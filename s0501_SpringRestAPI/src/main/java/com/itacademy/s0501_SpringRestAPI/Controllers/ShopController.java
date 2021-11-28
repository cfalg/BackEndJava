package com.itacademy.s0501_SpringRestAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.s0501_SpringRestAPI.Model.Dto.ShopDTO;
import com.itacademy.s0501_SpringRestAPI.Model.Entities.Quadre;
import com.itacademy.s0501_SpringRestAPI.Model.Entities.Shop;
import com.itacademy.s0501_SpringRestAPI.Model.Repositories.ShopRepository;
import com.itacademy.s0501_SpringRestAPI.Model.Services.QuadreService;
import com.itacademy.s0501_SpringRestAPI.Model.Services.ShopService;

//Aqui le indicamos que es aquest el controler
@Controller
public class ShopController {

	
	@Autowired
	private ShopService shopService;
	@Autowired
	private QuadreService quadreService;
	

	// Responderá a una petición POST
	// Crear botiga: li direm el nom i la capacitat (POST /shops/).
	@PostMapping("/shops")
	public ResponseEntity<?> add(@RequestBody Shop shop) {
		System.out.println("********** Post - Create new Shop");

		ResponseEntity<?> result = null;
		try {
			shop = shopService.create(shop);
			result = ResponseEntity.status(HttpStatus.OK).body(shop);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		return result;
	}
	


	// Responderá a una petición GET
	// Llistar botigues: retorna la llista de botigues amb el seu nom i la capacitat
	// (GET /shops/).
	@GetMapping("/shops")
	public ResponseEntity<?> getAllShops() {
		System.out.println("********** getAllShops");
		
		ResponseEntity<?> result = null;
		try {
			result = ResponseEntity.status(HttpStatus.OK).body(shopService.getAll());
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		return result;

	}	
	
	

	// Afegir quadre: li donarem el nom del quadre i el del autor (POST
	// /shops/{ID}/pictures)
	@PostMapping("/shops/{ID}/pictures")
	public ResponseEntity<?> add(@RequestBody Quadre quadre, @PathVariable("ID") Integer shopID) {
		System.out.println("********** Post - Create new Quadre");

		ResponseEntity<?> result = null;
		
		try {
			Shop shop = shopService.getShop(shopID);
			
			quadre.setFk_Shop(shop);
			quadre = quadreService.create(quadre);
			result = ResponseEntity.status(HttpStatus.OK).body(quadre);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		return result;
		
	}

	
	
	// Llistar els quadres de la botiga (GET /shops/{ID}/pictures).
	@GetMapping("/shops/{ID}/pictures")
	public ResponseEntity<?> getAllQuadres() {
		System.out.println("********** getAllQuadres");

		
		ResponseEntity<?> result = null;
		try {
			result = ResponseEntity.status(HttpStatus.OK).body(quadreService.getAll());
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		return result;

	}

	// Incendiar quadres: per si ve la policia, es poden eliminar tots els quadres
	// de la botiga sense deixar rastre (DELETE /shops/{ID}/pictures).
	@DeleteMapping("/shops/{ID}/pictures")
	public  ResponseEntity<?> delete(@PathVariable(name = "ID") Integer shopID) {
		System.out.println("********** eliminarQuadres");

		ResponseEntity<?> result = null;
		try {
			shopService.delete(shopID);
			result = ResponseEntity.status(HttpStatus.OK).body("Shop borrada");
			
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;


	}

}
