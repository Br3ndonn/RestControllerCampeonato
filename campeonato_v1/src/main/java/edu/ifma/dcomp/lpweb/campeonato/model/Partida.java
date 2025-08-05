package edu.ifma.dcomp.lpweb.campeonato.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataPartida;

    @ManyToOne
    @JoinColumn(name = "campeonato_id", nullable = false)
    private Campeonato campeonato;

    @Embedded
    private Resultado resultado;

    @ManyToOne
    @JoinColumn(name = "time_mandante_id", nullable = false)
    private Time timeMandante;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id", nullable = false)
    private Time timeVisitante;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Time getTimeMandante() {
        return timeMandante;
    }

    public void setTimeMandante(Time timeMandante) {
        this.timeMandante = timeMandante;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(Time timeVisitante) {
        this.timeVisitante = timeVisitante;
    }
}
