package com.br.stefanini.pedidos.services;

import java.util.List;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.repository.UsuarioRepository;
import com.br.stefanini.pedidos.utils.Utils;

public class UsuarioService {

	private UsuarioRepository repository = null;

	public UsuarioService() throws Exception {
		if(this.repository==null){
			this.repository = new UsuarioRepository();
		}		
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
	
	public Usuario getPessoaLogin(String people, String senha){
		try {
			return this.repository.getPessoaLogin(people, senha);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	public void trocarSenha(Usuario u, String senha) {
		try {
			Usuario usuarioDB = this.repository.findById(u.getId());
			if (usuarioDB != null) {
				usuarioDB.setSenha(Utils.encriptar(senha));
				this.repository.adiciona(usuarioDB);
			}
		} catch (Exception e) {

		}

	}

}
