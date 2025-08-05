package edu.ifma.dcomp.lpweb.campeonato.dto.output;

public class TabelaDTO {
    private String time;
    private Integer pontos;
    private Integer vitorias;
    private Integer empates;
    private Integer derrotas;
    private Integer golsPro;
    private Integer golsContra;
    private Integer saldoGols;
    private Integer jogos;

    // Construtores
    public TabelaDTO() {}

    public TabelaDTO(String time) {
        this.time = time;
        this.pontos = 0;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golsPro = 0;
        this.golsContra = 0;
        this.saldoGols = 0;
        this.jogos = 0;
    }

    // Getters e Setters
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(Integer golsPro) {
        this.golsPro = golsPro;
        calcularSaldoGols();
    }

    public Integer getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(Integer golsContra) {
        this.golsContra = golsContra;
        calcularSaldoGols();
    }

    public Integer getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(Integer saldoGols) {
        this.saldoGols = saldoGols;
    }

    public Integer getJogos() {
        return jogos;
    }

    public void setJogos(Integer jogos) {
        this.jogos = jogos;
    }

    // Métodos auxiliares
    private void calcularSaldoGols() {
        if (golsPro != null && golsContra != null) {
            this.saldoGols = golsPro - golsContra;
        }
    }

    public void calcularPontos() {
        this.pontos = (vitorias * 3) + empates;
    }

    public void calcularJogos() {
        this.jogos = vitorias + empates + derrotas;
    }
}
