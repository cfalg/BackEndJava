package com.itacademy.s0502_JocDaus.Model.Services;

import com.itacademy.s0502_JocDaus.Model.Entities.Jugador;
import com.itacademy.s0502_JocDaus.Model.Entities.Partida;

public interface PartidaService {

	//un jugador específic realitza una tirada 	dels daus
	public Partida tirarDaus(Jugador jugador);

	
	public Partida create(Partida partida);
}
