package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javadb.FabricaDeConexoes;
import modelo.Medico;

public class MedicoDao {
    private Connection con;

    public MedicoDao() throws SQLException {
        this.con = FabricaDeConexoes.getConnection();
    }

    public void inserirMedico(Medico medico) throws SQLException {
        String sql = "INSERT INTO medico (nome, cpf, especialidade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCpf());
            stmt.setString(3, medico.getEspecialidade());
            stmt.executeUpdate();
        }
    }

}
