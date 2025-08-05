package edu.ifma.dcomp.lpweb.campeonato.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstadioInputDTO {

    @NotBlank(message = "Nome do estádio é obrigatório")
    private String nome;

    @NotBlank(message = "Endereço do estádio é obrigatório")
    private String endereco;

    @NotNull(message = "ID do time é obrigatório")
    private Integer timeId;

    // Construtores
    public EstadioInputDTO() {}

    public EstadioInputDTO(String nome, String endereco, Integer timeId) {
        this.nome = nome;
        this.endereco = endereco;
        this.timeId = timeId;
    }

    // Getters e Setters
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
}
