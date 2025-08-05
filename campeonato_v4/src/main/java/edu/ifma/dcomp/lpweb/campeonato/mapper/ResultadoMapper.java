package edu.ifma.dcomp.lpweb.campeonato.mapper;

import edu.ifma.dcomp.lpweb.campeonato.dto.output.ResultadoDTO;
import edu.ifma.dcomp.lpweb.campeonato.model.Resultado;

public class ResultadoMapper {

    public static Resultado toEntity(ResultadoDTO dto) {
        if (dto == null) {
            return null;
        }

        Resultado resultado = new Resultado();
        resultado.setNumGolsMandante(dto.getNumGolsMandante());
        resultado.setNumGolsVisitante(dto.getNumGolsVisitante());
        
        return resultado;
    }

    public static ResultadoDTO toDTO(Resultado entity) {
        if (entity == null) {
            return null;
        }

        return new ResultadoDTO(
            entity.getNumGolsMandante(),
            entity.getNumGolsVisitante()
        );
    }

    public static void updateEntity(ResultadoDTO dto, Resultado entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setNumGolsMandante(dto.getNumGolsMandante());
        entity.setNumGolsVisitante(dto.getNumGolsVisitante());
    }
}
