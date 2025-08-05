package edu.ifma.dcomp.lpweb.campeonato.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class JogadorInputDTO {

    @NotBlank(message = "Nome do jogador é obrigatório")
    @Size(min = 2, max = 50, message = "Nome do jogador deve ter entre 2 e 50 caracteres")
    private String nome;

    private LocalDate nascimento;
    private String genero;

    @Positive
    private Float altura;

    @NotNull(message = "ID do time é obrigatório")
    private Integer timeId;

    // Construtores
    public JogadorInputDTO() {}

    public JogadorInputDTO(String nome, LocalDate nascimento, String genero, Float altura, Integer timeId) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.genero = genero;
        this.altura = altura;
        this.timeId = timeId;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }
}
