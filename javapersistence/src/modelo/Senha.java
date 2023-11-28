package modelo;

import java.security.SecureRandom;

public class Senha {
    private String senha;

    public Senha(String senha) {
        this.senha = senha;
    }

    // Método para verificar a força da senha
    public String verificarForcaSenha() {
        // Lógica para verificar a força da senha, como por exemplo, verificar o comprimento, caracteres especiais, etc.
        // Implemente a lógica conforme necessário para suas exigências de segurança
        // Este exemplo é bem simples e pode ser expandido para incluir mais verificações

        if (senha.length() < 6) {
            return "Senha fraca: muito curta.";
        } else if (!senha.matches(".*[A-Z].*")) {
            return "Senha fraca: deve conter pelo menos uma letra maiúscula.";
        } else if (!senha.matches(".*[a-z].*")) {
            return "Senha fraca: deve conter pelo menos uma letra minúscula.";
        } else if (!senha.matches(".*\\d.*")) {
            return "Senha fraca: deve conter pelo menos um número.";
        } else {
            return "Senha forte!";
        }
    }

    // Método para gerar uma senha aleatória
    public static String gerarSenhaAleatoria(int comprimento) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(comprimento);

        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        return sb.toString();
    }

    // Getters e Setters
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
