package Terra.Model;

public class Especie {
    private String nome;
    private String planetaDeOrigem;
    private double nivelDePericulosidadeBase;

    public Especie(String nome, String planetaDeOrigem, double nivelDePericulosidadeBase) {
        this.nome = nome;
        this.planetaDeOrigem = planetaDeOrigem;
        this.nivelDePericulosidadeBase = nivelDePericulosidadeBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlanetaDeOrigem() {
        return planetaDeOrigem;
    }

    public void setPlanetaDeOrigem(String planetaDeOrigem) {
        this.planetaDeOrigem = planetaDeOrigem;
    }

    public double getNivelDePericulosidadeBase() {
        return nivelDePericulosidadeBase;
    }

    public void setNivelDePericulosidadeBase(double nivelDePericulosidadeBase) {
        this.nivelDePericulosidadeBase = nivelDePericulosidadeBase;
    }
}
