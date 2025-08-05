package edu.ifma.dcomp.lpweb.campeonato.mapper;

import edu.ifma.dcomp.lpweb.campeonato.dto.input.TimeInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.TimeDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.TimeResumoDTO;
import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimeMapper {

    @Autowired
    private EstadioMapper estadioMapper;

    @Autowired
    private JogadorMapper jogadorMapper;

    public Time toEntity(TimeInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Time time = new Time();
        time.setNome(dto.getNome());
        
        return time;
    }

    public TimeDTO toDTO(Time entity) {
        if (entity == null) {
            return null;
        }

        TimeDTO dto = new TimeDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        
        if (entity.getEstadio() != null) {
            dto.setEstadio(estadioMapper.toDTO(entity.getEstadio()));
        }
        
        if (entity.getJogadores() != null) {
            dto.setJogadores(jogadorMapper.toDTOSet(entity.getJogadores()));
        }
        
        return dto;
    }

    public TimeResumoDTO toResumoDTO(Time entity) {
        if (entity == null) {
            return null;
        }

        return new TimeResumoDTO(
            entity.getId(),
            entity.getNome()
        );
    }

    public void updateEntity(TimeInputDTO dto, Time entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setNome(dto.getNome());
    }
    
    public List<TimeDTO> toListDTO(List<Time> times) {
        return times.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
