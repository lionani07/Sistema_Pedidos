package com.br.stefanini.pedidos.model.enums;

public enum Rol {	
	ANALISTA_COMPRAS("Analista de Compras"),
	ANALISTA_TECNICO("Analista Técnico"),
	GERENTE_OPERACIONAL("Gerente de Operaciones"),	
	GERENTE_PRODUTOS("Gerente de Produtos"),
	GERENTE_COMERCIAL("Gerente Comercial"),
	ADMIN("Administrador");
	
	private String descricao;
	
	private Rol(String descricao) {
		this.descricao = descricao;		
	}
	
	public String getDescricao() {
		return descricao;
	}
}
