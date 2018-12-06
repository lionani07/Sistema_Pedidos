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
	
	public Boolean existe(String nome){		
		TypedQuery<Long> query = this.manager.createQuery("Select Count(p) From Produto p Where p.nome=:nome", Long.class);
		query.setParameter("nome", nome);
		Long result =  query.getSingleResult();
		return (result>0) ? true : false;
	}
	
	public void adicionar(Produto produto){	
		EntityTransaction trx = this.manager.getTransaction();
		try {			
			trx.begin();		
			this.manager.merge(produto);
			trx.commit();			
		} catch (Exception e) {
			trx.rollback();
			throw new RuntimeException(e.getMessage());
		}		
				
	}

	public List<Produto> listar() {
		TypedQuery<Produto> query = this.manager.createQuery("from Produto p", Produto.class);
		return query.getResultList();
	}

	public Produto findById(Integer id) {
		return this.manager.find(Produto.class, id);
	}

	public void delete(Produto productoSelect) {
		EntityTransaction trx = this.manager.getTransaction();
		try{
			trx.begin();
			this.manager.remove(productoSelect);
			trx.commit();
		}catch(Exception e){
			trx.rollback();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	

}
