package com.br.stefanini.pedidos.services;

import java.util.List;

import com.br.stefanini.pedidos.model.Produto;
import com.br.stefanini.pedidos.repository.ProdutoRepository;

public class ProdutoService {

	private ProdutoRepository repository;

	public ProdutoService() throws Exception {
		this.repository = new ProdutoRepository();
	}

	public void adiciona(Produto produto) {
		if (!exite(produto)) {
			repository.adicionar(produto);
		}
		else{		
			throw new RuntimeException("Produto existe");
		}
		
	}

	public List<Produto> listar() {
		return repository.listar();
	}

	private boolean exite(Produto produto) {
		Produto produtoBD = null;
		try {
			produtoBD = repository.existe(produto.getNome());
			if (produtoBD != null) {
				if (produtoBD.equals(produto)) {
					return false;
				}
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void delete(Produto productoSelect) {
		try {
			repository.delete(productoSelect);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		

	}

}
