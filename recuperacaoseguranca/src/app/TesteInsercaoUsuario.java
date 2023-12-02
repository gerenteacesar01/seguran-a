package app;
import java.sql.SQLException;
import java.util.Scanner;

import modelo.Usuario;
import dao.UsuarioDAO;

public class TesteInsercaoUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("Inserindo novo usuário:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(0, nome, cpf, login, senha);

        try {
            usuarioDAO.inserirUsuario(novoUsuario);
            System.out.println("Usuário inserido no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário no banco de dados: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
