package com.br.stefanini.pedidos.controllers;

import com.br.stefanini.pedidos.repository.ProdutoRepository;

public class ProdutoControllerTest {
	
	private static ProdutoRepository repository;
	
	public static void main(String[] args) throws Exception {
		
		repository = new ProdutoRepository();
		Boolean produto = repository.existe("bisdsdcicleta");
		
		System.out.println(produto);
		
		
	}
	
	

	
}
