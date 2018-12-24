package com.br.stefanini.pedidos.utils;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.model.enums.Rol;
import com.br.stefanini.pedidos.services.UsuarioService;

public class UserCreador {

	public static void main(String[] args) throws Exception {
		UsuarioService service = new UsuarioService();
		Usuario usuario = new Usuario();
		usuario.setPeople("000000");
		usuario.setNome("Lio");
		usuario.setRol(Rol.ADMIN);
		usuario.setEmail("douglas@aernnova.com");
		service.adiciona(usuario);
	}

}
