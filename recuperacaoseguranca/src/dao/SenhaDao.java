package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javadb.FabricaDeConexoes; 
import modelo.Senha;

public class SenhaDao {

    public void inserirSenha(Senha senha, int idUsuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            conexao = FabricaDeConexoes.getConnection();

            String sql = "INSERT INTO senha (chave_secreta, id_usuario) VALUES (?, ?)";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, senha.getSenha());
            pstmt.setInt(2, idUsuario);

            pstmt.executeUpdate();

            System.out.println("Senha inserida com sucesso no banco de dados!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao inserir senha no banco de dados: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

}
