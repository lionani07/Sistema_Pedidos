package com.br.stefanini.pedidos.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.services.UsuarioService;
import com.br.stefanini.pedidos.utils.Utils;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario userLogado;
	private String people;
	private String senha;
	
	private UsuarioService usuarioService;	
	
	public LoginBean(){
		try {
			this.usuarioService = new UsuarioService();		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public Usuario getUserLogado() {
		return userLogado;
	}	
	public void setUserLogado(Usuario userLogado) {
		this.userLogado = userLogado;
	}
	
	public String login(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);			
		try {
			String senhaEncrip = Utils.encriptar(this.senha);				
			this.userLogado = this.usuarioService.getPessoaLogin(this.people, senhaEncrip);					
			if(this.userLogado!=null){	
				ses.setAttribute("user", this.userLogado);
				ses.setAttribute("rol", this.userLogado.getRol());				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", this.userLogado);
				return "index?faces-redirect=true";
			}
			else {
				FacesMessage facesMessage = new FacesMessage(
						"Usuário/senha inválidos!");
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, facesMessage);
			}			
		} catch (Exception e) {
			FacesMessage error = new FacesMessage(e.getMessage());
			error.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, error);
		}
		return null;		

	}

	public String logout() {
		//this.userLogado = null;
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "/Login?faces-redirect=true";
	}

	@Pattern(regexp = "[0-9]{6}", message = "People errado {6 digitos}")
	public String getPeople() {
		return people;
	}
	
	@NotEmpty(message="Por favor coloque senha")
	public String getSenha() {
		return senha;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
