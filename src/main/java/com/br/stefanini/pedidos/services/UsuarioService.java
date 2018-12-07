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
		} else {
			throw new RuntimeException("Usuario existe");
		}

	}

	public boolean existe(Usuario usuario) {
		try {
			Usuario usuarioBD = null;
			usuarioBD = repository.existe(usuario);
			if (usuarioBD != null) {
				if (usuarioBD.equals(usuario)) {
					return false;
				} else {
					return true;
				}
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
