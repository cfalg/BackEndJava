package com.itacademy.s0502_JocDaus.Model.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itacademy.s0502_JocDaus.Model.Entities.Jugador;
import com.itacademy.s0502_JocDaus.Model.Entities.Partida;

@Repository
@Transactional
public interface PartidaRepository extends JpaRepository<Partida, Integer> {

	public List<Partida> findById(int id_partida);

//	public void deleteByJugador(Optional<Jugador> j);
//	public long deleteByJugador(Integer fk_jugador);
	
	
	public void deletePartidesByJugador(Optional<Jugador> j);
//	public int deletePartidesByJugador(Integer fk_jugador);
//	
//	
	
	public List<Partida> findByJugador(Optional<Jugador> j);
//	public List<Partida> findByJugador(Integer j);
	
//	@Query(value = "delete from partides p where p.jugador = :jugador ", nativeQuery = true)
//	public void deletePartidesByJugador(@Param("jugador") Integer fk_jugador);

}

