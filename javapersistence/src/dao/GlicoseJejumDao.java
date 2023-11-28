package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javadb.FabricaDeConexoes;

public class GlicoseJejumDao {
    private Connection con;

    public GlicoseJejumDao() throws SQLException {
        this.con = FabricaDeConexoes.getConnection();
    }

    public String recuperarDadosCriptografados(int id) throws SQLException {
        String sql = "SELECT dados_criptografados FROM glicose_jejum WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("dados_criptografados");
            }
        }
        return null;
    }
}
