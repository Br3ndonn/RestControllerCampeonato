package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import edu.ifma.dcomp.lpweb.campeonato.repository.TimeRepository;
import edu.ifma.dcomp.lpweb.campeonato.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;
    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public List<Time> getTimes(String nome) {
        if (nome == null) {
            return timeService.todos();
        } else {
            return timeService.buscarPor(nome);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Time> buscaPor(@PathVariable Integer id) {
        Optional<Time> optional = timeService.buscarPor(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
