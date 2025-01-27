package br.mil.eb.sgr.sgr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_conjunto")
public class Conjunto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@ManyToOne
    @JoinColumn(name = "id_responsavel_conjunto")
    private ResponsavelConjunto responsavelConjunto;
	
	public Conjunto() {
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

	public ResponsavelConjunto getResponsavelConjunto() {
		return responsavelConjunto;
	}

	public void setResponsavelConjunto(ResponsavelConjunto responsavelConjunto) {
		this.responsavelConjunto = responsavelConjunto;
	}

	@Override
	public String toString() {
		return "Conjunto [id=" + id + ", nome=" + nome + ", responsavelConjunto=" + responsavelConjunto + "]";
	}
}
