package edu.ifma.dcomp.lpweb.campeonato.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Resultado {
    private Integer numGolsMandante;
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


