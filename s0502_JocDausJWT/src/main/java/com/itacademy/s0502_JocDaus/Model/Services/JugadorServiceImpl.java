package com.itacademy.s0502_JocDaus.Model.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.s0502_JocDaus.Model.Entities.Jugador;
import com.itacademy.s0502_JocDaus.Model.Entities.Partida;
import com.itacademy.s0502_JocDaus.Model.Repositories.JugadorRepository;
import com.itacademy.s0502_JocDaus.Model.Repositories.PartidaRepository;

@Service
public class JugadorServiceImpl implements JugadorService {

	public JugadorServiceImpl() {
		// Auto-generated constructor stub
	}

	@Autowired
	JugadorRepository jugadorRepository;

	@Autowired
	PartidaRepository partidaRepository;

	@Override
	public Jugador create(Jugador jugador) {

		jugador.setDataRegistre(LocalDateTime.now());

		// controlem si el jugador es Anonim
		if (jugador.getNomJugador().isEmpty() || jugador.getNomJugador() == null) {
			jugador.setNomJugador("ANONIM");
			jugador.setAnonymous(true);

		} else {
			jugador.setAnonymous(false);
		}

		return jugadorRepository.save(jugador);
	}

	@Override
	public Jugador update(Jugador jugador) {
		// busquem el jugador per poder heredar la informació que teniem abans
		Optional<Jugador> j = jugadorRepository.findById(jugador.getId_jugador());

		if (j.isPresent()) {
			// j.get().setId_jugador(jugador.getId_jugador());
			j.get().setNomJugador(jugador.getNomJugador());
			// j.get().setDataRegistre(j.getDataRegistre());
			// j.get().setAnonymous(j.isAnonymous());
			return jugadorRepository.save(j.get());
		} else {
			return null;
		}

	}

	@Override
	public String deletePartides(String iD_jugador) {
		Optional<Jugador> j = jugadorRepository.findById(iD_jugador);
//		if (j != null) {
//			return partidaRepository.deletePartidaByFkJugador(j);
//		} else {
//			return 0;
//		}
		partidaRepository.deletePartidesByJugador(j);

		return "Partides borrades";
	}	
	
	@Override
	public List<Jugador> getAllJugadors() {
		return jugadorRepository.findAll();
	}

	@Override
	public List<Partida> getAllPartides(String iD_jugador) {

		// return partidaRepository.findByFkJugador(iD_jugador);
		Optional<Jugador> j = jugadorRepository.findById(iD_jugador);
		return partidaRepository.findByJugador(j);
	}

	@Override
	public String getRanking() {
		// retorna el ranking mig de tots els jugadors del sistema. És a dir, el
		// percentatge mig d’èxits.
		// TODO Auto-generated method stub
		List<Jugador> llistaJugadors= jugadorRepository.findAll();
		double averageRati = llistaJugadors.stream().mapToDouble(Jugador::getRatiVictories).average().orElse(0.0);
		System.out.println("El ranking mig de tots els jugadors del sistema es " + averageRati);

		return "El ranking mig de tots els jugadors del sistema es " + averageRati;

	}
	
	@Override
	public Jugador getRankingLoser() {
		// retorna el jugador amb pitjor percentatge d’èxit

		List<Jugador> jl = jugadorRepository.findByOrderByRatiVictoriesAsc();
		if (jl != null) {
			// agafem el primer registre de la select
			return jl.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Jugador getRankingWinner() {

		List<Jugador> jl = jugadorRepository.findByOrderByRatiVictoriesDesc();
		if (jl != null) {
			// agafem el primer registre de la select
			return jl.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public void deleteJugador(String id_jugador) {

		jugadorRepository.deleteById(id_jugador);
	}

	@Override
	public Jugador getJugador(String id_jugador) {

		// busquem el jugador per poder heredar la informació que teniem abans
		Optional<Jugador> j = jugadorRepository.findById(id_jugador);
		return j.get();
	}

	@Override
	public void updatePartida(Jugador jugador, Partida partida) {

		if (partida.isPartidaGuanyada() == true) {
			jugador.setNumPartidesGuanyades(jugador.getNumPartidesGuanyades() + 1);
		} else {
			jugador.setNumPartidesPerdudes(jugador.getNumPartidesPerdudes() + 1);
		}

		jugador.setRatiVictories(jugador.getNumPartidesGuanyades(), jugador.getNumPartidesPerdudes());

		jugadorRepository.save(jugador);
	}


}
