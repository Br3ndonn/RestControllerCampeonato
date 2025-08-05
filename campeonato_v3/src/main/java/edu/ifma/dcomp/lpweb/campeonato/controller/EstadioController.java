package edu.ifma.dcomp.lpweb.campeonato.controller;


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

    @Autowired
    public EstadioController(EstadioService estadioService) {
        this.estadioService = estadioService;
    }

    @GetMapping("/estadio")
    public List<Estadio> getEstadios(String nome) {
        if (nome == null) {
            return estadioService.todos();
        } else {
            return estadioService.buscarPor(nome);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Estadio> buscaPor(@PathVariable Integer id) {
        return estadioService.buscarPor(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Estadio> cadastro(@RequestBody Estadio estadio, UriComponentsBuilder builder) {

        final Estadio estadioSalvo = estadioService.salvar(estadio);

        final URI uri = builder
                .path("/estadios/{id}")
                .buildAndExpand(estadioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(estadioSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Estadio> atualiza(@PathVariable Integer id, @RequestBody Estadio estadio) {
        if (estadioService.naoExisteEstadio(id)) {
            return ResponseEntity.notFound().build();
        } else {
            estadio.setId(id);
            Estadio estadioAtualizado = estadioService.salvar(estadio);
            return ResponseEntity.ok(estadioAtualizado);
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
