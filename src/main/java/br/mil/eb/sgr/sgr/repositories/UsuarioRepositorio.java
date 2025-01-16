package br.mil.eb.sgr.sgr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.sgr.sgr.entities.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
	Usuario findByIdentidade(String identidade);
}