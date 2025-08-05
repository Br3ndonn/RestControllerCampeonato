package edu.ifma.dcomp.lpweb.campeonato.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PartidaDTO {
    private Integer id;

    @NotNull(message = "Data da partida é obrigatória")
    private LocalDate dataPartida;

    private Integer campeonatoId;
    private String campeonatoNome;

    private ResultadoDTO resultado;

    @NotNull(message = "Time mandante é obrigatório")
    private Integer timeMandanteId;
    private String timeMandanteNome;

    @NotNull(message = "Time visitante é obrigatório")
    private Integer timeVisitanteId;
    private String timeVisitanteNome;

    // Construtores
    public PartidaDTO() {}

    public PartidaDTO(Integer id, LocalDate dataPartida, Integer timeMandanteId, Integer timeVisitanteId) {
        this.id = id;
        this.dataPartida = dataPartida;
        this.timeMandanteId = timeMandanteId;
        this.timeVisitanteId = timeVisitanteId;
    }

    // Getters e Setters
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

    public Integer getCampeonatoId() {
        return campeonatoId;
    }

    public void setCampeonatoId(Integer campeonatoId) {
        this.campeonatoId = campeonatoId;
    }

    public String getCampeonatoNome() {
        return campeonatoNome;
    }

    public void setCampeonatoNome(String campeonatoNome) {
        this.campeonatoNome = campeonatoNome;
    }

    public ResultadoDTO getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoDTO resultado) {
        this.resultado = resultado;
    }

    public Integer getTimeMandanteId() {
        return timeMandanteId;
    }

    public void setTimeMandanteId(Integer timeMandanteId) {
        this.timeMandanteId = timeMandanteId;
    }

    public String getTimeMandanteNome() {
        return timeMandanteNome;
    }

    public void setTimeMandanteNome(String timeMandanteNome) {
        this.timeMandanteNome = timeMandanteNome;
    }

    public Integer getTimeVisitanteId() {
        return timeVisitanteId;
    }

    public void setTimeVisitanteId(Integer timeVisitanteId) {
        this.timeVisitanteId = timeVisitanteId;
    }

    public String getTimeVisitanteNome() {
        return timeVisitanteNome;
    }

    public void setTimeVisitanteNome(String timeVisitanteNome) {
        this.timeVisitanteNome = timeVisitanteNome;
    }
}
