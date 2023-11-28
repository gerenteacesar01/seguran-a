package Main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import dao.ContatoDao;
import dao.MedicoDao;
import dao.GlicoseJejumDao;
import modelo.Usuario;
import modelo.Paciente;
import modelo.Medico;

public class Main {

    private static void testarHashSenha() {
        Usuario usuario = new Usuario(0, "Nome", "123456789", "Especialidade", "usuario", "SenhaCriptografadaAqui");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite a senha para verificação: ");
            String senhaDigitada = scanner.nextLine();

            if (usuario.verificarSenha(senhaDigitada)) {
                System.out.println("Senha correta!");
            } else {
                System.out.println("Senha incorreta!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testarInsercaoContato() {
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
        }
    }

    private static void testarInsercaoMedico() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserindo novo médico:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        Medico novoMedico = new Medico(0, nome, cpf, especialidade);

        try {
            MedicoDao dao = new MedicoDao();
            dao.inserirMedico(novoMedico);
            System.out.println("Médico inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testarRecuperacaoDadosCriptografados() {
        try {
            GlicoseJejumDao dao = new GlicoseJejumDao();
            String dadosCriptografados = dao.recuperarDadosCriptografados(1); 

            System.out.println("Dados criptografados recuperados: " + dadosCriptografados);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testarSenhaUsuario() {
        Usuario usuario = new Usuario(1, "Exemplo", "123456789", "Especialidade", "usuario", "senha123");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua senha: ");
        String senhaDigitada = scanner.nextLine();

        if (usuario.verificarSenha(senhaDigitada)) {
            System.out.println("Senha correta!");
        } else {
            System.out.println("Senha incorreta!");
        }
    }

    private static void testarContatoPorId() {
        try {
            ContatoDao contatoDao = new ContatoDao();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID do contato que deseja buscar: ");
            int idContato = scanner.nextInt();
            scanner.nextLine(); 

            Paciente contatoEncontrado = contatoDao.getContatoPorId(idContato);

            if (contatoEncontrado != null) {
                System.out.println("Contato encontrado:");
                System.out.println("ID: " + contatoEncontrado.getId());
                System.out.println("Nome: " + contatoEncontrado.getNome());
                System.out.println("Email: " + contatoEncontrado.getEmail());
                System.out.println("Endereço: " + contatoEncontrado.getEndereco());
                System.out.println("CPF: " + contatoEncontrado.getCpf());
            } else {
                System.out.println("Contato não encontrado para o ID fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testarContatosPorLetra() {
        try {
            ContatoDao contatoDao = new ContatoDao();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite a letra para pesquisar contatos: ");
            char letra = scanner.nextLine().charAt(0);
            scanner.nextLine(); 

            List<Paciente> contatosPorLetra = contatoDao.getContatosPorLetra(letra);

            for (Paciente contato : contatosPorLetra) {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println("CPF: " + contato.getCpf());
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testarListarContatos() {
        try {
            ContatoDao contatoDao = new ContatoDao();

            List<Paciente> contatos = contatoDao.listarContatos();

            System.out.println("Listando todos os contatos:");
            for (Paciente contato : contatos) {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println("CPF: " + contato.getCpf());
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("Selecione a operação que deseja realizar:");
            System.out.println("1. Testar Hash de Senha");
            System.out.println("2. Testar Inserção de Contato");
            System.out.println("3. Testar Inserção de Médico");
            System.out.println("4. Testar Recuperação de Dados Criptografados");
            System.out.println("5. Testar Verificação de Senha de Usuário");
            System.out.println("6. Testar Contato por ID");
            System.out.println("7. Testar Contatos por Letra");
            System.out.println("8. Testar Listar Contatos");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    testarHashSenha();
                    break;
                case 2:
                    testarInsercaoContato();
                    break;
                case 3:
                    testarInsercaoMedico();
                    break;
                case 4:
                    testarRecuperacaoDadosCriptografados();
                    break;
                case 5:
                    testarSenhaUsuario();
                    break;
                case 6:
                    testarContatoPorId();
                    break;
                case 7:
                    testarContatosPorLetra();
                    break;
                case 8:
                    testarListarContatos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close(); 
    }
}
