package app;

import dao.ContatoDao;
import modelo.Paciente;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TesteContatosPorLetra {
    public static void main(String[] args) {
        try {
            ContatoDao contatoDao = new ContatoDao();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite a letra para pesquisar contatos: ");
            char letra = scanner.next().charAt(0);

            List<Paciente> contatosPorLetra = contatoDao.getContatosPorLetra(letra);

            // Exibindo os contatos cujos nomes começam com a letra escolhida
            for (Paciente contato : contatosPorLetra) {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println("CPF: " + contato.getCpf()); // Adicione esta linha para exibir o CPF
                System.out.println("-------------------------");
            }

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
