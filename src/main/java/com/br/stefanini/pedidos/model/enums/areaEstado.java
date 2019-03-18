package com.br.stefanini.pedidos.model.enums;

public enum areaEstado {	
	COMPRAS("Compras", 0, "Técnico"),
	TECNICO("Técnico", 1, "Operaciones"),
	OPERACIONES("Operaciones", 2, "Produtos"),
	PRODUTOS("Produtos", 3, "Comercial"),	
	APROVADO("Aprovado", 4, "Aprovado"),
	FINALIZADO("Finalizado", 5, "Finalizado"),
	ARQUIVADO("Arquivado", 6, "Arquivado"),
	CANCELADO("Cancelado", 7, "Cancelado");
	
	private String descricao;
	private int valor;	
	private String areEstadoNext;
	
	private areaEstado(String descricao, int valor, String areEstadoNext) {
		this.descricao = descricao;
		this.valor = valor;
		this.areEstadoNext = areEstadoNext;
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getValor() {
		return valor;
	}
	
	public String getAreEstadoNext() {
		return areEstadoNext;
	}
	


}
