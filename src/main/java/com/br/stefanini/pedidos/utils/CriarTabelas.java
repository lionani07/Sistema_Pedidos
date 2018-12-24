package com.br.stefanini.pedidos.utils;

import javax.persistence.Persistence;


public class CriarTabelas {

	public static void main(String[] args) {
		try {
			Persistence.createEntityManagerFactory("PedidosStefanini");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
