package com.br.stefanini.pedidos.services;

import java.util.List;

import com.br.stefanini.pedidos.model.Produto;
import com.br.stefanini.pedidos.repository.ProdutoRepository;

public class ProdutoService {
	
	private ProdutoRepository repository;
	
	public ProdutoService() throws Exception {
		this.repository = new ProdutoRepository();
	}
	
	public void adiciona(Produto produto){
		if(produto!=null){	
			if(!exite(produto)){
				repository.adicionar(produto);			
			}			
		}
		
	}

	public List<Produto> listar() {		
		return repository.listar();
	}
	
	
	private boolean exite(Produto produto){
		if(repository.existe(produto.getNome())){
			throw new RuntimeException("Produto existe");
		}
		return false;
	}

}
