package com.br.stefanini.pedidos.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.model.enums.Departamento;
import com.br.stefanini.pedidos.model.enums.Rol;
import com.br.stefanini.pedidos.services.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Usuario usuarioSelect;
	private UsuarioService usuarioService;
	
	private List<Usuario> listaUsuarios;
		
	public UsuarioController() {
		this.usuario = new Usuario();
		this.listaUsuarios = new ArrayList<Usuario>();
		try {
			this.usuarioService = new UsuarioService();
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}
	}
	
	public void adiciona(){
		try {
			this.usuarioService.adiciona(this.usuario);
			this.usuario = new Usuario();
			mostrarMessage("Usuario guardado");
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}
		
	}
	
	public void listar(){
		try {
			this.listaUsuarios = usuarioService.listar();
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}
		
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSelect() {
		return usuarioSelect;
	}

	public void setUsuarioSelect(Usuario usuarioSelect) {
		this.usuarioSelect = usuarioSelect;
	}
	
	public Rol[] getRoles(){
		return Rol.values();
	}
	
	public Departamento[] getDepartamentos(){
		return Departamento.values();
	}
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	private void mostrarMessage(String msg){	
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
