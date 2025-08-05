package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Jogador;
import edu.ifma.dcomp.lpweb.campeonato.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping("/jogador")
    public List<Jogador> getJogadores(String nome) {
        if (nome == null) {
            return jogadorService.todos();
        } else {
            return jogadorService.buscarPor(nome);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Jogador> buscaPor(@PathVariable Integer id) {
        Optional<Jogador> optional = jogadorService.buscarPor(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
