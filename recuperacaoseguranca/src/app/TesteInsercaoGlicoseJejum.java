package app;

import java.sql.SQLException;
import java.util.Scanner;
import modelo.GlicoseJejum;
import dao.GlicoseJejumDao;

public class TesteInsercaoGlicoseJejum {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Inserindo novo registro na tabela glicose_jejum:");

            System.out.print("Digite os dados criptografados (em bytes): ");
            byte[] dadosCriptografados = scanner.next().getBytes(); // Capturando como bytes
            scanner.nextLine(); 

            GlicoseJejum glicoseJejum = new GlicoseJejum(dadosCriptografados);

            
            try {
                GlicoseJejumDao glicoseJejumDao = new GlicoseJejumDao();
                glicoseJejumDao.inserirGlicoseJejum(glicoseJejum);
                System.out.println("Dados inseridos na tabela glicose_jejum com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erro ao inserir dados na tabela glicose_jejum: " + e.getMessage());
            }
        }
    }
}
