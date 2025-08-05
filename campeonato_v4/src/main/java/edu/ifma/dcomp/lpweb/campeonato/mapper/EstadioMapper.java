package edu.ifma.dcomp.lpweb.campeonato.mapper;

import edu.ifma.dcomp.lpweb.campeonato.dto.input.EstadioInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.EstadioDTO;
import edu.ifma.dcomp.lpweb.campeonato.model.Estadio;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadioMapper {

    public Estadio toEntity(EstadioInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Estadio estadio = new Estadio();
        estadio.setNome(dto.getNome());
        estadio.setEndereco(dto.getEndereco());
        
        return estadio;
    }

    public EstadioDTO toDTO(Estadio entity) {
        if (entity == null) {
            return null;
        }

        EstadioDTO dto = new EstadioDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEndereco(entity.getEndereco());
        
        if (entity.getTime() != null) {
            dto.setTimeId(entity.getTime().getId());
            dto.setTimeNome(entity.getTime().getNome());
        }
        
        return dto;
    }

    public void updateEntity(EstadioInputDTO dto, Estadio entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setNome(dto.getNome());
        entity.setEndereco(dto.getEndereco());
    }
    
    public List<EstadioDTO> toListDTO(List<Estadio> estadios) {
        return estadios.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
