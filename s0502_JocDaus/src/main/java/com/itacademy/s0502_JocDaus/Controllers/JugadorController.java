package com.itacademy.s0502_JocDaus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itacademy.s0502_JocDaus.Model.Entities.Jugador;
import com.itacademy.s0502_JocDaus.Model.Entities.Partida;
import com.itacademy.s0502_JocDaus.Model.Services.JugadorService;
import com.itacademy.s0502_JocDaus.Model.Services.PartidaService;

//Aqui le indicamos que es aquest el controler
@Controller
public class JugadorController {

	@Autowired
	private JugadorService jugadorService;
	@Autowired
	private PartidaService partidaService;

	// URL’s:

	// POST: /players : crea un jugador
	@PostMapping("/players")
	public ResponseEntity<?> add(@RequestBody Jugador jugador) {
		System.out.println("********** Post - Create new jugador");

		ResponseEntity<?> result = null;
		try {
			jugador = jugadorService.create(jugador);
			result = ResponseEntity.status(HttpStatus.OK).body(jugador);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		return result;

	}

	// PUT /players : modifica el nom del jugador
	@PutMapping("/players")
	public ResponseEntity<?> updateJugador(@RequestBody Jugador jugador) {
		System.out.println("********** Post - Update Jugador");

		ResponseEntity<?> result = null;
		try {
			jugador = jugadorService.update(jugador);
			result = ResponseEntity.status(HttpStatus.OK).body(jugador);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		return result;
	}




	// GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu
	// percentatge mig d’èxits
	// getAllJugadors - Falta percentatge mig d'èxits
	@GetMapping("/players/")
	public ResponseEntity<?> getAllJugadors() {
		System.out.println(
				"****** retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits");

		ResponseEntity<?> result = null;
		try {
			result = ResponseEntity.status(HttpStatus.OK).body(jugadorService.getAllJugadors());
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;

	}



	// GET /players/ranking: retorna el ranking mig de tots els jugadors del
	// sistema. És a dir, el percentatge mig d’èxits.
	// getRanking
	@GetMapping("/players/ranking")
	public ResponseEntity<?> getRanking() {
		System.out.println(
				"****** retorna el ranking mig de tots els jugadors del sistema. És a dir, el percentatge mig d’èxits.");

		ResponseEntity<?> result = null;
		try {
			result = ResponseEntity.status(HttpStatus.OK).body(jugadorService.getRanking());
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	// GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit
	// getRankingLoser 
	@GetMapping("/players/ranking/loser")
	public ResponseEntity<?> getRankingLoser() {
		System.out.println("****** retorna el jugador amb pitjor percentatge d’èxit");

		ResponseEntity<?> result = null;
		try {
			result = ResponseEntity.status(HttpStatus.OK).body(jugadorService.getRankingLoser());
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	
	// GET /players/ranking/winner: retorna el jugador amb pitjor percentatge d’èxit
	// getRankingWinner
	@GetMapping("/players/ranking/winner")
	public ResponseEntity<?> getRankingWinner() {
		System.out.println("****** retorna el jugador amb millor percentatge d’èxit");

		ResponseEntity<?> result = null;
		try {
			result = ResponseEntity.status(HttpStatus.OK).body(jugadorService.getRankingWinner());
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

}
