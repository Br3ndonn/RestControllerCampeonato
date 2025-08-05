package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Estadio;
import edu.ifma.dcomp.lpweb.campeonato.repository.EstadioRepository;
import edu.ifma.dcomp.lpweb.campeonato.services.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Optional<Estadio> optional = estadioService.buscarPor(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
