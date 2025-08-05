package edu.ifma.dcomp.lpweb.campeonato.mapper;

import edu.ifma.dcomp.lpweb.campeonato.dto.input.PartidaInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.PartidaDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.PartidaResumoDTO;
import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartidaMapper {

    public Partida toEntity(PartidaInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Partida partida = new Partida();
        partida.setDataPartida(dto.getDataPartida());
        
        if (dto.getResultado() != null) {
            partida.setResultado(ResultadoMapper.toEntity(dto.getResultado()));
        }
        
        return partida;
    }

    public PartidaDTO toDTO(Partida entity) {
        if (entity == null) {
            return null;
        }

        PartidaDTO dto = new PartidaDTO();
        dto.setId(entity.getId());
        dto.setDataPartida(entity.getDataPartida());
        
        if (entity.getCampeonato() != null) {
            dto.setCampeonatoId(entity.getCampeonato().getId());
            dto.setCampeonatoNome(entity.getCampeonato().getNome());
        }
        
        if (entity.getTimeMandante() != null) {
            dto.setTimeMandanteId(entity.getTimeMandante().getId());
            dto.setTimeMandanteNome(entity.getTimeMandante().getNome());
        }
        
        if (entity.getTimeVisitante() != null) {
            dto.setTimeVisitanteId(entity.getTimeVisitante().getId());
            dto.setTimeVisitanteNome(entity.getTimeVisitante().getNome());
        }
        
        if (entity.getResultado() != null) {
            dto.setResultado(ResultadoMapper.toDTO(entity.getResultado()));
        }
        
        return dto;
    }

    public PartidaResumoDTO toResumoDTO(Partida entity) {
        if (entity == null) {
            return null;
        }

        PartidaResumoDTO dto = new PartidaResumoDTO();
        dto.setId(entity.getId());
        dto.setDataPartida(entity.getDataPartida());
        
        if (entity.getTimeMandante() != null) {
            dto.setTimeMandanteNome(entity.getTimeMandante().getNome());
        }
        
        if (entity.getTimeVisitante() != null) {
            dto.setTimeVisitanteNome(entity.getTimeVisitante().getNome());
        }
        
        if (entity.getResultado() != null) {
            dto.setResultado(ResultadoMapper.toDTO(entity.getResultado()));
        }
        
        return dto;
    }

    public void updateEntity(PartidaInputDTO dto, Partida entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setDataPartida(dto.getDataPartida());
        
        if (dto.getResultado() != null) {
            entity.setResultado(ResultadoMapper.toEntity(dto.getResultado()));
        }
    }
    
    public List<PartidaDTO> toListDTO(List<Partida> partidas) {
        return partidas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
