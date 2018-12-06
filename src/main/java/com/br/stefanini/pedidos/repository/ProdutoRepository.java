package com.br.stefanini.pedidos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.br.stefanini.pedidos.model.Produto;
import com.br.stefanini.pedidos.utils.JpaUtil;

public class ProdutoRepository{
	
	private EntityManager manager;
	
	public ProdutoRepository() throws Exception {
		this.manager = JpaUtil.getEntityManager();
	}
	
	public void adicionar(Produto produto){
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();		
		this.manager.persist(produto);
		trx.commit();
		this.manager.close();
	}

	public List<Produto> listar() {
		TypedQuery<Produto> query = this.manager.createQuery("from Produto p", Produto.class);
		return query.getResultList();
	}
	

}
