package com.itacademy.s0502_JocDaus.Model.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.s0502_JocDaus.Model.Entities.Jugador;
import com.itacademy.s0502_JocDaus.Model.Entities.Partida;
import com.itacademy.s0502_JocDaus.Model.Repositories.JugadorRepository;
import com.itacademy.s0502_JocDaus.Model.Repositories.PartidaRepository;

@Service
public class PartidaServiceImpl implements PartidaService {

	@Autowired
	JugadorRepository jugadorRepository;
	
	@Autowired
	PartidaRepository partidaRepository;
	
	@Override
	public Partida create(Partida partida) {
		return partidaRepository.save(partida);
	}

	@Override
	public Partida tirarDaus(Jugador jugador) {

		//Creem el objecte partida y executem la tirada alhora	
		Partida unaPartida = new Partida(jugador);

		unaPartida.setFk_Jugador(jugador);
		
		return unaPartida;

	}

}
