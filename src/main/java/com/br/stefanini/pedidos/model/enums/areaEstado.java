package com.br.stefanini.pedidos.model.enums;

public enum areaEstado {	
	COMERCIAL("Comercial", 0),
	GERENTE("Gerente", 1),
	APROVADO("Aprovado", 2),
	CANCELADO("Cancelado", 3);
	
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
