package Terra.Controller;

import Terra.Model.Alien;
import Terra.Model.Especie;

import java.util.*;

public class ControleAlienigenas {
    private List<Alien> alienigenas;
    private List<Especie> especies;
    private Map<String, List<Alien>> planetas;

    public ControleAlienigenas() {
        this.alienigenas = new ArrayList<>();
        this.especies = new ArrayList<>();
        this.planetas = new HashMap<>();
    }

    public void registrarAlienigena(int id, String nome, double nivelPericulosidade, String dataHoraEntrada, String nomeEspecie) {
        Especie especie = encontrarEspeciePorNome(nomeEspecie);
        if (especie == null) {
            System.out.println("Espécie não registrada. Registre a espécie primeiro.");
        } else {
            if (!alienJaRegistrado(id)) {
                Alien alien = new Alien(id, nome, especie, nivelPericulosidade, dataHoraEntrada);
                alienigenas.add(alien);
                adicionarAlienAoPlaneta(alien, especie.getPlanetaDeOrigem());
                System.out.println("Alienígena " + nome + " registrado na Terra com sucesso!");
            } else {
                System.out.println("Nãnaninanão, esse alienígena já foi registrado.");
            }
        }
    }

    private boolean alienJaRegistrado(int id) {
        for (Alien a : alienigenas) {
            if (a.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void registrarEspecie(String nome, String planetaOrigem, int nivelPericulosidadeBase) {
        Especie especie = new Especie(nome, planetaOrigem, nivelPericulosidadeBase);
        if (!especies.contains(especie)) {
            especies.add(especie);
            System.out.println("Espécie " + nome + " registrada com sucesso!");
        } else {
            System.out.println("Essa espécie já foi registrada.");
        }
    }

    public void avaliarPericulosidade(int id) {
        Alien alien = encontrarAlienPorId(id);
        if (alien != null) {
            if (alien.getNivelDePericulosidade() > 7) {
                System.out.println("Alienígena " + alien.getNome() + " é perigoso!");
            } else {
                System.out.println("Alienígena " + alien.getNome() + " é seguro.");
            }
        } else {
            System.out.println("Alienígena não encontrado.");
        }
    }

    public List<Alien> getAlienigenasOrdenadosPorPericulosidade() {
        List<Alien> ranking = new ArrayList<>(alienigenas);
        ranking.sort((a1, a2) -> Double.compare(a2.getNivelDePericulosidade(), a1.getNivelDePericulosidade()));
        return ranking;
    }

    public void colocarEmQuarentena(int id) {

        Alien alien = encontrarAlienPorId(id);
        if (alien != null) {
            if (alien.getNivelDePericulosidade() > 5) {
                System.out.println("Alienígena " + alien.getNome() + " foi colocado na quarentena por mau comportamento.");
            } else {
                System.out.println("Alienígena " + alien.getNome() + " é bonzinho e não ficará na quarentena.");
            }
        } else {
            System.out.println("Alienígena não encontrado.");
        }
    }

    public void mostrarRelatorioEntradas() {
        System.out.println("=========================================");
        System.out.println("Relatório de Entradas de Alienígenas:");
        for (Alien alien : alienigenas) {
            System.out.println("ID: " + alien.getId());
            System.out.println("Nome: " + alien.getNome());
            System.out.println("Espécie: " + alien.getEspecie().getNome());
            System.out.println("Nível de Periculosidade: " + alien.getNivelDePericulosidade());
            System.out.println("Data/Hora de Entrada: " + alien.getDataHoraEntrada());
            System.out.println("Planeta de Origem: " + alien.getEspecie().getPlanetaDeOrigem());
            System.out.println("Nível de Periculosidade Base da Espécie: " + alien.getEspecie().getNivelDePericulosidadeBase());
            System.out.println("=========================================");
        }
    }


    public void listarTodasEspecies() {
        System.out.println("=========================================");
        System.out.println("Lista de Espécies:");
        for (Especie especie : especies) {
            System.out.println(especie.getNome() + " - Planeta de Origem: " + especie.getPlanetaDeOrigem());
        }
        System.out.println("=========================================");
    }

    public void listarAlienigenasEmQuarentena() {
        System.out.println("=========================================");
        System.out.println("Alienígenas em Quarentena:");
        for (Alien alien : alienigenas) {
            if (alien.getNivelDePericulosidade() > 5) {
                System.out.println(alien.getNome());
            }
        }
        System.out.println("=========================================");
    }

    public void listarAlienigenasPorEspecie(String nomeEspecie) {
        System.out.println("=========================================");
        System.out.println("Alienígenas da Espécie " + nomeEspecie + ":");
        boolean encontrou = false;
        for (Alien alien : alienigenas) {
            if (alien.getEspecie().getNome().equalsIgnoreCase(nomeEspecie)) {
                System.out.println(alien.getNome() + " - Nível de Periculosidade: " + alien.getNivelDePericulosidade());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum alienígena encontrado para a espécie " + nomeEspecie);
        }
        System.out.println("=========================================");
    }

    public void listarAlienigenasEntradaRecente() {
        System.out.println("=========================================");
        System.out.println("Alienígenas que entraram recentemente:");

        boolean encontrou = false;

        for (Alien alien : alienigenas) {
            System.out.println(alien.getNome() + " - Data de Entrada: " + alien.getDataHoraEntrada());
            encontrou = true;
        }

        if (!encontrou) {
            System.out.println("Nenhum alienígena encontrado recentemente.");
        }

        System.out.println("=========================================");
    }

    private void adicionarAlienAoPlaneta(Alien alien, String nomePlaneta) {
        if (!planetas.containsKey(nomePlaneta)) {
            planetas.put(nomePlaneta, new ArrayList<>());
        }
        planetas.get(nomePlaneta).add(alien);
    }

    public Alien encontrarAlienPorId(int id) {
        for (Alien a : alienigenas) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public Especie encontrarEspeciePorNome(String nome) {
        for (Especie e : especies) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                return e;
            }
        }
        return null;
    }
}
