package app;

import modelo.Usuario;

import java.util.Scanner;

public class TestaSenhaUsuario {
    public static void main(String[] args) {
        // Suponha que você já tenha um usuário criado com uma senha definida
        Usuario usuario = new Usuario(1, "Exemplo", "123456789", "Especialidade", "usuario", "senha123");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua senha: ");
        String senhaDigitada = scanner.nextLine();

        if (usuario.verificarSenha(senhaDigitada)) {
            System.out.println("Senha correta!");
        } else {
            System.out.println("Senha incorreta!");
        }

        scanner.close();
    }
}
