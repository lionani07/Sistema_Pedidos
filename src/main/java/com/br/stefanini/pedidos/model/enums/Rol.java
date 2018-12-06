package com.br.stefanini.pedidos.model.enums;

public enum Rol {
	ADMIN("Administrador"),
	GERENTE("Gerente"),
	COMERCIA("Comercial");
	
	private String descricao;
	
	private Rol(String descricao) {
		this.descricao = descricao;		
	}
	
	public String getDescricao() {
		return descricao;
	}
}
