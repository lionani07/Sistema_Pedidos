package com.br.stefanini.pedidos.utils;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.model.enums.Rol;
import com.br.stefanini.pedidos.services.UsuarioService;

public class UserCreador {

	public static void main(String[] args) throws Exception {
		UsuarioService service = new UsuarioService();
		Usuario usuario = new Usuario();
		usuario.setPeople("000000");
		usuario.setNome("Admin");
		usuario.setSenha(Utils.encriptar(usuario.getPeople()));
		usuario.setRol(Rol.ADMIN);
		usuario.setEmail("admin@admin.com");
		service.adiciona(usuario);
	}

}
