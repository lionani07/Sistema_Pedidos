package com.br.stefanini.pedidos.model.enums;

public enum Rol {	
	ESTOQUE("Estoque"),
	COMERCIAL("Comercial"),
	GERENTE("Gerente"),	
	ADMIN("Admin");
	
	private String descricao;
	
	private Rol(String descricao) {
		this.descricao = descricao;		
	}
	
	public String getDescricao() {
		return descricao;
	}
}
