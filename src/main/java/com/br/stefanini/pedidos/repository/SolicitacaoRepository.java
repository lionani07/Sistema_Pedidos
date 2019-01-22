package com.br.stefanini.pedidos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.br.stefanini.pedidos.model.EstadoSolicitacao;
import com.br.stefanini.pedidos.model.Solicitacao;
import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.model.enums.Rol;
import com.br.stefanini.pedidos.model.enums.areaEstado;
import com.br.stefanini.pedidos.utils.JpaUtil;

public class SolicitacaoRepository {

	private EntityManager manager = null;

	public SolicitacaoRepository() throws Exception {
		if (this.manager == null) {
			this.manager = JpaUtil.getEntityManager();
		}
	}

	public void adicionar(Solicitacao solicitacao) {
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
		TypedQuery<Solicitacao> query = this.manager.createQuery(
				"from Solicitacao", Solicitacao.class);
		if (usuario.getRol().equals(Rol.ANALISTA_COMPRAS)) {
			query = this.manager
					.createQuery(
							"from Solicitacao s where s.estadoActual=:comercial or s.estadoActual=:aprovado or s.estadoActual=:cancelado",
							Solicitacao.class);
			query.setParameter("comercial", areaEstado.COMPRAS);
			query.setParameter("aprovado", areaEstado.APROVADO);
			query.setParameter("cancelado", areaEstado.CANCELADO);
		}
		if (usuario.getRol().equals(Rol.ANALISTA_TECNICO)) {
			query = this.manager.createQuery(
					"from Solicitacao s where s.estadoActual=:comercial",
					Solicitacao.class);
			query.setParameter("comercial", areaEstado.COMPRAS);
		}
		if (usuario.getRol().equals(Rol.GERENTE_OPERACIONAL)) {
			query = this.manager.createQuery(
					"from Solicitacao s where s.estadoActual=:gerente",
					Solicitacao.class);
			query.setParameter("gerente", areaEstado.TECNICO);
		}
		if (usuario.getRol().equals(Rol.GERENTE_PRODUTOS)) {
			query = this.manager.createQuery(
					"from Solicitacao s where s.estadoActual=:gerente",
					Solicitacao.class);
			query.setParameter("gerente", areaEstado.OPERACIONES);
		}
		if (usuario.getRol().equals(Rol.GERENTE_COMERCIAL)) {
			query = this.manager.createQuery(
					"from Solicitacao s where s.estadoActual=:gerente",
					Solicitacao.class);
			query.setParameter("gerente", areaEstado.PRODUTOS);
		}
		return query.getResultList();
	}

	public Solicitacao findById(Integer id) {
		return this.manager.find(Solicitacao.class, id);
	}

	public void delete(Solicitacao solicitacao) {
		EntityTransaction trx = this.manager.getTransaction();
		try {
			trx.begin();
			this.manager.remove(solicitacao);
			trx.commit();
		} catch (Exception e) {
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

	public Integer totalSinIniciar() {
		TypedQuery<Long> query = this.manager
				.createQuery(
						"SELECT COUNT(s) FROM Solicitacao s where s.estadoActual=:compras",
						Long.class);
		query.setParameter("compras", areaEstado.COMPRAS);
		Long total = query.getSingleResult();
		return Integer.parseInt(total.toString());
	}
	
	public Integer totalEmAndamento() {
		TypedQuery<Long> query = this.manager
				.createQuery(
						"SELECT COUNT(s) FROM Solicitacao s where s.estadoActual=:tecnico or s.estadoActual=:operaciones or s.estadoActual=:produtos",
						Long.class);
		query.setParameter("tecnico", areaEstado.TECNICO);
		query.setParameter("operaciones", areaEstado.OPERACIONES);
		query.setParameter("produtos", areaEstado.PRODUTOS);
		Long total = query.getSingleResult();
		return Integer.parseInt(total.toString());
	}
	
	public Integer totalCanceladas() {
		TypedQuery<Long> query = this.manager
				.createQuery(
						"SELECT COUNT(s) FROM Solicitacao s where s.estadoActual=:cancelada",
						Long.class);
		query.setParameter("cancelada", areaEstado.CANCELADO);
		Long total = query.getSingleResult();
		return Integer.parseInt(total.toString());
	}

	public List<EstadoSolicitacao> getEstadosBySolicitacao(Solicitacao solicitacaoSelect) {
		TypedQuery<EstadoSolicitacao> query = this.manager.createQuery("from EstadoSolicitacao es where es.solicitacao=:solicitacaoSelect", EstadoSolicitacao.class);
		query.setParameter("solicitacaoSelect", solicitacaoSelect);
		return query.getResultList();
	}

	public Solicitacao existeSolicitacaobyNumeroPedido(String numeroPedido) {
		try {
			TypedQuery<Solicitacao> query = this.manager.createQuery("from Solicitacao s where upper(s.numeroPedido) =:numeroPedido", Solicitacao.class);
			query.setParameter("numeroPedido", numeroPedido.toUpperCase());
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	

}
