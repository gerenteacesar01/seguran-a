package Main;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Scanner;

import dao.GlicoseJejumDao;
import dao.MedicoDao;
import dao.PacienteDao;
import dao.UsuarioDAO;
import dao.ValoresPadroesDao;
import modelo.GlicoseJejum;
import modelo.Medico;
import modelo.Paciente;
import modelo.Senha;
import modelo.Usuario;
import modelo.ValoresPadroes;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao = 0;

            while (opcao != 9) {
                exibirMenu();
                opcao = scanner.nextInt();
                scanner.nextLine(); 
                switch (opcao) {
                    case 1:
                        inserirUsuario(scanner);
                        break;
                    case 2:
                        inserirPaciente(scanner);
                        break;
                    case 3:
                        inserirMedico(scanner);
                        break;
                    case 4:
                        inserirValoresGlicoseJejum(scanner);
                        break;
                    case 5:
                        gerarSenha(scanner);
                        break;
                    case 6:
                        inserirValoresPadroes(scanner);
                        break;
                    case 7:
                        testarSenha(scanner);
                        break;
                    case 8:
                        descriptografarValoresGlicoseJejum(scanner);
                        break;
                    case 9:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                        break;
                }
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nSelecione o tipo de dado para inserir:");
        System.out.println("1. Inserir novo usuário");
        System.out.println("2. Inserir novo paciente");
        System.out.println("3. Inserir novo médico");
        System.out.println("4. Inserir valores de glicose em jejum");
        System.out.println("5. Gerar senha");
        System.out.println("6. Inserir valores padrões");
        System.out.println("7. Testar senha");
        System.out.println("8. Descriptografar os valores de glicose em jejum");
        System.out.println("9. Sair");
        System.out.print("Opção: ");
    }

    private static void inserirUsuario(Scanner scanner) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            System.out.println("Inserir novo usuário:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Login: ");
            String login = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            Usuario novoUsuario = new Usuario(0, nome, cpf, login, senha);
            usuarioDAO.inserirUsuario(novoUsuario);

           
            System.out.println("Usuário inserido no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void inserirPaciente(Scanner scanner) {
        try {
            PacienteDao pacienteDao = new PacienteDao();

            System.out.println("Inserir novo paciente:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            Paciente novoPaciente = new Paciente();
            novoPaciente.setNome(nome);
            novoPaciente.setEmail(email);
            novoPaciente.setEndereco(endereco);
            novoPaciente.setCpf(cpf);

            pacienteDao.inserirPaciente(novoPaciente);

            System.out.println("Paciente inserido no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir paciente no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void inserirMedico(Scanner scanner) {
        try {
            MedicoDao medicoDao = new MedicoDao();

            System.out.println("Inserir novo médico:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Especialidade: ");
            String especialidade = scanner.nextLine();

            Medico novoMedico = new Medico(0, nome, cpf, especialidade);
            medicoDao.inserirMedico(novoMedico);

            System.out.println("Médico inserido no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir médico no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void inserirValoresGlicoseJejum(Scanner scanner) {
        try {
            GlicoseJejumDao glicoseJejumDao = new GlicoseJejumDao();

            System.out.println("Inserir valores de glicose em jejum:");
            String dadosGlicose = scanner.nextLine();

            GlicoseJejum glicoseJejum = new GlicoseJejum(dadosGlicose.getBytes());
            byte[] dadosCriptografados = glicoseJejum.criptografar(); // Criptografa os dados antes de inserir no banco
            glicoseJejum.setDadosCriptografados(dadosCriptografados);

            glicoseJejumDao.inserirGlicoseJejum(glicoseJejum);

            System.out.println("Dados de glicose em jejum inseridos no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados de glicose em jejum no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void gerarSenha(Scanner scanner) {
        System.out.println("Gerar nova senha:");

        System.out.print("Comprimento da senha desejada: ");
        int comprimentoSenha = scanner.nextInt();
        scanner.nextLine(); 

        String novaSenha = Senha.gerarSenhaAleatoria(comprimentoSenha);
        System.out.println("Nova senha gerada: " + novaSenha);
    }
    
    private static void testarSenha(Scanner scanner) {
        System.out.println("Testar senha:");

        System.out.print("Digite o ID do usuário: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); 

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = null;

        try {
            usuario = usuarioDAO.obterUsuarioPorId(userId);
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o usuário: " + e.getMessage());
        }

        if (usuario != null) {
            System.out.print("Digite a senha a ser testada: ");
            String senhaDigitada = scanner.nextLine();

            if (usuario.verificarSenha(senhaDigitada)) {
                System.out.println("Senha correta!");
            } else {
                System.out.println("Senha incorreta!");
            }
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }
    
    
    private static void inserirValoresPadroes(Scanner scanner) {
        try {
            ValoresPadroesDao valoresPadroesDao = new ValoresPadroesDao();

            System.out.println("Inserir novos valores padrões:");
            System.out.print("Digite o valor limite mínimo: ");
            double valorLimiteMin = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite o valor limite máximo: ");
            double valorLimiteMax = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite a unidade: ");
            String unidade = scanner.nextLine();

            System.out.print("Digite o valor de referência: ");
            String valorReferencia = scanner.nextLine();

            ValoresPadroes valoresPadroes = new ValoresPadroes(valorLimiteMin, valorLimiteMax, unidade, valorReferencia);
            valoresPadroesDao.inserirValoresPadroes(valoresPadroes);

            System.out.println("Valores padrões inseridos no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir valores padrões no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
   // Não sei porque não está mostrando a mensagem original
    private static void descriptografarValoresGlicoseJejum(Scanner scanner) {
        try {
            GlicoseJejumDao glicoseJejumDao = new GlicoseJejumDao();

            System.out.println("Descriptografar valores de glicose em jejum:");
            System.out.print("Digite o ID dos dados de glicose em jejum: ");
            int idGlicoseJejum = scanner.nextInt();
            scanner.nextLine(); 

            GlicoseJejum glicoseJejum = glicoseJejumDao.obterGlicoseJejumPorId(idGlicoseJejum);

            byte[] dadosDescriptografados = glicoseJejum.descriptografar(glicoseJejum.getDadosCriptografados());

            String dadosDecifrados = new String(dadosDescriptografados, StandardCharsets.UTF_8);
            System.out.println("Dados de glicose em jejum descriptografados: " + dadosDecifrados);
        } catch (SQLException e) {
            System.out.println("Erro ao descriptografar dados de glicose em jejum: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
