package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;
import edu.ifma.dcomp.lpweb.campeonato.repository.CampeonatoRepository;
import edu.ifma.dcomp.lpweb.campeonato.services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CampeonatoController {

    private final CampeonatoService campeonatoService;

    @Autowired
    public CampeonatoController(CampeonatoService campeonatoService) {
        this.campeonatoService = campeonatoService;
    }

    @GetMapping("/campeonato")
    public List<Campeonato> getCampeonatos(String nome) {
        if (nome == null) {
            return campeonatoService.todos();
        } else {
            return campeonatoService.buscarPor(nome);
        }
    }



}
