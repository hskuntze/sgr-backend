package br.mil.eb.sgr.sgr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.sgr.sgr.dto.PostoDTO;
import br.mil.eb.sgr.sgr.services.PostoServico;

@RestController
@RequestMapping(value = "/postos")
public class PostoControlador {

	@Autowired
	private PostoServico postoServico;
	
	/**
	 * --------- GETS ---------
	 */
	
	/**
	 * Endpoint que exibe todos os Postos/graduações cadastradas
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<PostoDTO>> buscarTodos() {
		return ResponseEntity.ok().body(postoServico.buscarTodos());
	}
}
