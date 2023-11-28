package app;

import java.sql.SQLException;
import java.util.Scanner;
import dao.ContatoDao;
import modelo.Paciente;

public class TesteContatoPorId {
    public static void main(String[] args) {
        try {
            ContatoDao contatoDao = new ContatoDao();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID do contato que deseja buscar: ");
            int idContato = scanner.nextInt();

            Paciente contatoEncontrado = contatoDao.getContatoPorId(idContato);

            if (contatoEncontrado != null) {
                System.out.println("Contato encontrado:");
                System.out.println("ID: " + contatoEncontrado.getId());
                System.out.println("Nome: " + contatoEncontrado.getNome());
                System.out.println("Email: " + contatoEncontrado.getEmail());
                System.out.println("Endereço: " + contatoEncontrado.getEndereco());
                System.out.println("CPF: " + contatoEncontrado.getCpf()); // Adiciona esta linha para exibir o CPF
            } else {
                System.out.println("Contato não encontrado para o ID fornecido.");
            }

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
