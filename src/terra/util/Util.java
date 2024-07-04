package terra.util;

import terra.controller.ControleAlienigenas;
import terra.model.Alien;

import java.util.List;
import java.util.Scanner;

public class Util {

    public static void registrarAlienigena(ControleAlienigenas controle, Scanner scanner) {
        System.out.print("Digite o ID do Alienígena: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome do Alienígena: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o nível de periculosidade do Alienígena: ");
        double nivelPericulosidade = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Digite a data e hora de entrada do Alienígena (dd/MM/yyyy HH:mm): ");
        String dataHoraEntrada = scanner.nextLine();
        System.out.print("Digite o nome da Espécie do Alienígena: ");
        String nomeEspecie = scanner.nextLine();

        controle.registrarAlienigena(id, nome, nivelPericulosidade, dataHoraEntrada, nomeEspecie);
    }

    public static void registrarEspecie(ControleAlienigenas controle, Scanner scanner) {
        System.out.print("Digite o nome da Espécie: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o planeta de origem da Espécie: ");
        String planetaOrigem = scanner.nextLine();
        System.out.print("Digite o nível de periculosidade base da Espécie: ");
        int nivelPericulosidadeBase = scanner.nextInt();
        scanner.nextLine();

        controle.registrarEspecie(nome, planetaOrigem, nivelPericulosidadeBase);
    }

    public static void avaliarPericulosidade(ControleAlienigenas controle, Scanner scanner) {
        System.out.print("Digite o ID do Alienígena para avaliar periculosidade: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        controle.avaliarPericulosidade(id);
    }

    public static void colocarEmQuarentena(ControleAlienigenas controle, Scanner scanner) {
        System.out.print("Digite o ID do Alienígena para colocar em quarentena: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        controle.colocarEmQuarentena(id);
    }

    public static void mostrarRankingPericulosidade(ControleAlienigenas controle) {
        List<Alien> ranking = controle.getAlienigenasOrdenadosPorPericulosidade();

        System.out.println("=== Ranking de Periculosidade ===");
        for (Alien alien : ranking) {
            System.out.println("Nome: " + alien.getNome() + ", Nível de Periculosidade: " + alien.getNivelDePericulosidade());
        }
    }

    public static void listarAlienigenasEntradaRecente(ControleAlienigenas controle) {
        controle.listarAlienigenasEntradaRecente();
    }
}
