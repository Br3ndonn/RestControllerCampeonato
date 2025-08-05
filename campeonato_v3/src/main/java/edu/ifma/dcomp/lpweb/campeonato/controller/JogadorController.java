package edu.ifma.dcomp.lpweb.campeonato.controller;


import edu.ifma.dcomp.lpweb.campeonato.model.Jogador;
import edu.ifma.dcomp.lpweb.campeonato.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
        return jogadorService.buscarPor(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Jogador> cadastro(@RequestBody Jogador jogador, UriComponentsBuilder builder) {

        final Jogador jogadorSalvo = jogadorService.salvar(jogador);

        final URI uri = builder
                .path("/jogadores/{id}")
                .buildAndExpand(jogadorSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(jogadorSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Jogador> atualiza(@PathVariable Integer id, @RequestBody Jogador jogador) {
        if (jogadorService.naoExisteJogador(id)) {
            return ResponseEntity.notFound().build();
        } else {
            jogador.setId(id);
            Jogador jogadorAtualizado = jogadorService.salvar(jogador);
            return ResponseEntity.ok(jogadorAtualizado);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Jogador> optional = jogadorService.buscarPor(id);

        if (optional.isPresent()) {
            jogadorService.removerPelo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
