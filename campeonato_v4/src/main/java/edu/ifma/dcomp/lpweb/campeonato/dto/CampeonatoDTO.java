package edu.ifma.dcomp.lpweb.campeonato.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class CampeonatoDTO {
    private Integer id;

    @NotBlank
    @Positive
    private Integer ano;

    @NotBlank(message = "Nome do campeonato é obrigatório")
    @Size(min = 5, max = 50, message = "Nome do campeonato deve ter entre 5 e 50 caracteres")
    private String nome;

    private Set<TimeResumoDTO> times;
    private Set<PartidaResumoDTO> partidas;

    // Construtores
    public CampeonatoDTO() {}

    public CampeonatoDTO(Integer id, Integer ano, String nome) {
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

    public Set<TimeResumoDTO> getTimes() {
        return times;
    }

    public void setTimes(Set<TimeResumoDTO> times) {
        this.times = times;
    }

    public Set<PartidaResumoDTO> getPartidas() {
        return partidas;
    }

    public void setPartidas(Set<PartidaResumoDTO> partidas) {
        this.partidas = partidas;
    }
}
