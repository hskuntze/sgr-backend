package br.mil.eb.sgr.sgr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.sgr.sgr.entities.IdentificacaoRisco;
import br.mil.eb.sgr.sgr.projections.ConjuntoSeveridadeProjection;
import br.mil.eb.sgr.sgr.projections.RiscoSeveridadeProjection;

@Repository
public interface IdentificacaoRiscoRepository extends JpaRepository<IdentificacaoRisco, Long> {
	
	@Query(value = "SELECT "
			+ "tc.nome AS conjunto, "
			+ "SUM(CASE WHEN tir.severidade = 'BAIXO' THEN 1 ELSE 0 END) AS baixo, "
			+ "SUM(CASE WHEN tir.severidade = 'MÉDIO' THEN 1 ELSE 0 END) AS medio, "
			+ "SUM(CASE WHEN tir.severidade = 'ALTO' THEN 1 ELSE 0 END) AS alto, "
			+ "SUM(CASE WHEN tir.severidade = 'EXTREMO' THEN 1 ELSE 0 END) AS extremo, "
			+ "COUNT(*) as total "
			+ "FROM tb_identificacao_risco AS tir "
			+ "LEFT JOIN tb_conjunto AS tc ON tir.id_conjunto = tc.id "
			+ "GROUP BY conjunto "
			+ "ORDER BY conjunto", nativeQuery = true)
	List<ConjuntoSeveridadeProjection> conjuntoSeveridadeData();
	
	@Query(value = "SELECT "
			+ "risco, "
			+ "SUM(CASE WHEN severidade = 'BAIXO' THEN 1 ELSE 0 END) AS baixo, "
			+ "SUM(CASE WHEN severidade = 'MÉDIO' THEN 1 ELSE 0 END) AS medio, "
			+ "SUM(CASE WHEN severidade = 'ALTO' THEN 1 ELSE 0 END) AS alto, "
			+ "SUM(CASE WHEN severidade = 'EXTREMO' THEN 1 ELSE 0 END) AS extremo, "
			+ "COUNT(*) as total "
			+ "FROM tb_identificacao_risco "
			+ "GROUP BY risco "
			+ "ORDER BY risco", nativeQuery = true)
	List<RiscoSeveridadeProjection> riscoSeveridadeData();
}