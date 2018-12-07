package com.br.stefanini.pedidos.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.br.stefanini.pedidos.model.Produto;
import com.br.stefanini.pedidos.services.ProdutoService;

@ManagedBean
@ViewScoped
public class ProdutoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ProdutoService produtoService;
	
	private Produto produto;
	private Produto productoSelect;
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	public ProdutoController() throws Exception {
		this.produto = new Produto();
		this.produtoService = new ProdutoService();		
		
	}
		
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Produto getProductoSelect() {
		return productoSelect;
	}
	public void setProductoSelect(Produto productoSelect) {
		this.productoSelect = productoSelect;
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	

	public String adicionar(){
		try {
			this.produtoService.adiciona(this.produto);
			this.produto = new Produto();
			mostrarMessage("Produto salvado");
			return "/produtos/listar?faces-redirect=true";
		}catch (Exception e) {
			mostrarMessageError(e.getMessage());
			return null;
		}
		
	}
	
	public void delete(){
		try {
			this.produtoService.delete(this.productoSelect);
			this.productoSelect = null;
			mostrarMessage("Produto eliminado");
			listar();
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}
		
	}
	
	public void listar(){
		this.listaProdutos = produtoService.listar();
	}
		
	
	private void mostrarMessage(String msg){		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true); //Para mostrar message quanfo faco redirect		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
	}
	
	private void mostrarMessageError(String msg){	
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		context.addMessage(null, message);
	}
	
	
	
	
	

}
