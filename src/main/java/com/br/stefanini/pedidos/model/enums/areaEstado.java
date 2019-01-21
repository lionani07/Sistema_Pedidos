package com.br.stefanini.pedidos.model.enums;

public enum areaEstado {	
	COMPRAS("Compras", 0),
	TECNICO("Técnico", 1),
	OPERACIONES("Operaciones", 2),
	PRODUTOS("Produtos", 3),	
	APROVADO("Aprovado", 4),
	CANCELADO("Cancelado", 5);
	
	private String descricao;
	private int valor;
	
	private areaEstado(String descricao, int valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getValor() {
		return valor;
	}

}
