package com.br.stefanini.pedidos.model.enums;

public enum areaEstado {	
	COMPRAS("Compras", 0),
	TECNICO("Técnico", 1),
	OPERACIONES("Operaciones", 2),
	PRODUTOS("Produtos", 3),	
	APROVADO("Aprovado", 4),
	FINALIZADO("Finalizado", 5),
	ARQUIVADO("Arquivado", 6),
	CANCELADO("Cancelado", 7);
	
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
