package com.br.stefanini.pedidos.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import com.br.stefanini.pedidos.model.EstadoSolicitacao;
import com.br.stefanini.pedidos.model.Solicitacao;
import com.br.stefanini.pedidos.model.enums.areaEstado;
import com.br.stefanini.pedidos.services.SolicitacaoService;

@ManagedBean
@ViewScoped
public class SolicitacaoController implements Serializable {
	private static final long serialVersionUID = 1L;

	private SolicitacaoService solicitacaoService;

	private Solicitacao solicitacao;
	private Solicitacao solicitacaoSelect;
	private List<Solicitacao> listaSolicitacao = new ArrayList<Solicitacao>();
	private EstadoSolicitacao estadoSolicitacao;

	/* Dados fotos */
	private String fotoActual;
	private Long sizeFotoActual;

	public Long getSizeFotoActual() {
		try {
			return sizeFotoActual / 1024;
		} catch (Exception e) {
			return new Long(0);
		}

	}

	public String getFotoActual() {
		return fotoActual;
	}

	public SolicitacaoController() throws Exception {
		this.solicitacao = new Solicitacao();
		this.solicitacaoService = new SolicitacaoService();
		this.estadoSolicitacao = new EstadoSolicitacao();

	}

	public String adicionar() {
		try {
			if (this.solicitacao.getArquivo() == null) {
				throw new RuntimeException("Arquivo de imagem é obrigatorio");
			} else {
				this.solicitacaoService.adiciona(this.solicitacao);
				this.solicitacao = new Solicitacao();
				mostrarMessage("Solicitaçao criada");
				return "/solicitacao/listar?faces-redirect=true";
			}
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
			return null;
		}

	}
	
	public String cancelarSolicitacao(){
		try {
			this.estadoSolicitacao.setData(new Date());
			this.estadoSolicitacao.setArea(areaEstado.CANCELADO);
			this.solicitacaoSelect.addEstado(this.estadoSolicitacao);
			this.solicitacaoService.adiciona(this.solicitacaoSelect);
			mostrarMessage("Solicitaçao cancelada");
			this.estadoSolicitacao  = new EstadoSolicitacao();
			return "/solicitacao/listar?faces-redirect=true";
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
			return null;
		}		
	}
	
	public String aprovarSolicitacao(){
		try {			
			this.solicitacaoService.aprovar(this.solicitacaoSelect, this.estadoSolicitacao);
			mostrarMessage("Solicitaçao aprovada");
			this.estadoSolicitacao  = new EstadoSolicitacao();
			return "/solicitacao/listar?faces-redirect=true";
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
			return null;
		}
		
	}

	public void delete() {
		try {
			this.solicitacaoService.delete(this.solicitacaoSelect);
			this.solicitacaoSelect = null;
			mostrarMessage("Solicitaçao excluida");
			listar();
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}

	}
	
	public areaEstado[] getestadoSolicitacoes(){
		areaEstado[] estadosRetorno = new areaEstado[3];
		estadosRetorno[0] = areaEstado.ESTOQUE;
		estadosRetorno[1] = areaEstado.APROVADO;
		estadosRetorno[2] = areaEstado.CANCELADO;
		return estadosRetorno;
	}

	public void listar() {
		try {
			this.listaSolicitacao = solicitacaoService.listar();
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}

	}
	
	public String gettotalAprovadas(){
		try {
			return this.solicitacaoService.totalAprovadas();
		}catch (Exception e) {
			return String.valueOf(0);
		}
		
	}
		
	

	public void processFileUpload(FileUploadEvent uploadEvent) {
		try {
			fotoActual = uploadEvent.getFile().getFileName();
			sizeFotoActual = uploadEvent.getFile().getSize();
			solicitacao.setArquivo(uploadEvent.getFile().getContents());
		} catch (Exception e) {
			mostrarMessageError(e.getMessage());
		}
	}

	public void mostrarImage() throws SQLException, IOException {

		File folder = new File(FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(File.separator + "temp"));
		if (!folder.exists())
			folder.mkdirs();		
		FileOutputStream fos = new FileOutputStream(folder + File.separator
				+ this.solicitacaoSelect.getId() + ".jpg");
		fos.write(this.solicitacaoSelect.getArquivo());
		fos.close();
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

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Solicitacao getSolicitacaoSelect() {
		return solicitacaoSelect;
	}

	public void setSolicitacaoSelect(Solicitacao solicitacaoSelect) {
		this.solicitacaoSelect = solicitacaoSelect;
	}

	public List<Solicitacao> getListaSolicitacao() {
		return listaSolicitacao;
	}

	public void setListaSolicitacao(List<Solicitacao> listaSolicitacao) {
		this.listaSolicitacao = listaSolicitacao;
	}
	
	public EstadoSolicitacao getEstadoSolicitacao() {
		return estadoSolicitacao;
	}
	public void setEstadoSolicitacao(EstadoSolicitacao estadoSolicitacao) {
		this.estadoSolicitacao = estadoSolicitacao;
	}

}
