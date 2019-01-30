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
		if(!existeSolicitacaobyNumeroPedido(solicitacao)){
			repository.adicionar(solicitacao);
		}
		else{
			throw new RuntimeException("Numero de pedido existe");
		}
		
	}
	
	
	private boolean existeSolicitacaobyNumeroPedido(Solicitacao solicitacao){
		Solicitacao solicitacaoBD = null;
		solicitacaoBD =  this.repository.existeSolicitacaobyNumeroPedido(solicitacao.getNumeroPedido());
		if(solicitacaoBD!=null){
			if(!solicitacao.equals(solicitacaoBD)){
				return true;
			}
		}
		return false;
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
		if(estadoActual.getValor()>=0 && estadoActual.getValor()<=3){
			estadoSolicitacao.setArea(areaEstado.values()[areaSolicitacao+1]);
			estadoSolicitacao.setData(new Date());
			return true;
		}
		return false;
	}

	public String totalAprovadas() {
		return this.repository.totalAprovadas()+"";
	}
	
	public String totalSinIniciar() {
		return this.repository.totalSinIniciar()+"";
	}
	
	public String totalEmAndamento() {
		return this.repository.totalEmAndamento()+"";
	}
	
	public String totalCanceladas() {
		return this.repository.totalCanceladas()+"";
	}

	public List<EstadoSolicitacao> getEstadosBySolicitacao(Solicitacao solicitacaoSelect) {
		return this.repository.getEstadosBySolicitacao(solicitacaoSelect);
		
	}

	public List<Solicitacao> listarFinalizadas() {
		return repository.listarFinalizadas();
	}

	public List<Solicitacao> listarArquivadas() {
		return repository.listarArquivadas();
	}

	public List<Solicitacao> listarEnAdamentos() {
		return repository.listarEmAndamento();
	}

}
