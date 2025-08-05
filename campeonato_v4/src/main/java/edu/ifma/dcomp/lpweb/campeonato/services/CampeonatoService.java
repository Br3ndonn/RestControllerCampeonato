package edu.ifma.dcomp.lpweb.campeonato.services;

import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;
import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import edu.ifma.dcomp.lpweb.campeonato.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepository;

    @Autowired
    public CampeonatoService(CampeonatoRepository campeonatoRepository) {
        this.campeonatoRepository = campeonatoRepository;
    }

    public List<Campeonato> todos() {
        return campeonatoRepository.findAll();
    }

    public Optional<Campeonato> buscarPor(Integer id) {
        return campeonatoRepository.findById(id);
    }

    public List<Campeonato> buscarPor(String nome) {
        return campeonatoRepository.findByNomeContaining(nome);
    }

    @Transactional
    public Campeonato salvar(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    @Transactional
    public void removerPelo(Integer id) {
        campeonatoRepository.deleteById(id);
    }

    public boolean naoExisteCampeonato(Integer id) {
        return !campeonatoRepository.existsById(id);
    }

    public Optional<Set<Time>> buscarTimesPorCampeonato(Integer campeonatoId) {
        Optional<Campeonato> campeonatoOpt = campeonatoRepository.findById(campeonatoId);
        return campeonatoOpt.map(Campeonato::getTimes);
    }
}