package br.mil.eb.sgr.sgr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.sgr.sgr.entities.Posto;

@Repository
public interface PostoRepositorio extends JpaRepository<Posto, Long> {
}
