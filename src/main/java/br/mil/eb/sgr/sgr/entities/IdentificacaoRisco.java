package br.mil.eb.sgr.sgr.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_identificacao_risco")
public class IdentificacaoRisco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String identificadoPor;
	private String projeto;
	private String contrato;
	private String tipoRisco;
	private String risco;
	
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
	private String status;
	private Integer ano;
	
	@Temporal(TemporalType.DATE)
	private Date dataLimite;
	
	@Temporal(TemporalType.DATE)
	private Date dataRisco;
	
	@ManyToOne
    @JoinColumn(name = "id_conjunto")
    private Conjunto conjunto;
	
	public IdentificacaoRisco() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificadoPor() {
		return identificadoPor;
	}

	public void setIdentificadoPor(String identificadoPor) {
		this.identificadoPor = identificadoPor;
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

	public Conjunto getConjunto() {
		return conjunto;
	}

	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
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
