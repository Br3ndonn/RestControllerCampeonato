package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Estadio;
import edu.ifma.dcomp.lpweb.campeonato.repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstadioController {

    @Autowired
    private EstadioRepository estadioRepository;

    @GetMapping("/estadio")
    public List<Estadio> getEstadios() {
        return estadioRepository.findAll();
    }
}
