package com.itacademy.s0502_JocDaus.Model.Repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itacademy.s0502_JocDaus.Model.Entities.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

		public List<Jugador> findByNomJugadorContaining(String nomJugador);
		
		public List<Jugador> findByOrderByNumPartidesGuanyadesAsc();

		@Query(value = "SELECT u FROM JUGADORS u ",nativeQuery = true)
		public List<Jugador> getAllJugadors(); 
		
		
		@Query(value = "SELECT AVG(u.rati_victories) FROM JUGADORS u ", nativeQuery = true)
		public double getAverageRati();
		
		
		public List<Jugador> findByOrderByRatiVictoriesDesc();
		
		public List<Jugador> findByOrderByRatiVictoriesAsc();
		
		
		

		

}
