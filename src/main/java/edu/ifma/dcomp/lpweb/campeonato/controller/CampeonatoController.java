package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;
import edu.ifma.dcomp.lpweb.campeonato.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CampeonatoController {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @GetMapping("/campeonato")
    public List<Campeonato> getCampeonatos() {
        return campeonatoRepository.findAll();
    }
}
