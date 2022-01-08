package com.itacademy.s0502_JocDaus.Model.Services;

import java.util.List;

import com.itacademy.s0502_JocDaus.Model.Entities.Jugador;
import com.itacademy.s0502_JocDaus.Model.Entities.Partida;

public interface JugadorService {

	// Crear un nou Jugador
	Jugador create(Jugador jugador);

	// Actualitza el jugador
	Jugador update(Jugador jugador);
	


	// Elimina partides de un Jugador
	String deletePartides(Integer iD_jugador);

	// Retorna un llistat de jugadors
	List<Jugador> getAllJugadors();

	// Retorna un llistat de partidas de un jugador
	List<Partida> getAllPartides(Integer iD_jugador);

	// retorna el ranking mig de tots els jugadors del sistema. És a dir, el
	// percentatge mig d’èxits.
	String getRanking();

	// retorna el jugador amb pitjor percentatge d’èxit
	Jugador getRankingLoser();

	// retorna el jugador amb pitjor percentatge d’èxit
	Jugador getRankingWinner();
	
	
	//Borra un jugador
	void deleteJugador(int id_jugador);
	
	//retorna un jugador a partir del seu id
	Jugador getJugador(int id_jugador);

	
	void updatePartida(Jugador jugador, Partida partida);
}
