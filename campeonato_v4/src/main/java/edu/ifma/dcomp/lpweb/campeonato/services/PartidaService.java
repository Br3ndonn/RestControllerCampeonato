package edu.ifma.dcomp.lpweb.campeonato.services;

import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import edu.ifma.dcomp.lpweb.campeonato.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;

    @Autowired
    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    public List<Partida> todos() {
        return partidaRepository.findAll();
    }

    public Optional<Partida> buscarPor(Integer id) {
        return partidaRepository.findById(id);
    }
    @Transactional
    public Partida salvar(Partida partida) {
        return partidaRepository.save(partida);
    }

    @Transactional
    public void removerPelo(Integer id) {
        partidaRepository.deleteById(id);
    }

    public boolean naoExistePartida(Integer id) {
        return !partidaRepository.existsById(id);
    }
}