package terra.model;

public class Alien {

    private int id;
    private String nome;
    private Especie especie;
    private double nivelDePericulosidade;
    private String dataHoraEntrada;

    public Alien(int id, String nome, Especie especie, double nivelDePericulosidade, String dataHoraEntrada) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.nivelDePericulosidade = nivelDePericulosidade;
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public double getNivelDePericulosidade() {
        return nivelDePericulosidade;
    }

    public void setNivelDePericulosidade(double nivelDePericulosidade) {
        this.nivelDePericulosidade = nivelDePericulosidade;
    }

    public String getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(String dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }
}
