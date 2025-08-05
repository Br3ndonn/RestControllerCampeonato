package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;
import edu.ifma.dcomp.lpweb.campeonato.services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping
public class CampeonatoController {

    private final CampeonatoService campeonatoService;

    @Autowired
    public CampeonatoController(CampeonatoService campeonatoService) {
        this.campeonatoService = campeonatoService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Campeonato> buscaPor(@PathVariable Integer id) {
        return campeonatoService.buscarPor(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Campeonato cadastrar(@RequestBody Campeonato campeonato) {
        return campeonatoService.salvar(campeonato);
    }

    @PutMapping("{id}")
    public ResponseEntity<Campeonato> atualiza(@PathVariable Integer id, @RequestBody Campeonato campeonato) {
        if (campeonatoService.naoExisteCampeonato(id)) {
            return ResponseEntity.notFound().build();
        } else {
            campeonato.setId(id);
            Campeonato campeonatoAtualizado = campeonatoService.salvar(campeonato);
            return ResponseEntity.ok(campeonatoAtualizado);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Campeonato> optional = campeonatoService.buscarPor(id);

        if (optional.isPresent()) {
            campeonatoService.removerPelo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
