package app;

import dao.UsuarioDAO;
import modelo.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class TestaSenhaUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do usuário para testar a senha: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); 

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = null;

        try {
            usuario = usuarioDAO.obterUsuarioPorId(userId);
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o usuário: " + e.getMessage());
        }

        if (usuario != null) {
            System.out.print("Digite a senha a ser testada: ");
            String senhaDigitada = scanner.nextLine();

            if (usuario.verificarSenha(senhaDigitada)) {
                System.out.println("Senha correta!");
            } else {
                System.out.println("Senha incorreta!");
            }
        } else {
            System.out.println("Usuário não encontrado!");
        }

        scanner.close();
    }
}
