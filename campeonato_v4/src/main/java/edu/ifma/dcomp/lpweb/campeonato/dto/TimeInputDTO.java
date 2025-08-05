package edu.ifma.dcomp.lpweb.campeonato.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TimeInputDTO {

    @NotBlank(message = "Nome do time é obrigatório")
    @Size(min = 3, max = 25, message = "Nome do time deve ter entre 3 e 25 caracteres")
    private String nome;

    // Construtores
    public TimeInputDTO() {}

    public TimeInputDTO(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
