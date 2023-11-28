package app;

import java.sql.SQLException;
import java.util.List;

import dao.ContatoDao;
import modelo.Paciente;

public class TesteListarContatos {
    public static void main(String[] args) {
        try {
            ContatoDao contatoDao = new ContatoDao();

            List<Paciente> contatos = contatoDao.listarContatos();

            System.out.println("Listando todos os contatos:");
            for (Paciente contato : contatos) {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println("CPF: " + contato.getCpf()); // Adicione esta linha para exibir o CPF
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
