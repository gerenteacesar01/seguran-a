package app;

import dao.GlicoseJejumDao;
// Criptografia feita direta pelo banco
import java.sql.SQLException;

public class TestaRecuperacaoDadosCriptografados {
    public static void main(String[] args) {
        try {
            GlicoseJejumDao dao = new GlicoseJejumDao();
            String dadosCriptografados = dao.recuperarDadosCriptografados(1); // Substitua 1 pelo ID do exame inserido

            System.out.println("Dados criptografados recuperados: " + dadosCriptografados);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
