package edu.ifma.dcomp.lpweb.campeonato.services;

import edu.ifma.dcomp.lpweb.campeonato.model.Estadio;
import edu.ifma.dcomp.lpweb.campeonato.repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstadioService {

    private final EstadioRepository estadioRepository;

    @Autowired
    public EstadioService(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    public List<Estadio> todos() {
        return estadioRepository.findAll();
    }

    public Optional<Estadio> buscarPor(Integer id) {
        return estadioRepository.findById(id);
    }

    public List<Estadio> buscarPor(String nome) {
        return estadioRepository.findByNomeContaining(nome);
    }

    @Transactional
    public Estadio salvar(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    @Transactional
    public void removerPelo(Integer id) {
        estadioRepository.deleteById(id);
    }

    public boolean naoExisteEstadio(Integer id) {
        return !estadioRepository.existsById(id);
    }
}