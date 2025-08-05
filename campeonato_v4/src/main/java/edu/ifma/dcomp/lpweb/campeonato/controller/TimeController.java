package edu.ifma.dcomp.lpweb.campeonato.controller;
import edu.ifma.dcomp.lpweb.campeonato.dto.input.TimeInputDTO;
import edu.ifma.dcomp.lpweb.campeonato.dto.output.TimeDTO;
import edu.ifma.dcomp.lpweb.campeonato.mapper.TimeMapper;
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
    private final TimeMapper timeMapper;

    @Autowired
    public TimeController(TimeService timeService, TimeMapper timeMapper) {
        this.timeService = timeService;
        this.timeMapper = timeMapper;
    }

    @GetMapping("/time")
    public List<TimeDTO> getTimes(String nome) {
        if (nome == null) {
            return timeMapper.toListDTO(timeService.todos());
        } else {
            return timeMapper.toListDTO(timeService.buscarPor(nome));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeDTO> buscaPor(@PathVariable Integer id) {
        return timeService.buscarPor(id)
                .map(time -> ResponseEntity.ok(timeMapper.toDTO(time)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TimeDTO> cadastro(@RequestBody TimeInputDTO timeInputDTO, UriComponentsBuilder builder) {

        final Time time = timeMapper.toEntity(timeInputDTO);
        final Time timeSalvo = timeService.salvar(time);

        final URI uri = builder
                .path("/times/{id}")
                .buildAndExpand(timeSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(timeMapper.toDTO(timeSalvo));
    }

    @PutMapping("{id}")
    public ResponseEntity<TimeDTO> atualiza(@PathVariable Integer id, @RequestBody TimeInputDTO timeInputDTO) {
        if (timeService.naoExisteTime(id)) {
            return ResponseEntity.notFound().build();
        } else {
            Optional<Time> optionalTime = timeService.buscarPor(id);
            if (optionalTime.isPresent()) {
                Time time = optionalTime.get();
                timeMapper.updateEntity(timeInputDTO, time);
                time.setId(id);
                Time timeAtualizado = timeService.salvar(time);
                return ResponseEntity.ok(timeMapper.toDTO(timeAtualizado));
            }
            return ResponseEntity.notFound().build();
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
