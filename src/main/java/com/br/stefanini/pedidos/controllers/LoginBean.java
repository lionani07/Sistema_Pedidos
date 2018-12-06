package com.br.stefanini.pedidos.controllers;
/*package com.br.aernnova.controller;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.br.aernnova.dao.PessoaDao;
import com.br.aernnova.model.Pessoa;
import com.br.aernnova.services.PessoaService;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Pessoa userLogado;
	private String people;
	private String senha;
	
	private PessoaService pessoaService;	
	
	public LoginBean() {
		this.pessoaService = new PessoaService();		
	}

	public Pessoa getUserLogado() {
		return this.userLogado;
	}	
	public void setUserLogado(Pessoa userLogado) {
		this.userLogado = userLogado;
	}

	public String login(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		try {
			String senhaEncrip = this.pessoaService.encriptar(this.senha);				
			this.userLogado = this.pessoaService.getPessoaLogin(this.people, senhaEncrip);					
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

}*/
