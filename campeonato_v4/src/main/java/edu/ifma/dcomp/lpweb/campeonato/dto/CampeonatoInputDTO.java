package edu.ifma.dcomp.lpweb.campeonato.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CampeonatoInputDTO {

    @NotBlank
    @Positive
    private Integer ano;

    @NotBlank(message = "Nome do campeonato é obrigatório")
    @Size(min = 5, max = 50, message = "Nome do campeonato deve ter entre 5 e 50 caracteres")
    private String nome;

    // Construtores
    public CampeonatoInputDTO() {}

    public CampeonatoInputDTO(Integer ano, String nome) {
        this.ano = ano;
        this.nome = nome;
    }

    // Getters e Setters
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
