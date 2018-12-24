package com.br.stefanini.pedidos.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.br.stefanini.pedidos.model.enums.EstadoUsuario;
import com.br.stefanini.pedidos.model.enums.Rol;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="People é obrigatório")
	private String people;
	
	private String senha;
	
	@NotBlank(message="Nome é obrigatório")
	private String nome;
	
	@NotBlank(message="Email é obrigatório")
	@Email(message="Formato de email incorreto")	
	private String email;	
	
	@NotNull(message="Rol e obrigatório")
	@Enumerated(EnumType.STRING)
	private Rol rol;	
	
	@Enumerated(EnumType.STRING)
	private EstadoUsuario estado;
	
	
	
	public Usuario(){						
		this.estado = EstadoUsuario.ACTIVO;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
		
	public EstadoUsuario getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	

		

}
