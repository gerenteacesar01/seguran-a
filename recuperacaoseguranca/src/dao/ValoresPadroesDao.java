package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javadb.FabricaDeConexoes;
import modelo.ValoresPadroes;

public class ValoresPadroesDao {
    private Connection con;

    public ValoresPadroesDao() throws SQLException {
        this.con = FabricaDeConexoes.getConnection();
    }

    public void inserirValoresPadroes(ValoresPadroes valoresPadroes) throws SQLException {
        String sql = "INSERT INTO valorespadroes (valor_limite_min, valor_limite_max, unidade, valor_referencia) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDouble(1, valoresPadroes.getValorLimiteMin());
            stmt.setDouble(2, valoresPadroes.getValorLimiteMax());
            stmt.setString(3, valoresPadroes.getUnidade());
            stmt.setString(4, valoresPadroes.getValorReferencia());
            stmt.executeUpdate();
        }
    }
}
