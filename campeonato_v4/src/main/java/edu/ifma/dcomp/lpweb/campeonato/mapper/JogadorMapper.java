package edu.ifma.dcomp.lpweb.campeonato.mapper;

import edu.ifma.dcomp.lpweb.campeonato.dto.input.JogadorInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.JogadorDTO;
import edu.ifma.dcomp.lpweb.campeonato.model.Jogador;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JogadorMapper {

    public Jogador toEntity(JogadorInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Jogador jogador = new Jogador();
        jogador.setNome(dto.getNome());
        jogador.setNascimento(dto.getNascimento());
        jogador.setGenero(dto.getGenero());
        jogador.setAltura(dto.getAltura());
        
        return jogador;
    }

    public JogadorDTO toDTO(Jogador entity) {
        if (entity == null) {
            return null;
        }

        JogadorDTO dto = new JogadorDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNascimento(entity.getNascimento());
        dto.setGenero(entity.getGenero());
        dto.setAltura(entity.getAltura());
        
        if (entity.getTime() != null) {
            dto.setTimeId(entity.getTime().getId());
            dto.setTimeNome(entity.getTime().getNome());
        }
        
        return dto;
    }

    public Set<JogadorDTO> toDTOSet(Set<Jogador> entities) {
        if (entities == null) {
            return null;
        }

        return entities.stream()
            .map(this::toDTO)
            .collect(Collectors.toSet());
    }

    public void updateEntity(JogadorInputDTO dto, Jogador entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setNome(dto.getNome());
        entity.setNascimento(dto.getNascimento());
        entity.setGenero(dto.getGenero());
        entity.setAltura(dto.getAltura());
    }
    
    public List<JogadorDTO> toListDTO(List<Jogador> jogadores) {
        return jogadores.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
