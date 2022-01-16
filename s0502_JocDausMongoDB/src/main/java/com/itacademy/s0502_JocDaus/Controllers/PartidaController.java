package com.itacademy.s0502_JocDaus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.s0502_JocDaus.Model.Entities.Jugador;
import com.itacademy.s0502_JocDaus.Model.Entities.Partida;
import com.itacademy.s0502_JocDaus.Model.Services.JugadorService;
import com.itacademy.s0502_JocDaus.Model.Services.PartidaService;

@RestController
public class PartidaController {

	@Autowired
	private JugadorService jugadorService;
	@Autowired
	private PartidaService partidaService;

	// POST /players/{id}/games/ : un jugador específic realitza una tirada dels
	// daus.
	// tirarDaus Pendent de fer
	@PostMapping("/players/{id}/games/")
	public ResponseEntity<?> tirarDaus(@PathVariable("id") String id_Jugador) {
		System.out.println("********** Post - Tirada de daus");

		ResponseEntity<?> result = null;
		try {
			Jugador jugador = jugadorService.getJugador(id_Jugador);

			
			Partida partida = partidaService.tirarDaus(jugador);
			partida = partidaService.create(partida);
			
			//Actualitzem del jugador les dades
			jugadorService.updatePartida(jugador, partida);
			
			result = ResponseEntity.status(HttpStatus.OK).body(partida);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	// DELETE /players/{id}/games: elimina les tirades del jugador
	// TODO delete
	@DeleteMapping("/players/{ID}/games")
	public ResponseEntity<?> delete(@PathVariable(name = "ID") String iD_jugador) {
		System.out.println("********** elimina tirades jugador");

		ResponseEntity<?> result = null;
		try {
			String s = jugadorService.deletePartides(iD_jugador);
			result = ResponseEntity.status(HttpStatus.OK).body("Pardides Jugador " + iD_jugador + " Borrades." + s);
		} catch (Exception ex) {
		result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}
	
	
	// GET /players/{id}/games: retorna el llistat de jugades per un jugador.
	// getAllPartides
	@GetMapping("/players/{ID}/games")
	public ResponseEntity<?> getAllPartides(@PathVariable(name = "ID") String iD_jugador) {
		System.out.println("****** retorna el llistat de jugades per un jugador.");

		ResponseEntity<?> result = null;
		try {
			result = ResponseEntity.status(HttpStatus.OK).body(jugadorService.getAllPartides(iD_jugador));
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}
	
}
