package br.mil.eb.sgr.sgr.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.sgr.sgr.dto.OMDTO;
import br.mil.eb.sgr.sgr.entities.OM;
import br.mil.eb.sgr.sgr.repositories.OMRepositorio;
import br.mil.eb.sgr.sgr.services.exceptions.RecursoNaoEncontradoException;

@Service
public class OMServico {

	@Autowired
	private OMRepositorio omRepositorio;

	/**
	 * Busca todas as OM's
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<OMDTO> buscarTodos() {
		List<OM> oms = omRepositorio.findAll();
		oms.sort(Comparator.comparing(OM::getSigla));
		return oms.stream().map(om -> new OMDTO(om)).collect(Collectors.toList());
	}

	/**
	 * Busca por uma OM através do código dela
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public OMDTO buscarPorId(Long id) {
		OM om = omRepositorio.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Não foi possível encontrar uma OM com este ID."));
		return new OMDTO(om);
	}

	/**
	 * Retorna todos as brigadas de forma distinta
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<String> buscarBDAsDistintos() {
		List<String> bdas = omRepositorio.buscarBDADistintos();
		return bdas;
	}

	@Transactional
	public OMDTO registrar(OMDTO dto) {
		OM om = new OM();
		dtoParaEntidade(om, dto);
		om = omRepositorio.save(om);

		return new OMDTO(om);
	}

	@Transactional
	public OMDTO atualizar(Long codigo, OMDTO dto) {
		OM om = omRepositorio.findById(dto.getCodigo()).orElseThrow(() -> new RecursoNaoEncontradoException(
				"Organização Militar com ID " + codigo + " não foi encontrada."));
		
		dtoParaEntidade(om, dto);
		
		return new OMDTO(om);
	}
	
	public void deletar(Long codigo) {
		omRepositorio.deleteById(codigo);
	}

	private void dtoParaEntidade(OM om, OMDTO dto) {
		om.setBda(dto.getBda());
		om.setCep(dto.getCep());
		om.setCidadeestado(dto.getCidadeestado());
		om.setCma(dto.getCma());
		om.setCnpj(dto.getCnpj());
		om.setCodigo(dto.getCodigo());
		om.setCodom(dto.getCodom());
		om.setCodregra(dto.getCodregra());
		om.setDe(dto.getDe());
		om.setEndereco(dto.getEndereco());
		om.setForpron(dto.getForpron());
		om.setId(dto.getId());
		om.setNivel(dto.getNivel());
		om.setOmcommaterial(dto.getOmcommaterial());
		om.setRm(dto.getRm());
		om.setSigla(dto.getSigla());
		om.setTipo(dto.getTipo());
	}
}
