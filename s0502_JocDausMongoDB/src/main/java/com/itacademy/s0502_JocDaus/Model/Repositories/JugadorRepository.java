package com.itacademy.s0502_JocDaus.Model.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.s0502_JocDaus.Model.Entities.Jugador;

@Repository
//public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
public interface JugadorRepository extends MongoRepository<Jugador, String> {

		
		
		
	public List<Jugador> findByOrderByRatiVictoriesDesc();
	
	public List<Jugador> findByOrderByRatiVictoriesAsc();

		

}
