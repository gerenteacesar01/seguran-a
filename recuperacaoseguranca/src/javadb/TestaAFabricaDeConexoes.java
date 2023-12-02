package javadb;

import java.sql.SQLException;
import java.sql.Connection;

public class TestaAFabricaDeConexoes {
	public static void main(String[] args) {
		try {
			Connection con = FabricaDeConexoes.getConnection();
			System.out.println("Conectado ao banco de dados");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
