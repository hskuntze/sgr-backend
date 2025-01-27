package br.mil.eb.sgr.sgr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.sgr.sgr.entities.Conjunto;

@Repository
public interface ConjuntoRepository extends JpaRepository<Conjunto, Long>{
}