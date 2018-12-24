package com.br.stefanini.pedidos.model.enums;

public enum areaEstado {
	ESTOQUE("Estoque", 0),
	COMERCIAL("Comercial", 1),
	GERENTE("Gerente", 2),
	APROVADO("Aprovado", 3),
	CANCELADO("Cancelado", 4);
	
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
