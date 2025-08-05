package edu.ifma.dcomp.lpweb.campeonato.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ResultadoDTO {

    @NotNull
    @PositiveOrZero(message = "Número de gols do mandante deve ser maior ou igual a zero")
    private Integer numGolsMandante;

    @NotNull
    @PositiveOrZero(message = "Número de gols do visitante deve ser maior ou igual a zero")
    private Integer numGolsVisitante;

    // Construtores
    public ResultadoDTO() {}

    public ResultadoDTO(Integer numGolsMandante, Integer numGolsVisitante) {
        this.numGolsMandante = numGolsMandante;
        this.numGolsVisitante = numGolsVisitante;
    }

    // Getters e Setters
    public Integer getNumGolsMandante() {
        return numGolsMandante;
    }

    public void setNumGolsMandante(Integer numGolsMandante) {
        this.numGolsMandante = numGolsMandante;
    }

    public Integer getNumGolsVisitante() {
        return numGolsVisitante;
    }

    public void setNumGolsVisitante(Integer numGolsVisitante) {
        this.numGolsVisitante = numGolsVisitante;
    }

    // Método para determinar o vencedor
    public String getVencedor() {
        if (numGolsMandante > numGolsVisitante) {
            return "MANDANTE";
        } else if (numGolsVisitante > numGolsMandante) {
            return "VISITANTE";
        } else {
            return "EMPATE";
        }
    }
}
