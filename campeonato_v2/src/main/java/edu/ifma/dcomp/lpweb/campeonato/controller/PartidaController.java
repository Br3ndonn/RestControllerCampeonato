package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import edu.ifma.dcomp.lpweb.campeonato.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Partida> getPartidas(String nome) {
        if (nome == null) {
            return partidaService.todos();
        } else {
            return partidaService.buscarPor(nome);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Partida> buscaPor(@PathVariable Integer id) {
        Optional<Partida> optional = partidaService.buscarPor(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

