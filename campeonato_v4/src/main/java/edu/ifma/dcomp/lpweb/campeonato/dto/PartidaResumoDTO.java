package edu.ifma.dcomp.lpweb.campeonato.dto;

import java.time.LocalDate;

public class PartidaResumoDTO {
    private Integer id;
    private LocalDate dataPartida;
    private String timeMandanteNome;
    private String timeVisitanteNome;
    private ResultadoDTO resultado;

    // Construtores
    public PartidaResumoDTO() {}

    public PartidaResumoDTO(Integer id, LocalDate dataPartida, String timeMandanteNome, String timeVisitanteNome) {
        this.id = id;
        this.dataPartida = dataPartida;
        this.timeMandanteNome = timeMandanteNome;
        this.timeVisitanteNome = timeVisitanteNome;
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

    public String getTimeMandanteNome() {
        return timeMandanteNome;
    }

    public void setTimeMandanteNome(String timeMandanteNome) {
        this.timeMandanteNome = timeMandanteNome;
    }

    public String getTimeVisitanteNome() {
        return timeVisitanteNome;
    }

    public void setTimeVisitanteNome(String timeVisitanteNome) {
        this.timeVisitanteNome = timeVisitanteNome;
    }

    public ResultadoDTO getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoDTO resultado) {
        this.resultado = resultado;
    }
}
