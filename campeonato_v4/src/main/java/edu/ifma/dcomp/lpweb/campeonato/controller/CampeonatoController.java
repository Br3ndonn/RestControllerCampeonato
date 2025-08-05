package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.dto.input.CampeonatoInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.CampeonatoDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.TimeResumoDTO;
import edu.ifma.dcomp.lpweb.campeonato.mapper.CampeonatoMapper;
import edu.ifma.dcomp.lpweb.campeonato.mapper.TimeMapper;
import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;
import edu.ifma.dcomp.lpweb.campeonato.services.CampeonatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    private final CampeonatoService campeonatoService;
    private final CampeonatoMapper campeonatoMapper;
    private final TimeMapper timeMapper;

    @Autowired
    public CampeonatoController(CampeonatoService campeonatoService, 
                               CampeonatoMapper campeonatoMapper,
                               TimeMapper timeMapper) {
        this.campeonatoService = campeonatoService;
        this.campeonatoMapper = campeonatoMapper;
        this.timeMapper = timeMapper;
    }

    @GetMapping
    public ResponseEntity<List<CampeonatoDTO>> listarTodos() {
        List<Campeonato> campeonatos = campeonatoService.todos();
        List<CampeonatoDTO> campeonatosDTO = campeonatos.stream()
                .map(campeonatoMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(campeonatosDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<CampeonatoDTO> buscaPor(@PathVariable Integer id) {
        return campeonatoService.buscarPor(id)
                .map(campeonatoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CampeonatoDTO cadastrar(@Valid @RequestBody CampeonatoInputDTO campeonatoInputDTO) {
        Campeonato campeonato = campeonatoMapper.toEntity(campeonatoInputDTO);
        Campeonato campeonatoSalvo = campeonatoService.salvar(campeonato);
        return campeonatoMapper.toDTO(campeonatoSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<CampeonatoDTO> atualiza(@PathVariable Integer id, 
                                                  @Valid @RequestBody CampeonatoInputDTO campeonatoInputDTO) {
        Optional<Campeonato> campeonatoOptional = campeonatoService.buscarPor(id);
        
        if (campeonatoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Campeonato campeonato = campeonatoOptional.get();
        campeonatoMapper.updateEntity(campeonatoInputDTO, campeonato);
        Campeonato campeonatoAtualizado = campeonatoService.salvar(campeonato);
        
        return ResponseEntity.ok(campeonatoMapper.toDTO(campeonatoAtualizado));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Campeonato> optional = campeonatoService.buscarPor(id);

        if (optional.isPresent()) {
            campeonatoService.removerPelo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}/times")
    public ResponseEntity<Set<TimeResumoDTO>> listarTimesDoCampeonato(@PathVariable Integer id) {
        return campeonatoService.buscarTimesPorCampeonato(id)
                .map(times -> times.stream()
                        .map(timeMapper::toResumoDTO)
                        .collect(Collectors.toSet()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
