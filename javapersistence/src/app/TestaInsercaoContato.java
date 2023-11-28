package app;

import dao.ContatoDao;
import modelo.Paciente;

import java.sql.SQLException;
import java.util.Scanner;

public class TestaInsercaoContato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserindo novo contato:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Paciente novoContato = new Paciente();
        novoContato.setNome(nome);
        novoContato.setEmail(email);
        novoContato.setEndereco(endereco);
        novoContato.setCpf(cpf);

        try {
            ContatoDao dao = new ContatoDao();
            dao.inserirContato(novoContato);
            System.out.println("Contato inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
