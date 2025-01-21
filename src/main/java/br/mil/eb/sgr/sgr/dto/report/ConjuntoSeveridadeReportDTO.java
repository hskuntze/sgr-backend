package br.mil.eb.sgr.sgr.dto.report;

import java.io.Serializable;

public class ConjuntoSeveridadeReportDTO implements Serializable {
	private static final long serialVersionUID = 7241057786884495477L;

	private String conjunto;
	private Integer baixo;
	private Integer medio;
	private Integer alto;
	private Integer extremo;
	private Integer total;
	
	public ConjuntoSeveridadeReportDTO() {
	}
	
	public ConjuntoSeveridadeReportDTO(String conjunto, Integer baixo, Integer medio, Integer alto, Integer extremo, Integer total) {
		this.conjunto = conjunto;
		this.baixo = baixo;
		this.medio = medio;
		this.alto = alto;
		this.extremo = extremo;
		this.total = total;
	}

	public String getConjunto() {
		return conjunto;
	}

	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}

	public Integer getBaixo() {
		return baixo;
	}

	public void setBaixo(Integer baixo) {
		this.baixo = baixo;
	}

	public Integer getMedio() {
		return medio;
	}

	public void setMedio(Integer medio) {
		this.medio = medio;
	}

	public Integer getAlto() {
		return alto;
	}

	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	public Integer getExtremo() {
		return extremo;
	}

	public void setExtremo(Integer extremo) {
		this.extremo = extremo;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ConjuntoSeveridadeReportDTO [conjunto=" + conjunto + ", baixo=" + baixo + ", medio=" + medio + ", alto="
				+ alto + ", extremo=" + extremo + "]";
	}
}
