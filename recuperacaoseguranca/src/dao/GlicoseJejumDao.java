package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javadb.FabricaDeConexoes;
import modelo.GlicoseJejum;

public class GlicoseJejumDao {
    private Connection con;

    public GlicoseJejumDao() throws SQLException {
        this.con = FabricaDeConexoes.getConnection();
    }

    public byte[] recuperarDadosCriptografados(int id) throws SQLException {
        String sql = "SELECT dados_criptografados FROM glicose_jejum WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getBytes("dados_criptografados");
            }
        }
        return null;
    }

    public void inserirGlicoseJejum(GlicoseJejum glicoseJejum) throws SQLException {
        String sql = "INSERT INTO glicose_jejum (dados_criptografados) VALUES (?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            byte[] dadosCriptografados = glicoseJejum.criptografar();
            stmt.setBytes(1, dadosCriptografados);
            stmt.executeUpdate();
        }
    }

    public GlicoseJejum obterGlicoseJejumPorId(int id) throws SQLException {
        String sql = "SELECT dados_criptografados FROM glicose_jejum WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] dadosCriptografados = rs.getBytes("dados_criptografados");
                return new GlicoseJejum(dadosCriptografados);
            }
        }
        return null;
    }
}
