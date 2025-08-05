package edu.ifma.dcomp.lpweb.campeonato.controller;
import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import edu.ifma.dcomp.lpweb.campeonato.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
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
        return timeService.buscarPor(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Time> cadastro(@RequestBody Time time, UriComponentsBuilder builder) {

        final Time timeSalvo = timeService.salvar(time);

        final URI uri = builder
                .path("/times/{id}")
                .buildAndExpand(timeSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(timeSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Time> atualiza(@PathVariable Integer id, @RequestBody Time time) {
        if (timeService.naoExisteTime(id)) {
            return ResponseEntity.notFound().build();
        }else{
            time.setId(id);
            Time timeAtualizado = timeService.salvar(time);
            return ResponseEntity.ok(timeAtualizado);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Time> optional = timeService.buscarPor(id);

        if (optional.isPresent()) {
            timeService.removerPelo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
