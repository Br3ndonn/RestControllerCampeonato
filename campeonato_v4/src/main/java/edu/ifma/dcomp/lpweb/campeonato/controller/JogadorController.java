package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.dto.input.JogadorInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.JogadorDTO;
import edu.ifma.dcomp.lpweb.campeonato.mapper.JogadorMapper;
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
    private final JogadorMapper jogadorMapper;

    @Autowired
    public JogadorController(JogadorService jogadorService, JogadorMapper jogadorMapper) {
        this.jogadorService = jogadorService;
        this.jogadorMapper = jogadorMapper;
    }

    @GetMapping("/jogador")
    public List<JogadorDTO> getJogadores(String nome) {
        if (nome == null) {
            return jogadorMapper.toListDTO(jogadorService.todos());
        } else {
            return jogadorMapper.toListDTO(jogadorService.buscarPor(nome));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<JogadorDTO> buscaPor(@PathVariable Integer id) {
        return jogadorService.buscarPor(id)
                .map(jogador -> ResponseEntity.ok(jogadorMapper.toDTO(jogador)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<JogadorDTO> cadastro(@RequestBody JogadorInputDTO jogadorInputDTO, UriComponentsBuilder builder) {

        final Jogador jogador = jogadorMapper.toEntity(jogadorInputDTO);
        final Jogador jogadorSalvo = jogadorService.salvar(jogador);

        final URI uri = builder
                .path("/jogadores/{id}")
                .buildAndExpand(jogadorSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(jogadorMapper.toDTO(jogadorSalvo));
    }

    @PutMapping("{id}")
    public ResponseEntity<JogadorDTO> atualiza(@PathVariable Integer id, @RequestBody JogadorInputDTO jogadorInputDTO) {
        if (jogadorService.naoExisteJogador(id)) {
            return ResponseEntity.notFound().build();
        } else {
            Optional<Jogador> optionalJogador = jogadorService.buscarPor(id);
            if (optionalJogador.isPresent()) {
                Jogador jogador = optionalJogador.get();
                jogadorMapper.updateEntity(jogadorInputDTO, jogador);
                jogador.setId(id);
                Jogador jogadorAtualizado = jogadorService.salvar(jogador);
                return ResponseEntity.ok(jogadorMapper.toDTO(jogadorAtualizado));
            }
            return ResponseEntity.notFound().build();
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
