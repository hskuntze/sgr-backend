package br.mil.eb.sgr.sgr.dto;

import java.util.Date;

import br.mil.eb.sgr.sgr.entities.IdentificacaoRisco;

public class IdentificacaoRiscoDTO {
	private String id;
	private String projeto;
	private String contrato;
	private String tipoRisco;
	private String risco;
	private String conjunto;
	private String evento;
	private String descricaoRisco;
	private String causa;
	private String consequencia;
	private String tratamento;
	private String planoContingencia;
	private String categoria;
	private String probabilidade;
	private String impacto;
	private Integer criticidade;
	private String severidade;
	private String impactoFinanceiro;
	private String responsavelRisco;
	private String responsavelConjunto;
	private String status;
	private Date dataLimite;
	private Date dataRisco;
	private Integer ano;
	
	public IdentificacaoRiscoDTO() {
	}
	
	public IdentificacaoRiscoDTO(IdentificacaoRisco e) {
		this.id = e.getId();
		this.projeto = e.getProjeto();
		this.contrato = e.getContrato();
		this.tipoRisco = e.getTipoRisco();
		this.risco = e.getRisco();
		this.conjunto = e.getConjunto();
		this.evento = e.getEvento();
		this.descricaoRisco = e.getDescricaoRisco();
		this.causa = e.getCausa();
		this.consequencia = e.getConsequencia();
		this.tratamento = e.getTratamento();
		this.planoContingencia = e.getPlanoContingencia();
		this.categoria = e.getCategoria();
		this.probabilidade = e.getProbabilidade();
		this.impacto = e.getImpacto();
		this.criticidade = e.getCriticidade();
		this.severidade = e.getSeveridade();
		this.impactoFinanceiro = e.getImpactoFinanceiro();
		this.responsavelRisco = e.getResponsavelRisco();
		this.responsavelConjunto = e.getResponsavelConjunto();
		this.status = e.getStatus();
		this.dataLimite = e.getDataLimite();
		this.dataRisco = e.getDataRisco();
		this.ano = e.getAno();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getTipoRisco() {
		return tipoRisco;
	}

	public void setTipoRisco(String tipoRisco) {
		this.tipoRisco = tipoRisco;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

	public String getConjunto() {
		return conjunto;
	}

	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getDescricaoRisco() {
		return descricaoRisco;
	}

	public void setDescricaoRisco(String descricaoRisco) {
		this.descricaoRisco = descricaoRisco;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getConsequencia() {
		return consequencia;
	}

	public void setConsequencia(String consequencia) {
		this.consequencia = consequencia;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public String getPlanoContingencia() {
		return planoContingencia;
	}

	public void setPlanoContingencia(String planoContingencia) {
		this.planoContingencia = planoContingencia;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProbabilidade() {
		return probabilidade;
	}

	public void setProbabilidade(String probabilidade) {
		this.probabilidade = probabilidade;
	}

	public String getImpacto() {
		return impacto;
	}

	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}

	public Integer getCriticidade() {
		return criticidade;
	}

	public void setCriticidade(Integer criticidade) {
		this.criticidade = criticidade;
	}

	public String getSeveridade() {
		return severidade;
	}

	public void setSeveridade(String severidade) {
		this.severidade = severidade;
	}

	public String getImpactoFinanceiro() {
		return impactoFinanceiro;
	}

	public void setImpactoFinanceiro(String impactoFinanceiro) {
		this.impactoFinanceiro = impactoFinanceiro;
	}

	public String getResponsavelRisco() {
		return responsavelRisco;
	}

	public void setResponsavelRisco(String responsavelRisco) {
		this.responsavelRisco = responsavelRisco;
	}

	public String getResponsavelConjunto() {
		return responsavelConjunto;
	}

	public void setResponsavelConjunto(String responsavelConjunto) {
		this.responsavelConjunto = responsavelConjunto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public Date getDataRisco() {
		return dataRisco;
	}

	public void setDataRisco(Date dataRisco) {
		this.dataRisco = dataRisco;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "IdentificacaoRiscoDTO [id=" + id + ", projeto=" + projeto + ", contrato=" + contrato + ", tipoRisco="
				+ tipoRisco + ", risco=" + risco + ", conjunto=" + conjunto + ", evento=" + evento + ", descricaoRisco="
				+ descricaoRisco + ", causa=" + causa + ", consequencia=" + consequencia + ", tratamento=" + tratamento
				+ ", planoContingencia=" + planoContingencia + ", categoria=" + categoria + ", probabilidade="
				+ probabilidade + ", impacto=" + impacto + ", criticidade=" + criticidade + ", severidade=" + severidade
				+ ", impactoFinanceiro=" + impactoFinanceiro + ", responsavelRisco=" + responsavelRisco
				+ ", responsavelConjunto=" + responsavelConjunto + ", status=" + status + ", dataLimite=" + dataLimite
				+ ", dataRisco=" + dataRisco + ", ano=" + ano + "]";
	}
}
