package edu.ifma.dcomp.lpweb.campeonato.repository;

import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;
import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer> {
    List<Campeonato> findByNomeContaining(String nome);
}
