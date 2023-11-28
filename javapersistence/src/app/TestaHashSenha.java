package app;

import modelo.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestaHashSenha {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(0, null, null, null, null, null);
        usuario.setSenha("SenhaCriptografadaAqui"); // Defina a senha do usuário (já criptografada)

        String senhaDigitada = "senha123"; // Senha digitada pelo usuário
        boolean senhaCorreta = usuario.verificarSenha(senhaDigitada);

        if (senhaCorreta) {
            System.out.println("Senha correta!");
        } else {
            System.out.println("Senha incorreta!");
        }
    }
}
