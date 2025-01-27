package br.mil.eb.sgr.sgr.dto;

import java.io.Serializable;

import br.mil.eb.sgr.sgr.entities.ResponsavelConjunto;

public class ResponsavelConjuntoDTO implements Serializable {
	private static final long serialVersionUID = 8272062579603130640L;
	
	private Long id;
	private String nome;
	
	public ResponsavelConjuntoDTO() {
	}
	
	public ResponsavelConjuntoDTO(ResponsavelConjunto rc) {
		this.id = rc.getId();
		this.nome = rc.getNome();
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

	@Override
	public String toString() {
		return "ResponsavelConjuntoDTO [id=" + id + ", nome=" + nome + "]";
	}
}
