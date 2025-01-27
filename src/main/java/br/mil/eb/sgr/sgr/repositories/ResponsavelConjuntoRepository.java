package br.mil.eb.sgr.sgr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.sgr.sgr.entities.ResponsavelConjunto;

@Repository
public interface ResponsavelConjuntoRepository extends JpaRepository<ResponsavelConjunto, Long> {
}