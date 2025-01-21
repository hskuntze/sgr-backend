package br.mil.eb.sgr.sgr.projections;

public interface RiscoSeveridadeProjection {
	String getRisco();
	Integer getBaixo();
	Integer getMedio();
	Integer getAlto();
	Integer getExtremo();
	Integer getTotal();
}
