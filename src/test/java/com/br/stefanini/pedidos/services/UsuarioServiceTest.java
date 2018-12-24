package com.br.stefanini.pedidos.services;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

import com.br.stefanini.pedidos.model.Usuario;

public class UsuarioServiceTest {
	
	
	@Test
	public void existeUsuarioTest() throws Exception{
		
		//cenario
		Usuario usuario =  new Usuario();
		usuario.setPeople("3");
		usuario.setEmail("lio@gmail.com");
		
		UsuarioService service = new UsuarioService();
		
		//acao
		boolean encontrado = service.existe(usuario);
		
		//Verificao
		Assert.assertThat(usuario.getEmail(), is("lio@gmail.com"));
		Assert.assertThat(true, is(encontrado));
		
		
	}
	
}
