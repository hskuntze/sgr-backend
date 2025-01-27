package br.mil.eb.sgr.sgr.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.eb.sgr.sgr.dto.ConjuntoDTO;
import br.mil.eb.sgr.sgr.entities.Conjunto;
import br.mil.eb.sgr.sgr.entities.ResponsavelConjunto;
import br.mil.eb.sgr.sgr.repositories.ConjuntoRepository;
import br.mil.eb.sgr.sgr.services.exceptions.RecursoNaoEncontradoException;

@Service
public class ConjuntoService {

	@Autowired
	private ConjuntoRepository conjuntoRepository;

	@Autowired
	private ResponsavelConjuntoService responsavelConjuntoService;

	public Conjunto getEntity(Long id) {
		return conjuntoRepository.findById(id).orElseThrow(
				() -> new RecursoNaoEncontradoException("Não foi possível encontrar um CONJUNTO com ID " + id));
	}
	
	public ConjuntoDTO getById(Long id) {
		Conjunto cj = conjuntoRepository.findById(id).orElseThrow(
				() -> new RecursoNaoEncontradoException("Não foi possível encontrar um CONJUNTO com ID " + id));
		return new ConjuntoDTO(cj);
	}

	public List<ConjuntoDTO> getAll() {
		return conjuntoRepository.findAll().stream().map(cj -> new ConjuntoDTO(cj)).collect(Collectors.toList());
	}

	public ConjuntoDTO register(ConjuntoDTO dto) {
		Conjunto cj = new Conjunto();
		ResponsavelConjunto rc = responsavelConjuntoService.getEntityById(dto.getResponsavelConjunto().getId());

		cj.setNome(dto.getNome());
		cj.setResponsavelConjunto(rc);

		cj = conjuntoRepository.save(cj);

		return new ConjuntoDTO(cj);
	}

	public ConjuntoDTO update(Long id, ConjuntoDTO dto) {
		Conjunto cj = conjuntoRepository.findById(id).orElseThrow(
				() -> new RecursoNaoEncontradoException("Não foi possível encontrar um CONJUNTO com ID " + id));
		ResponsavelConjunto rc = responsavelConjuntoService.getEntityById(dto.getResponsavelConjunto().getId());

		cj.setNome(dto.getNome());
		cj.setResponsavelConjunto(rc);

		cj = conjuntoRepository.save(cj);

		return new ConjuntoDTO(cj);
	}

	public void delete(Long id) {
		conjuntoRepository.deleteById(id);
	}
}
