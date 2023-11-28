package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javadb.FabricaDeConexoes;
import modelo.Paciente;

public class ContatoDao {
    private Connection con;

    public ContatoDao() throws SQLException {
        this.con = FabricaDeConexoes.getConnection();
    }

    public void inserirContato(Paciente contato) throws SQLException {
        String sql = "INSERT INTO paciente (nome, email, endereco, cpf) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setString(4, contato.getCpf());
            stmt.executeUpdate();
        }
    }

    public List<Paciente> listarContatos() throws SQLException {
        List<Paciente> contatos = new ArrayList<>();
        String sql = "SELECT * FROM paciente";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente contato = new Paciente();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setCpf(rs.getString("cpf"));

                contatos.add(contato);
            }
        }

        return contatos;
    }

    public Paciente getContatoPorId(int id) throws SQLException {
        String sql = "SELECT * FROM paciente WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Paciente contato = new Paciente();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setCpf(rs.getString("cpf"));

                return contato;
            }
        }

        return null;
    }

    public List<Paciente> getContatosPorLetra(char letra) throws SQLException {
        List<Paciente> contatos = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE nome LIKE ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, letra + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente contato = new Paciente();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setCpf(rs.getString("cpf"));

                contatos.add(contato);
            }
        }

        return contatos;
    }
}
