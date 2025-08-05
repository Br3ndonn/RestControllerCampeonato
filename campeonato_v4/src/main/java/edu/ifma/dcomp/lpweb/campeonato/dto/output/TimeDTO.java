package edu.ifma.dcomp.lpweb.campeonato.dto.output;

import java.util.Set;

public class TimeDTO {
    private Integer id;
    private String nome;
    private EstadioDTO estadio;
    private Set<JogadorDTO> jogadores;

    // Construtores
    public TimeDTO() {}

    public TimeDTO(Integer id, String nome) {
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

    public EstadioDTO getEstadio() {
        return estadio;
    }

    public void setEstadio(EstadioDTO estadio) {
        this.estadio = estadio;
    }

    public Set<JogadorDTO> getJogadores() {
        return jogadores;
    }

    public void setJogadores(Set<JogadorDTO> jogadores) {
        this.jogadores = jogadores;
    }
}
