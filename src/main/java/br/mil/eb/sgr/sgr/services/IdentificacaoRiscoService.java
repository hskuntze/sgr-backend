package br.mil.eb.sgr.sgr.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.eb.sgr.sgr.dto.IdentificacaoRiscoDTO;
import br.mil.eb.sgr.sgr.dto.report.ConjuntoSeveridadeReportDTO;
import br.mil.eb.sgr.sgr.dto.report.RiscoSeveridadeReportDTO;
import br.mil.eb.sgr.sgr.entities.IdentificacaoRisco;
import br.mil.eb.sgr.sgr.repositories.IdentificacaoRiscoRepository;
import br.mil.eb.sgr.sgr.services.exceptions.RecursoExistenteException;
import br.mil.eb.sgr.sgr.services.exceptions.RecursoNaoEncontradoException;
import br.mil.eb.sgr.sgr.services.exceptions.RequisicaoNaoProcessavelException;

@Service
public class IdentificacaoRiscoService {

	@Autowired
	private IdentificacaoRiscoRepository identificacaoRiscoRepository;

	public List<IdentificacaoRiscoDTO> getAll() {
		return identificacaoRiscoRepository.findAll().stream().map(ir -> new IdentificacaoRiscoDTO(ir))
				.collect(Collectors.toList());
	}

	public IdentificacaoRiscoDTO getById(String id) {
		IdentificacaoRisco ir = identificacaoRiscoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Não foi possível encontrar uma IDENTIFICAÇÃO DE RISCO com ID " + id));
		return new IdentificacaoRiscoDTO(ir);
	}

	public IdentificacaoRiscoDTO register(IdentificacaoRiscoDTO dto) {
		String id = dto.getId();

		if (id == null) {
			throw new RequisicaoNaoProcessavelException("ID nulo. Requisição improcessável.");
		}

		Optional<IdentificacaoRisco> opt = identificacaoRiscoRepository.findById(id);

		if (opt.isEmpty()) {
			IdentificacaoRisco ir = new IdentificacaoRisco();
			ir.setId(dto.getId());

			dtoToEntity(ir, dto);
			ir = identificacaoRiscoRepository.save(ir);

			return new IdentificacaoRiscoDTO(ir);
		} else {
			throw new RecursoExistenteException("Um elemento com este ID já existe.");
		}
	}

	public IdentificacaoRiscoDTO update(String id, IdentificacaoRiscoDTO dto) {
		IdentificacaoRisco ir = identificacaoRiscoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Não foi possível encontrar uma IDENTIFICAÇÃO DE RISCO com ID " + id));
		dtoToEntity(ir, dto);
		ir = identificacaoRiscoRepository.save(ir);

		return new IdentificacaoRiscoDTO(ir);
	}

	public void delete(String id) {
		identificacaoRiscoRepository.deleteById(id);
	}

	public List<ConjuntoSeveridadeReportDTO> conjuntoSeveridadeReport() {
		return identificacaoRiscoRepository.conjuntoSeveridadeData().stream()
				.map(p -> new ConjuntoSeveridadeReportDTO(
						p.getConjunto(), 
						p.getBaixo(), 
						p.getMedio(), 
						p.getAlto(),
						p.getExtremo(), 
						p.getTotal()))
				.collect(Collectors.toList());
	}
	
	public List<RiscoSeveridadeReportDTO> riscoSeveridadeReport() {
		return identificacaoRiscoRepository.riscoSeveridadeData().stream()
				.map(p -> new RiscoSeveridadeReportDTO(
						p.getRisco(), 
						p.getBaixo(), 
						p.getMedio(), 
						p.getAlto(),
						p.getExtremo(), 
						p.getTotal()))
				.collect(Collectors.toList());
	}

	private void dtoToEntity(IdentificacaoRisco ir, IdentificacaoRiscoDTO dto) {
		ir.setProjeto(dto.getProjeto());
		ir.setContrato(dto.getContrato());
		ir.setTipoRisco(dto.getTipoRisco());
		ir.setRisco(dto.getRisco());
		ir.setConjunto(dto.getConjunto());
		ir.setEvento(dto.getEvento());
		ir.setDescricaoRisco(dto.getDescricaoRisco());
		ir.setCausa(dto.getCausa());
		ir.setDataRisco(dto.getDataRisco());
		ir.setDataLimite(dto.getDataLimite());
		ir.setAno(dto.getAno());
		ir.setCategoria(dto.getCategoria());
		ir.setProbabilidade(dto.getProbabilidade());
		ir.setImpacto(dto.getImpacto());
		ir.setCriticidade(dto.getCriticidade());
		ir.setSeveridade(dto.getSeveridade());
		ir.setConsequencia(dto.getConsequencia());
		ir.setTratamento(dto.getTratamento());
		ir.setImpactoFinanceiro(dto.getImpactoFinanceiro());
		ir.setPlanoContingencia(dto.getPlanoContingencia());
		ir.setResponsavelRisco(dto.getResponsavelRisco());
		ir.setResponsavelConjunto(dto.getResponsavelConjunto());
		ir.setStatus(dto.getStatus());
	}
}
