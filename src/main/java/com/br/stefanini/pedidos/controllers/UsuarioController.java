package com.br.stefanini.pedidos.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.PrimeFaces;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.model.enums.Rol;
import com.br.stefanini.pedidos.services.UsuarioService;
import com.br.stefanini.pedidos.utils.Utils;

@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Senha 1 é campo obrigatório")
	private String senhanova1;
	@NotBlank(message = "Senha 2 é campo obrigatório")
	private String senhanova2;

	private Usuario usuario;
	private Usuario usuarioSelect;
	private UsuarioService usuarioService;

	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	public UsuarioController() throws Exception {
		this.usuario = new Usuario();
		this.usuarioService = new UsuarioService();
	}

	public String adiciona() {
		try {
			this.usuario.setSenha(Utils.encriptar(this.usuario.getPeople()));
			this.usuarioService.adiciona(this.usuario);
			this.usuario = new Usuario();
			mostrarMessage("Usuario guardado");
			return "/usuarios/listar?faces-redirect=true";
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
			return null;
		}

	}

	public void delete() {
		try {
			usuarioService.delete(this.usuarioSelect);
			this.usuarioSelect = null;
			mostrarMessage("Usuario removido");
			listar();
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}
	}

	public void listar() {
		try {
			this.listaUsuarios = usuarioService.listar();
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}

	}

	private boolean senhasOK() {
		if (this.senhanova1.equals(this.senhanova2)) {
			return true;
		} else {
			throw new RuntimeException("Senhas nao Coicidem");
		}
	}

	public void trocarSenha(ActionEvent event) {		
		boolean senhaTrocada = false;
		try {
			if (senhasOK()) {
				this.usuarioService.trocarSenha(this.usuarioSelect, this.senhanova1);
				mostrarMessage("Senha de " + this.usuarioSelect.getNome() + "Trocada");
				senhaTrocada = true;
				this.senhanova1 = "";
				this.senhanova2 = "";
			}
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}		
		PrimeFaces.current().ajax()
				.addCallbackParam("senhaTrocada", senhaTrocada);
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

	public Rol[] getRoles() {
		return Rol.values();
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String getSenhanova1() {
		return senhanova1;
	}

	public void setSenhanova1(String senhanova1) {
		this.senhanova1 = senhanova1;
	}

	public String getSenhanova2() {
		return senhanova2;
	}

	public void setSenhanova2(String senhanova2) {
		this.senhanova2 = senhanova2;
	}

	private void mostrarMessage(String msg) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true); // Para mostrar message quanfo faco
										// redirect
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
	}

	private void mostrarMessageError(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				msg, msg);
		context.addMessage(null, message);
	}

}
