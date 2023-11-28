package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javadb.FabricaDeConexoes;

public class JdbcInsere {
    public static void main(String[] args) {
        try {
            Connection con = FabricaDeConexoes.getConnection();
            String sql = "insert into dados (nome, email, endereco) values (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite o nome:");
            String nome = sc.nextLine();

            System.out.println("Digite o email:");
            String email = sc.nextLine();

            System.out.println("Digite o endereço:");
            String endereco = sc.nextLine();

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, endereco);
            stmt.execute();
            stmt.close();
            System.out.println("Gravação feita com sucesso!");
            con.close();
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
