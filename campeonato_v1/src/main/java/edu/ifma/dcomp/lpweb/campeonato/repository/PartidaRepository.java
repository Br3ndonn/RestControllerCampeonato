package edu.ifma.dcomp.lpweb.campeonato.repository;

import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {
}
