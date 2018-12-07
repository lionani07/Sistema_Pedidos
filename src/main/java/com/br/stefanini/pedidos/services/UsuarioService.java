package com.br.stefanini.pedidos.services;

import java.util.List;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.repository.UsuarioRepository;

public class UsuarioService {
	
	private UsuarioRepository repository;
	
	
	public UsuarioService() throws Exception {
		this.repository = new UsuarioRepository();
	}
	
	public void adiciona(Usuario usuario){
		this.repository.adiciona(usuario);
	}
	
	public List<Usuario> listar(){
		try {
			return repository.listar();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	public void delete(Usuario usuarioSelect) {
		try {
			repository.delete(usuarioSelect);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	

}
