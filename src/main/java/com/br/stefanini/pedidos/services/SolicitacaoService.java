package com.br.stefanini.pedidos.services;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import com.br.stefanini.pedidos.model.EstadoSolicitacao;
import com.br.stefanini.pedidos.model.Solicitacao;
import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.model.enums.areaEstado;
import com.br.stefanini.pedidos.repository.SolicitacaoRepository;

public class SolicitacaoService {

	private SolicitacaoRepository repository = null;

	public SolicitacaoService() throws Exception {
		if(this.repository==null){
			this.repository = new SolicitacaoRepository();
		}		
	}
	
	public Solicitacao findById(Integer id){
		return repository.findById(id);
	}

	public void adiciona(Solicitacao solicitacao) {						
		repository.adicionar(solicitacao);
	}

	public List<Solicitacao> listar() {
		Usuario userLogado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		return repository.listar(userLogado);
	}
	
	public void delete(Solicitacao solicitacao) {
		repository.delete(solicitacao);
	}
	
	public void aprovar(Solicitacao solicitacao, EstadoSolicitacao estadoSolicitacao){
		if(aprovarSolicitacao(solicitacao, estadoSolicitacao)){
			solicitacao.addEstado(estadoSolicitacao);
			adiciona(solicitacao);
		}		
	}
	
	private boolean aprovarSolicitacao(Solicitacao solicitacao, EstadoSolicitacao estadoSolicitacao){
		int areaSolicitacao = solicitacao.getEstadoActual().getValor();
		areaEstado estadoActual = solicitacao.getEstadoActual();
		if(estadoActual.equals(areaEstado.COMERCIAL) || estadoActual.equals(areaEstado.GERENTE)){
			estadoSolicitacao.setArea(areaEstado.values()[areaSolicitacao+1]);
			estadoSolicitacao.setData(new Date());
			return true;
		}
		return false;
	}

	public String totalAprovadas() {
		return this.repository.totalAprovadas()+"";
	}
	
	public String totalAreaComercial() {
		return this.repository.totalAreaComercial()+"";
	}
	
	public String totalAreaGerente() {
		return this.repository.totalAreaGerente()+"";
	}
	
	public String totalCanceladas() {
		return this.repository.totalCanceladas()+"";
	}

}