package br.mil.eb.sgr.sgr.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.eb.sgr.sgr.dto.ResponsavelConjuntoDTO;
import br.mil.eb.sgr.sgr.entities.ResponsavelConjunto;
import br.mil.eb.sgr.sgr.repositories.ResponsavelConjuntoRepository;
import br.mil.eb.sgr.sgr.services.exceptions.RecursoNaoEncontradoException;

@Service
public class ResponsavelConjuntoService {

	@Autowired
	private ResponsavelConjuntoRepository responsavelConjuntoRepository;

	public ResponsavelConjunto getEntityById(Long id) {
		ResponsavelConjunto rc = responsavelConjuntoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Não foi possível encontrar um RESPONSÁVEL POR CONJUNTO com ID " + id));
		return rc;
	}

	public List<ResponsavelConjuntoDTO> getAll() {
		return responsavelConjuntoRepository.findAll().stream().map(rc -> new ResponsavelConjuntoDTO(rc))
				.collect(Collectors.toList());
	}
	
	public ResponsavelConjuntoDTO register(ResponsavelConjuntoDTO dto) {
		ResponsavelConjunto rc = new ResponsavelConjunto();
		rc.setNome(dto.getNome());
		
		rc = responsavelConjuntoRepository.save(rc);
		
		return new ResponsavelConjuntoDTO(rc);
	}
	
	public ResponsavelConjuntoDTO update(Long id, ResponsavelConjuntoDTO dto) {
		ResponsavelConjunto rc = getEntityById(id);
		rc.setNome(dto.getNome());
		
		rc = responsavelConjuntoRepository.save(rc);
		
		return new ResponsavelConjuntoDTO(rc);
	}
	
	public void delete(Long id) {
		responsavelConjuntoRepository.deleteById(id);
	}
}
