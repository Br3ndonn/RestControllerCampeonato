package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Jogador;
import edu.ifma.dcomp.lpweb.campeonato.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping("/jogador")
    public List<Jogador> getJogadores() {
        return jogadorRepository.findAll();
    }
}
