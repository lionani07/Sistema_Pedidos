package com.br.stefanini.pedidos.model.enums;

public enum Departamento {
	ESTOQUE("Estoque"),
	COMERCIAL("Comercial"),
	COMPRA("Compras");
	
	private String descricao;
	
	private Departamento(String descricao) {
		this.descricao =  descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
