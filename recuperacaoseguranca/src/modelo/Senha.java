package modelo;

import java.security.SecureRandom;

public class Senha {
    private String senha;

    public Senha(String senha) {
        this.senha = senha;
    }

    
   
    

    
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

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
