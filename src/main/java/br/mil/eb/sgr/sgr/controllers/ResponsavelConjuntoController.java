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

import br.mil.eb.sgr.sgr.dto.ResponsavelConjuntoDTO;
import br.mil.eb.sgr.sgr.services.ResponsavelConjuntoService;

@RestController
@RequestMapping(value = "/responsavelConjunto")
public class ResponsavelConjuntoController {

	@Autowired
	private ResponsavelConjuntoService responsavelConjuntoService;
	
	@GetMapping
	public ResponseEntity<List<ResponsavelConjuntoDTO>> getAll() {
		return ResponseEntity.ok().body(responsavelConjuntoService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<ResponsavelConjuntoDTO> register(@RequestBody ResponsavelConjuntoDTO dto) {
		ResponsavelConjuntoDTO newDto = responsavelConjuntoService.register(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ResponsavelConjuntoDTO> update(@PathVariable Long id, @RequestBody ResponsavelConjuntoDTO dto) {
		return ResponseEntity.ok().body(responsavelConjuntoService.update(id, dto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		responsavelConjuntoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}