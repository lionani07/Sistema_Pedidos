package com.br.stefanini.pedidos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

import com.br.stefanini.pedidos.model.enums.areaEstado;


@Entity
public class Solicitacao implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Lob()
	@Column(name="ARQUIVO_IMAGEM", columnDefinition="LONGBLOB")	
	private byte[] arquivo;
	
	@Temporal(TemporalType.DATE)
	private Date dataCreacao;
	
	@NotBlank(message="Descricao e obrigatório")
	private String descricao;	
	
	@Enumerated(EnumType.STRING)
	private areaEstado estadoActual;
	
	@OneToMany(mappedBy="solicitacao", cascade = CascadeType.ALL, orphanRemoval = true)
	List<EstadoSolicitacao> estados = new ArrayList<EstadoSolicitacao>();
	
	public Solicitacao() {
		this.estadoActual = areaEstado.COMERCIAL;
		this.dataCreacao = new Date();
	}
		
	public void addEstado(EstadoSolicitacao estadoSolicitacao){
		estados.add(estadoSolicitacao);
		estadoSolicitacao.setSolicitacao(this);
		this.setEstadoActual(estadoSolicitacao.getArea());		
	}
	
	public void removeEstado(EstadoSolicitacao estadoSolicitacao){
		estadoSolicitacao.setSolicitacao(null);
		estados.remove(estadoSolicitacao);
	}	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public byte[] getArquivo() {
		return arquivo;
	}
	
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
	
	public Date getDataCreacao() {
		return dataCreacao;
	}
	public void setDataCreacao(Date dataCreacao) {
		this.dataCreacao = dataCreacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public areaEstado getEstadoActual() {
		return estadoActual;
	}
	
	public void setEstadoActual(areaEstado estadoActual) {
		this.estadoActual = estadoActual;
	}
	
	public List<EstadoSolicitacao> getEstados() {
		return estados;
	}	
	public void setEstados(List<EstadoSolicitacao> estados) {
		this.estados = estados;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
		

}
