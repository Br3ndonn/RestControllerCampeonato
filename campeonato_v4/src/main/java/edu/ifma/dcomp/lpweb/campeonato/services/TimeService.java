package edu.ifma.dcomp.lpweb.campeonato.services;

import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import edu.ifma.dcomp.lpweb.campeonato.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    @Autowired
    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }
    public List<Time> todos() {
        return timeRepository.findAll();
    }

    public Optional<Time> buscarPor(Integer id) {
        return timeRepository.findById(id);
    }

    public List<Time> buscarPor(String nome) {
        return timeRepository.findByNomeContaining(nome);
    }

    @Transactional
    public Time salvar(Time time) {
        return timeRepository.save(time);
    }

    @Transactional
    public void removerPelo(Integer id) {
        timeRepository.deleteById(id);
    }

    public boolean naoExisteTime(Integer id) {
        return !timeRepository.existsById(id);
    }

}
