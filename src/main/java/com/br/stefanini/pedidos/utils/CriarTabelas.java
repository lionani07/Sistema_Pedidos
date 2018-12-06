package com.br.stefanini.pedidos.utils;


public class CriarTabelas {

	public static void main(String[] args) {
		try {
			JpaUtil.getEntityManager();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
