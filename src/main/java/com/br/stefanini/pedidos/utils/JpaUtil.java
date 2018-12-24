package com.br.stefanini.pedidos.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory factory;

	static {
		try {
			if(factory==null){
				factory = Persistence.createEntityManagerFactory("PedidosStefanini");
			}								
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	public static EntityManager getEntityManager() throws Exception {
		try {
			return factory.createEntityManager();
		} catch (Exception e) {
			throw new Exception("Error de conexion");
		}

	}
	
	public static void fecharConexao(){
		if(factory!=null){
			factory.close();
		}
	}

}