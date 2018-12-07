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
		if (this.manager == null) {
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

	public Usuario findById(Long id) {
		try {
			return this.manager.find(Usuario.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	public List<Usuario> listar() {
		try {
			TypedQuery<Usuario> query = this.manager.createQuery(
					"From Usuario u", Usuario.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	public void delete(Usuario usuarioSelect) {
		EntityTransaction trx = null;
		try {
			trx = this.manager.getTransaction();
			trx.begin();
			this.manager.remove(usuarioSelect);
			trx.commit();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
