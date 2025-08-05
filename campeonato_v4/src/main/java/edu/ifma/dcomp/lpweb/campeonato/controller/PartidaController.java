package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.dto.input.PartidaInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.PartidaDTO;
import edu.ifma.dcomp.lpweb.campeonato.mapper.PartidaMapper;
import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import edu.ifma.dcomp.lpweb.campeonato.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaService partidaService;
    private final PartidaMapper partidaMapper;

    @Autowired
    public PartidaController(PartidaService partidaService, PartidaMapper partidaMapper) {
        this.partidaService = partidaService;
        this.partidaMapper = partidaMapper;
    }

    @GetMapping("/partida")
    public List<PartidaDTO> getPartidas() {
        return partidaMapper.toListDTO(partidaService.todos());
    }
    @GetMapping("{id}")
    public ResponseEntity<PartidaDTO> buscaPor(@PathVariable Integer id) {
        return partidaService.buscarPor(id)
                .map(partida -> ResponseEntity.ok(partidaMapper.toDTO(partida)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PartidaDTO> cadastro(@RequestBody PartidaInputDTO partidaInputDTO, UriComponentsBuilder builder) {

        final Partida partida = partidaMapper.toEntity(partidaInputDTO);
        final Partida partidaSalva = partidaService.salvar(partida);

        final URI uri = builder
                .path("/partidas/{id}")
                .buildAndExpand(partidaSalva.getId()).toUri();
        return ResponseEntity.created(uri).body(partidaMapper.toDTO(partidaSalva));
    }

    @PutMapping("{id}")
    public ResponseEntity<PartidaDTO> atualiza(@PathVariable Integer id, @RequestBody PartidaInputDTO partidaInputDTO) {
        if (partidaService.naoExistePartida(id)) {
            return ResponseEntity.notFound().build();
        } else {
            Optional<Partida> optionalPartida = partidaService.buscarPor(id);
            if (optionalPartida.isPresent()) {
                Partida partida = optionalPartida.get();
                partidaMapper.updateEntity(partidaInputDTO, partida);
                partida.setId(id);
                Partida partidaAtualizada = partidaService.salvar(partida);
                return ResponseEntity.ok(partidaMapper.toDTO(partidaAtualizada));
            }
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Partida> optional = partidaService.buscarPor(id);

        if (optional.isPresent()) {
            partidaService.removerPelo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

