package com.br.stefanini.pedidos.services;

import java.util.List;

import com.br.stefanini.pedidos.model.Produto;
import com.br.stefanini.pedidos.repository.ProdutoRepository;

public class ProdutoService {
	
	private ProdutoRepository repository;
	
	public ProdutoService() throws Exception {
		this.repository = new ProdutoRepository();
	}
	
	public boolean adiciona(Produto produto){
		if(produto!=null){
			repository.adicionar(produto);
			return true;
		}
		throw new RuntimeException("Error ao adicionar Produto");
		
		
	}

	public List<Produto> listar() {		
		return repository.listar();
	}
	

}
