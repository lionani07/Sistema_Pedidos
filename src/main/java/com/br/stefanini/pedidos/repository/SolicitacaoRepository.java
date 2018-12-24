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
		TypedQuery<Solicitacao> query = this.manager.createQuery("from Solicitacao", Solicitacao.class);
		if(usuario.getRol().equals(Rol.ESTOQUE)){
			query = this.manager.createQuery("from Solicitacao s where s.estadoActual=:estoque or s.estadoActual=:aprovado or s.estadoActual=:cancelado", Solicitacao.class);
			query.setParameter("estoque", areaEstado.ESTOQUE);
			query.setParameter("aprovado", areaEstado.APROVADO);
			query.setParameter("cancelado", areaEstado.CANCELADO);
		}
		if(usuario.getRol().equals(Rol.COMERCIAL)){
			query = this.manager.createQuery("from Solicitacao s where s.estadoActual=:comercial", Solicitacao.class);
			query.setParameter("comercial", areaEstado.COMERCIAL);
		}
		if(usuario.getRol().equals(Rol.GERENTE)){
			query = this.manager.createQuery("from Solicitacao s where s.estadoActual=:gerente", Solicitacao.class);
			query.setParameter("gerente", areaEstado.GERENTE);
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


	public Integer totalAprovadas() {		
			TypedQuery<Long> query = this.manager
					.createQuery(
							"SELECT COUNT(s) FROM Solicitacao s where s.estadoActual=:aprovado",
							Long.class);
			query.setParameter("aprovado", areaEstado.APROVADO);			
			Long total = query.getSingleResult();
			return Integer.parseInt(total.toString());
	}
	

}
