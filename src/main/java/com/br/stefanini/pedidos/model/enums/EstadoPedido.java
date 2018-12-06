package com.br.stefanini.pedidos.model.enums;

public enum EstadoPedido {
	CREADO("Creado"),
	APROBADO("Aprovado"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	private EstadoPedido(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
