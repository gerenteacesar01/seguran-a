package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTeste {
	public static void main(String[] args){
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/contatos","root","alex2003");
			System.out.println("Conectado ao banco de dados acima");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}