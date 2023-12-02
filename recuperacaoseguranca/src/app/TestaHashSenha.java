package app;

import modelo.Usuario;

public class TestaHashSenha {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Nome", "123456789", "login", "senhaCriptografadaAqui");

        String senhaDigitada = "senha123"; 
        boolean senhaCorreta = usuario.verificarSenha(senhaDigitada);

        if (senhaCorreta) {
            System.out.println("Senha correta!");
        } else {
            System.out.println("Senha incorreta!");
        }
    }
}
