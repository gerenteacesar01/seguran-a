package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String login;
    private String senhaHash; 
    public Usuario(int id, String nome, String cpf, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        if (senha != null) {
            this.senhaHash = criptografarSenha(senha); 
        }
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenha(String senha) {
        this.senhaHash = criptografarSenha(senha);     }

    public boolean verificarSenha(String senha) {
        String senhaCriptografada = criptografarSenha(senha);
        return this.senhaHash.equals(senhaCriptografada);
    }

    private String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(senha.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return senha;
        }
    }

}
