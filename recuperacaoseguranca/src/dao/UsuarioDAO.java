package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javadb.FabricaDeConexoes; 
import modelo.Usuario;

public class UsuarioDAO {

    public void inserirUsuario(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            conexao = FabricaDeConexoes.getConnection(); 

            String sql = "INSERT INTO usuario (nome, cpf, login, senha_hash) VALUES (?, ?, ?, ?)";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getCpf());
            pstmt.setString(3, usuario.getLogin());
            pstmt.setString(4, usuario.getSenhaHash());

            pstmt.executeUpdate();

            System.out.println("Usuário inserido com sucesso no banco de dados!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao inserir usuário no banco de dados: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    public Usuario obterUsuarioPorLogin(String login) throws SQLException {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conexao = FabricaDeConexoes.getConnection(); 
            String sql = "SELECT * FROM usuario WHERE login = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, login);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("login"),
                        rs.getString("senha_hash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao buscar usuário no banco de dados: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
        return usuario;
    }

    public Usuario obterUsuarioPorId(int id) throws SQLException {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conexao = FabricaDeConexoes.getConnection(); 

            String sql = "SELECT * FROM usuario WHERE id = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("login"),
                        rs.getString("senha_hash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao buscar usuário por ID no banco de dados: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
        return usuario;
    }
}
