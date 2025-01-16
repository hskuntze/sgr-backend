package br.mil.eb.sgr.sgr.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.mil.eb.sgr.sgr.dto.IdentificacaoRiscoDTO;
import br.mil.eb.sgr.sgr.services.IdentificacaoRiscoService;

@RestController
@RequestMapping(value = "/identificacaoriscos")
public class IdentificacaoRiscoController {
	
	@Autowired
	private IdentificacaoRiscoService identificacaoRiscoService;
	
	/**
	 * --------- GETS ---------
	 */
	
	@GetMapping
	public ResponseEntity<List<IdentificacaoRiscoDTO>> getAll() {
		return ResponseEntity.ok().body(identificacaoRiscoService.getAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<IdentificacaoRiscoDTO> getById(@PathVariable String id) {
		return ResponseEntity.ok().body(identificacaoRiscoService.getById(id));
	}
	
	/**
	 * --------- POSTS ---------
	 */
	
	@PostMapping
	public ResponseEntity<IdentificacaoRiscoDTO> register(@RequestBody IdentificacaoRiscoDTO dto) {
		IdentificacaoRiscoDTO newDto = identificacaoRiscoService.register(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newDto);
	}
	
	/**
	 * --------- PUTS ---------
	 */
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<IdentificacaoRiscoDTO> update(@PathVariable String id, @RequestBody IdentificacaoRiscoDTO dto) {
		IdentificacaoRiscoDTO updatedDto = identificacaoRiscoService.update(id, dto);
		
		return ResponseEntity.ok().body(updatedDto);
	}
	
	/**
	 * --------- DELETE ---------
	 */
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		identificacaoRiscoService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}