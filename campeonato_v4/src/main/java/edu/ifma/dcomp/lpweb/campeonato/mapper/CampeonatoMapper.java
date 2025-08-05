package edu.ifma.dcomp.lpweb.campeonato.mapper;

import edu.ifma.dcomp.lpweb.campeonato.dto.input.CampeonatoInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.CampeonatoDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.CampeonatoResumoDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.PartidaResumoDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.TimeResumoDTO;
import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;
import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CampeonatoMapper {

    public Campeonato toEntity(CampeonatoInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Campeonato campeonato = new Campeonato();
        campeonato.setAno(dto.getAno());
        campeonato.setNome(dto.getNome());
        
        return campeonato;
    }

    public CampeonatoDTO toDTO(Campeonato entity) {
        if (entity == null) {
            return null;
        }

        CampeonatoDTO dto = new CampeonatoDTO();
        dto.setId(entity.getId());
        dto.setAno(entity.getAno());
        dto.setNome(entity.getNome());
        
        if (entity.getTimes() != null) {
            dto.setTimes(toTimeResumoDTO(entity.getTimes()));
        }
        
        if (entity.getPartidas() != null) {
            dto.setPartidas(toPartidaResumoDTO(entity.getPartidas()));
        }
        
        return dto;
    }

    public CampeonatoResumoDTO toResumoDTO(Campeonato entity) {
        if (entity == null) {
            return null;
        }

        return new CampeonatoResumoDTO(
            entity.getId(),
            entity.getAno(),
            entity.getNome()
        );
    }

    public void updateEntity(CampeonatoInputDTO dto, Campeonato entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setAno(dto.getAno());
        entity.setNome(dto.getNome());
    }

    private Set<TimeResumoDTO> toTimeResumoDTO(Set<Time> times) {
        return times.stream()
            .map(time -> new TimeResumoDTO(time.getId(), time.getNome()))
            .collect(Collectors.toSet());
    }

    private Set<PartidaResumoDTO> toPartidaResumoDTO(Set<Partida> partidas) {
        return partidas.stream()
            .map(partida -> {
                PartidaResumoDTO dto = new PartidaResumoDTO();
                dto.setId(partida.getId());
                dto.setDataPartida(partida.getDataPartida());
                dto.setTimeMandanteNome(partida.getTimeMandante().getNome());
                dto.setTimeVisitanteNome(partida.getTimeVisitante().getNome());
                
                if (partida.getResultado() != null) {
                    dto.setResultado(ResultadoMapper.toDTO(partida.getResultado()));
                }
                
                return dto;
            })
            .collect(Collectors.toSet());
    }
}
