package com.br.stefanini.pedidos.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConexionJasper {
	
	static Connection con = null;

	public static Connection conectar() {
		

		try {
			String url = "jdbc:mysql://localhost:3306/cipoalaernn?user=root";
			con = (Connection) DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conexion Satisfactoria");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}	
	
	
	public static void fecharConexao(){
		if(con !=null){
			try {
				con.close();
				System.out.println("Conexion Fechada");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
