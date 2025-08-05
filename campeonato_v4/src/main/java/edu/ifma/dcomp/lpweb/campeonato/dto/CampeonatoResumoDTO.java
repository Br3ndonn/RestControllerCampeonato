package edu.ifma.dcomp.lpweb.campeonato.dto;

public class CampeonatoResumoDTO {
    private Integer id;
    private Integer ano;
    private String nome;

    // Construtores
    public CampeonatoResumoDTO() {}

    public CampeonatoResumoDTO(Integer id, Integer ano, String nome) {
        this.id = id;
        this.ano = ano;
        this.nome = nome;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
