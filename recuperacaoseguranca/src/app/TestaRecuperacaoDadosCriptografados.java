package app;

import dao.GlicoseJejumDao;

import java.sql.SQLException;
import java.util.Arrays;

public class TestaRecuperacaoDadosCriptografados {
    public static void main(String[] args) {
        try {
            GlicoseJejumDao dao = new GlicoseJejumDao();
            byte[] dadosCriptografados = dao.recuperarDadosCriptografados(1); 

            System.out.println("Dados criptografados recuperados: " + Arrays.toString(dadosCriptografados));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
