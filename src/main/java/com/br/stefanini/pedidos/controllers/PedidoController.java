package com.br.stefanini.pedidos.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.br.stefanini.pedidos.model.Produto;

@ManagedBean
@ViewScoped
public class PedidoController implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Produto> itens = new ArrayList<Produto>();
	
	private Produto produto = new Produto();
	

	public PedidoController() {
		
	}
	
	
	public List<Produto> getItems() {
		return itens;
	}
	
	public void addItem(){
		getItems().add(this.produto);
		this.produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
