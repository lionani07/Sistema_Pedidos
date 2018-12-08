package com.br.stefanini.pedidos.model.enums;

public enum EstadoUsuario {
	ACTIVO("Activo"),
	INACTIVO("Inactivo");	
	private String descricao;
	
	private EstadoUsuario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
