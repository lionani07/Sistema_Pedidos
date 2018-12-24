package com.br.stefanini.pedidos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.br.stefanini.pedidos.model.Solicitacao;
import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.model.enums.Rol;
import com.br.stefanini.pedidos.model.enums.areaEstado;
import com.br.stefanini.pedidos.utils.JpaUtil;

public class SolicitacaoRepository{
	
	private EntityManager manager = null;
	
	public SolicitacaoRepository() throws Exception {
		if(this.manager==null){
			this.manager = JpaUtil.getEntityManager();
		}		
	}
	
	
	public void adicionar(Solicitacao solicitacao){	
		EntityTransaction trx = null;
		try {
			trx = this.manager.getTransaction();
			trx.begin();		
			this.manager.merge(solicitacao);			
			trx.commit();			
		} catch (Exception e) {
			trx.rollback();
			throw new RuntimeException(e.getMessage());
		}		
				
	}

	public List<Solicitacao> listar(Usuario usuario) {
		TypedQuery<Solicitacao> query = this.manager.createQuery("from Solicitacao s where s.estadoActual=:estadoActual", Solicitacao.class);
		if(usuario.getRol().equals(Rol.ESTOQUE)){
			query.setParameter("estadoActual", areaEstado.ESTOQUE);
		}
		if(usuario.getRol().equals(Rol.COMERCIAL)){
			query.setParameter("estadoActual", areaEstado.COMERCIAL);
		}
		if(usuario.getRol().equals(Rol.GERENTE)){
			query.setParameter("estadoActual", areaEstado.GERENTE);
		}		
		return query.getResultList();
	}

	public Solicitacao findById(Integer id) {
		return this.manager.find(Solicitacao.class, id);
	}

	public void delete(Solicitacao solicitacao) {
		EntityTransaction trx = this.manager.getTransaction();
		try{
			trx.begin();
			this.manager.remove(solicitacao);
			trx.commit();
		}catch(Exception e){
			trx.rollback();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	

}
