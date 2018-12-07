package com.br.stefanini.pedidos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.utils.JpaUtil;

public class UsuarioRepository {
	
	private EntityManager manager = null;
	
	public UsuarioRepository() throws Exception {
		if(this.manager==null){
			this.manager = JpaUtil.getEntityManager();
		}
	}

	public void adiciona(Usuario usuario) {
		EntityTransaction trx = null;
		try {
			trx = this.manager.getTransaction();
			trx.begin();
			this.manager.merge(usuario);
			trx.commit();
		} catch (Exception e) {
			trx.rollback();
			throw new RuntimeException(e.getMessage());
		}
		
	}

	public List<Usuario> listar() {
		try {
			TypedQuery<Usuario> query = this.manager.createQuery("From Usuario u", Usuario.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
		
	}

}
