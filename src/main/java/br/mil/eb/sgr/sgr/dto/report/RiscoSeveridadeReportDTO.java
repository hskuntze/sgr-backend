package br.mil.eb.sgr.sgr.dto.report;

import java.io.Serializable;

public class RiscoSeveridadeReportDTO implements Serializable {
	private static final long serialVersionUID = 5119286875011981173L;
	
	private String risco;
	private Integer baixo;
	private Integer medio;
	private Integer alto;
	private Integer extremo;
	private Integer total;
	
	public RiscoSeveridadeReportDTO() {
	}
	
	public RiscoSeveridadeReportDTO(String risco, Integer baixo, Integer medio, Integer alto, Integer extremo, Integer total) {
		this.risco = risco;
		this.baixo = baixo;
		this.medio = medio;
		this.alto = alto;
		this.extremo = extremo;
		this.total = total;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
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
		return "RiscoSeveridadeReportDTO [risco=" + risco + ", baixo=" + baixo + ", medio=" + medio + ", alto=" + alto
				+ ", extremo=" + extremo + ", total=" + total + "]";
	}
}
