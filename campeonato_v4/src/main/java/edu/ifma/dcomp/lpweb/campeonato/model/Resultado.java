package edu.ifma.dcomp.lpweb.campeonato.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Embeddable
public class Resultado {

    @NotBlank @Positive
    private Integer numGolsMandante;

    @NotBlank @Positive
    private Integer numGolsVisitante;

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
}


