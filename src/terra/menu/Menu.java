package terra.menu;

import terra.controller.ControleAlienigenas;

import java.util.Scanner;

import static terra.util.Util.*;

public class Menu {
    public static void main(String[] args) {
        ControleAlienigenas controle = new ControleAlienigenas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===================MENU==================");
            System.out.println("1. Registrar Alienígena");
            System.out.println("2. Registrar Espécie");
            System.out.println("3. Avaliar Periculosidade de Alienígena");
            System.out.println("4. Colocar Alienígena em Quarentena");
            System.out.println("5. Mostrar Relatório de Entradas de Alienígenas");
            System.out.println("6. Mostrar Ranking de Periculosidade");
            System.out.println("7. Listar Todas as Espécies");
            System.out.println("8. Listar Alienígenas em Quarentena");
            System.out.println("9. Mostrar Alienígenas de uma Espécie Específica");
            System.out.println("10. Mostrar Alienígenas que Entraram na Terra");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: \n");
            System.out.println("=========================================");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    registrarAlienigena(controle, scanner);
                    break;
                case 2:
                    registrarEspecie(controle, scanner);
                    break;
                case 3:
                    avaliarPericulosidade(controle, scanner);
                    break;
                case 4:
                    colocarEmQuarentena(controle, scanner);
                    break;
                case 5:
                    controle.mostrarRelatorioEntradas();
                    break;
                case 6:
                    mostrarRankingPericulosidade(controle);
                    break;
                case 7:
                    controle.listarTodasEspecies();
                    break;
                case 8:
                    controle.listarAlienigenasEmQuarentena();
                    break;
                case 9:
                    System.out.print("Digite o nome da Espécie: ");
                    String nomeEspecie = scanner.nextLine();
                    controle.listarAlienigenasPorEspecie(nomeEspecie);
                    break;
                case 10:
                    listarAlienigenasEntradaRecente(controle);
                    break;
                case 0:
                    System.out.println("Encerrando o programa. Até maixxxx!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
