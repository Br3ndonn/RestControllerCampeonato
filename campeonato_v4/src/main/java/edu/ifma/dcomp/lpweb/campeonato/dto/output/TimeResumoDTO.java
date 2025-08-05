package edu.ifma.dcomp.lpweb.campeonato.dto.output;

public class TimeResumoDTO {
    private Integer id;
    private String nome;

    // Construtores
    public TimeResumoDTO() {}

    public TimeResumoDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
