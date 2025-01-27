package br.mil.eb.sgr.sgr.dto;

import java.io.Serializable;

import br.mil.eb.sgr.sgr.entities.Conjunto;

public class ConjuntoDTO implements Serializable {
	private static final long serialVersionUID = -2732049873437719283L;
	
	private Long id;
	private String nome;
	private ResponsavelConjuntoDTO responsavelConjunto;
	
	public ConjuntoDTO() {
	}
	
	public ConjuntoDTO(Conjunto cj) {
		this.id = cj.getId();
		this.nome = cj.getNome();
		
		this.responsavelConjunto = new ResponsavelConjuntoDTO(cj.getResponsavelConjunto());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ResponsavelConjuntoDTO getResponsavelConjunto() {
		return responsavelConjunto;
	}

	public void setResponsavelConjunto(ResponsavelConjuntoDTO responsavelConjunto) {
		this.responsavelConjunto = responsavelConjunto;
	}

	@Override
	public String toString() {
		return "ConjuntoDTO [id=" + id + ", nome=" + nome + ", responsavelConjunto=" + responsavelConjunto + "]";
	}
}
