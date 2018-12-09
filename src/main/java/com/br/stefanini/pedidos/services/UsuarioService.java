package com.br.stefanini.pedidos.services;

import java.util.List;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository repository;

	public UsuarioService() throws Exception {
		this.repository = new UsuarioRepository();
	}

	public void adiciona(Usuario usuario) {
		if (!existe(usuario)) {
			this.repository.adiciona(usuario);
		}
		else{
			throw new RuntimeException("Usuario existe");
		}		

	}

	public boolean existe(Usuario usuario) {
		try {
			List<Usuario> usuariosBD = null;
			usuariosBD = repository.existe(usuario);
			if (usuariosBD != null) {
				for(Usuario u : usuariosBD){
					if(!u.equals(usuario)){
						return true;
					}
				}
				return false;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	public List<Usuario> listar() {
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
