package app;

import java.sql.SQLException;
import java.util.Scanner;

import dao.MedicoDao;
import modelo.Medico;

public class TestaInsercaoMedico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserindo novo médico:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        Medico novoMedico = new Medico(0, especialidade, especialidade, especialidade);
        novoMedico.setNome(nome);
        novoMedico.setCpf(cpf);
        novoMedico.setEspecialidade(especialidade);

        try {
            MedicoDao dao = new MedicoDao();
            dao.inserirMedico(novoMedico);
            System.out.println("Médico inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
