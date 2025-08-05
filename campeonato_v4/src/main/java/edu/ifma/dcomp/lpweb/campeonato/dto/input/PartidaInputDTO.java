package edu.ifma.dcomp.lpweb.campeonato.dto.input;

import edu.ifma.dcomp.lpweb.campeonato.dto.output.ResultadoDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PartidaInputDTO {

    @NotNull(message = "Data da partida é obrigatória")
    private LocalDate dataPartida;

    @NotNull(message = "ID do campeonato é obrigatório")
    private Integer campeonatoId;

    private ResultadoDTO resultado;

    @NotNull(message = "ID do time mandante é obrigatório")
    private Integer timeMandanteId;

    @NotNull(message = "ID do time visitante é obrigatório")
    private Integer timeVisitanteId;

    // Construtores
    public PartidaInputDTO() {}

    public PartidaInputDTO(LocalDate dataPartida, Integer campeonatoId, Integer timeMandanteId, Integer timeVisitanteId) {
        this.dataPartida = dataPartida;
        this.campeonatoId = campeonatoId;
        this.timeMandanteId = timeMandanteId;
        this.timeVisitanteId = timeVisitanteId;
    }

    // Getters e Setters
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

    public Integer getTimeVisitanteId() {
        return timeVisitanteId;
    }

    public void setTimeVisitanteId(Integer timeVisitanteId) {
        this.timeVisitanteId = timeVisitanteId;
    }
}
