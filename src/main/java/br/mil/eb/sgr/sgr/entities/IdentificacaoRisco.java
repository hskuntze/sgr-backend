package br.mil.eb.sgr.sgr.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_identificacao_risco")
public class IdentificacaoRisco {

	@Id
	@Column(unique = true, nullable = false)
	private String id;
	private String projeto;
	private String contrato;
	private String tipoRisco;
	private String risco;
	private String conjunto;
	
	@Lob
	private String evento;
	@Lob
	private String descricaoRisco;
	@Lob
	private String causa;
	@Lob
	private String consequencia;
	@Lob
	private String tratamento;
	@Lob
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
	
	@Temporal(TemporalType.DATE)
	private Date dataLimite;
	
	@Temporal(TemporalType.DATE)
	private Date dataRisco;
	
	private Integer ano;
	
	public IdentificacaoRisco() {
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
		return "IdentificacaoRisco [id=" + id + ", projeto=" + projeto + ", contrato=" + contrato + ", tipoRisco="
				+ tipoRisco + ", risco=" + risco + ", conjunto=" + conjunto + ", evento=" + evento + ", descricaoRisco="
				+ descricaoRisco + ", causa=" + causa + ", consequencia=" + consequencia + ", tratamento=" + tratamento
				+ ", planoContingencia=" + planoContingencia + ", categoria=" + categoria + ", probabilidade="
				+ probabilidade + ", impacto=" + impacto + ", criticidade=" + criticidade + ", severidade=" + severidade
				+ ", impactoFinanceiro=" + impactoFinanceiro + ", responsavelRisco=" + responsavelRisco
				+ ", responsavelConjunto=" + responsavelConjunto + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentificacaoRisco other = (IdentificacaoRisco) obj;
		return Objects.equals(id, other.id);
	}
}
