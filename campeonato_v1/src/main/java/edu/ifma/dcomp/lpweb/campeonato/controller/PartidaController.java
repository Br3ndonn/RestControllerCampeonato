package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import edu.ifma.dcomp.lpweb.campeonato.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartidaController {

    @Autowired
    private PartidaRepository partidaRepository;

    @GetMapping("/partida")
    public List<Partida> getPartidas() {
        return partidaRepository.findAll();
    }
}
