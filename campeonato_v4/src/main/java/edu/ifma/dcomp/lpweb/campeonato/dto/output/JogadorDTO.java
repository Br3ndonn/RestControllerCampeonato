package edu.ifma.dcomp.lpweb.campeonato.dto.output;

import java.time.LocalDate;

public class JogadorDTO {
    private Integer id;
    private String nome;
    private LocalDate nascimento;
    private String genero;
    private Float altura;
    private Integer timeId;
    private String timeNome;

    // Construtores
    public JogadorDTO() {}

    public JogadorDTO(Integer id, String nome, LocalDate nascimento, String genero, Float altura) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.genero = genero;
        this.altura = altura;
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

    public String getTimeNome() {
        return timeNome;
    }

    public void setTimeNome(String timeNome) {
        this.timeNome = timeNome;
    }
}
