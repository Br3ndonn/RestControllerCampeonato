package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.dto.input.EstadioInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.EstadioDTO;
import edu.ifma.dcomp.lpweb.campeonato.mapper.EstadioMapper;
import edu.ifma.dcomp.lpweb.campeonato.model.Estadio;
import edu.ifma.dcomp.lpweb.campeonato.services.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadios")
public class EstadioController {

    private final EstadioService estadioService;
    private final EstadioMapper estadioMapper;

    @Autowired
    public EstadioController(EstadioService estadioService, EstadioMapper estadioMapper) {
        this.estadioService = estadioService;
        this.estadioMapper = estadioMapper;
    }

    @GetMapping("/estadio")
    public List<EstadioDTO> getEstadios(String nome) {
        if (nome == null) {
            return estadioMapper.toListDTO(estadioService.todos());
        } else {
            return estadioMapper.toListDTO(estadioService.buscarPor(nome));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<EstadioDTO> buscaPor(@PathVariable Integer id) {
        return estadioService.buscarPor(id)
                .map(estadio -> ResponseEntity.ok(estadioMapper.toDTO(estadio)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<EstadioDTO> cadastro(@RequestBody EstadioInputDTO estadioInputDTO, UriComponentsBuilder builder) {

        final Estadio estadio = estadioMapper.toEntity(estadioInputDTO);
        final Estadio estadioSalvo = estadioService.salvar(estadio);

        final URI uri = builder
                .path("/estadios/{id}")
                .buildAndExpand(estadioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(estadioMapper.toDTO(estadioSalvo));
    }

    @PutMapping("{id}")
    public ResponseEntity<EstadioDTO> atualiza(@PathVariable Integer id, @RequestBody EstadioInputDTO estadioInputDTO) {
        if (estadioService.naoExisteEstadio(id)) {
            return ResponseEntity.notFound().build();
        } else {
            Optional<Estadio> optionalEstadio = estadioService.buscarPor(id);
            if (optionalEstadio.isPresent()) {
                Estadio estadio = optionalEstadio.get();
                estadioMapper.updateEntity(estadioInputDTO, estadio);
                estadio.setId(id);
                Estadio estadioAtualizado = estadioService.salvar(estadio);
                return ResponseEntity.ok(estadioMapper.toDTO(estadioAtualizado));
            }
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Estadio> optional = estadioService.buscarPor(id);

        if (optional.isPresent()) {
            estadioService.removerPelo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
