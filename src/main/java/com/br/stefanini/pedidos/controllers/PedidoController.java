package com.br.stefanini.pedidos.controllers;

import javax.faces.bean.ManagedBean;

import com.br.stefanini.pedidos.model.ItemPedido;
import com.br.stefanini.pedidos.model.Pedido;
import com.br.stefanini.pedidos.model.Produto;

@ManagedBean
public class PedidoController {

	private Pedido pedido;	
	private ItemPedido itemPedido;
	

	public PedidoController() {
		this.pedido = new Pedido();
	}
	
	public void addItem(Produto p){
		this.pedido.getItems().add(itemPedido);
	}
	
	public Pedido getItems() {
		return pedido;
	}

}
