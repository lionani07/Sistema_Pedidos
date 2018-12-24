package com.br.stefanini.pedidos.controllers;

import com.br.stefanini.pedidos.model.Solicitacao;
import com.br.stefanini.pedidos.services.SolicitacaoService;

public class Test {
	
	@org.junit.Test
	public void eliminarSolicitacao() throws Exception{
		
		Solicitacao solicitacao = new SolicitacaoService().findById(new Integer(1));
		new SolicitacaoService().delete(solicitacao);
		
	}

}
