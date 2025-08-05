package edu.ifma.dcomp.lpweb.campeonato.repository;

import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {
    List<Partida> findByNomeContaining(String nome);
}
