package edu.ifma.dcomp.lpweb.campeonato.services;

import edu.ifma.dcomp.lpweb.campeonato.model.Jogador;
import edu.ifma.dcomp.lpweb.campeonato.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> todos() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarPor(Integer id) {
        return jogadorRepository.findById(id);
    }

    public List<Jogador> buscarPor(String nome) {
        return jogadorRepository.findByNomeContaining(nome);
    }

    @Transactional
    public Jogador salvar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    @Transactional
    public void removerPelo(Integer id) {
        jogadorRepository.deleteById(id);
    }

    public boolean naoExisteJogador(Integer id) {
        return !jogadorRepository.existsById(id);
    }
}