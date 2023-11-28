package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String especialidade;
    private String login;
    private String senha; // A senha será armazenada criptografada

    public Usuario(int id, String nome, String cpf, String especialidade, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.login = login;
        if (senha != null) {
            this.senha = criptografarSenha(senha); // Armazenando a senha criptografada ao criar o objeto
        } else {
            this.senha = null; // Ou defina uma senha padrão, dependendo da lógica desejada
        }
    }

    // Getters e Setters para os campos

    // ... (outros métodos getter e setter)

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = criptografarSenha(senha); // Criptografar e definir a senha
    }

    // Métodos para manipulação de senha
    public boolean verificarSenha(String senha) {
        return this.senha.equals(criptografarSenha(senha));
    }

    private String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return senha; // Em caso de erro, retornar a senha original
        }
    }
}
