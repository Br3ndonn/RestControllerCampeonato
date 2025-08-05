package edu.ifma.dcomp.lpweb.campeonato.controller;

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

    @Autowired
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping("/partida")
    public List<Partida> getPartidas() {
        return partidaService.todos();
    }
    @GetMapping("{id}")
    public ResponseEntity<Partida> buscaPor(@PathVariable Integer id) {
        return partidaService.buscarPor(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Partida> cadastro(@RequestBody Partida partida, UriComponentsBuilder builder) {

        final Partida partidaSalva = partidaService.salvar(partida);

        final URI uri = builder
                .path("/partidas/{id}")
                .buildAndExpand(partidaSalva.getId()).toUri();
        return ResponseEntity.created(uri).body(partidaSalva);
    }

    @PutMapping("{id}")
    public ResponseEntity<Partida> atualiza(@PathVariable Integer id, @RequestBody Partida partida) {
        if (partidaService.naoExistePartida(id)) {
            return ResponseEntity.notFound().build();
        } else {
            partida.setId(id);
            Partida partidaAtualizada = partidaService.salvar(partida);
            return ResponseEntity.ok(partidaAtualizada);
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

