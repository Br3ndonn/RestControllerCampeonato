package edu.ifma.dcomp.lpweb.campeonato.dto;

import jakarta.validation.constraints.NotBlank;

public class EstadioDTO {
    private Integer id;

    @NotBlank(message = "Nome do estádio é obrigatório")
    private String nome;

    @NotBlank(message = "Endereço do estádio é obrigatório")
    private String endereco;

    private Integer timeId;
    private String timeNome;

    // Construtores
    public EstadioDTO() {}

    public EstadioDTO(Integer id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public String getTimeNome() {
        return timeNome;
    }

    public void setTimeNome(String timeNome) {
        this.timeNome = timeNome;
    }
}
