package app;

import java.sql.SQLException;
import java.util.Scanner;

import dao.ValoresPadroesDao;
import modelo.ValoresPadroes;

public class TesteInsercaoValoresPadroes {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Inserindo novo registro na tabela valorespadroes:");

            System.out.print("Digite o valor limite mínimo: ");
            double valorLimiteMin = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite o valor limite máximo: ");
            double valorLimiteMax = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite a unidade: ");
            String unidade = scanner.nextLine();

            System.out.print("Digite o valor de referência: ");
            String valorReferencia = scanner.nextLine();

            ValoresPadroes valoresPadroes = new ValoresPadroes(valorLimiteMin, valorLimiteMax, unidade, valorReferencia);

           
            try {
                ValoresPadroesDao valoresPadroesDao = new ValoresPadroesDao();
                valoresPadroesDao.inserirValoresPadroes(valoresPadroes);
                System.out.println("Dados inseridos na tabela valorespadroes com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erro ao inserir dados na tabela valorespadroes: " + e.getMessage());
            }
        }
    }
}
