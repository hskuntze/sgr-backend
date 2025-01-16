package br.mil.eb.sgr.sgr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.sgr.sgr.entities.OM;


@Repository
public interface OMRepositorio extends JpaRepository<OM, Long> {
	
	@Query(nativeQuery = true, value = "SELECT DISTINCT bda FROM tb_om")
	List<String> buscarBDADistintos();
}
