package com.br.stefanini.pedidos.controllers;

import java.util.List;

import com.br.stefanini.pedidos.converters.UsuarioConverter;
import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.repository.UsuarioRepository;
import com.br.stefanini.pedidos.services.UsuarioService;


public class ProdutoControllerTest {	

	public static UsuarioService service;
	public static UsuarioRepository repository;
	
	public static void main(String[] args) throws Exception{
		
		service = new UsuarioService();
		repository = new UsuarioRepository();
		
		Usuario novo = new Usuario();
		novo.setPeople("5");
		novo.setEmail("5");
		
		
		List<Usuario> usuarios = repository.existe(novo);
	
		
		for(Usuario u : usuarios){
			System.out.println(u.getId());
		}
		
		
		
		
		
		
		
	}
	
	

	
}
