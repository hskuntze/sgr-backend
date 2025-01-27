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

import br.mil.eb.sgr.sgr.dto.ConjuntoDTO;
import br.mil.eb.sgr.sgr.services.ConjuntoService;

@RestController
@RequestMapping(value = "/conjuntos")
public class ConjuntoController {

	@Autowired
	private ConjuntoService conjuntoService;
	
	@GetMapping
	public ResponseEntity<List<ConjuntoDTO>> getAll() {
		return ResponseEntity.ok().body(conjuntoService.getAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ConjuntoDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok().body(conjuntoService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<ConjuntoDTO> register(@RequestBody ConjuntoDTO dto) {
		ConjuntoDTO newDto = conjuntoService.register(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ConjuntoDTO> update(@PathVariable Long id, @RequestBody ConjuntoDTO dto) {
		return ResponseEntity.ok().body(conjuntoService.update(id, dto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		conjuntoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
