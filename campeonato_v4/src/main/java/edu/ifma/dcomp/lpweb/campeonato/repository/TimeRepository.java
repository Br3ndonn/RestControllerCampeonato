package edu.ifma.dcomp.lpweb.campeonato.repository;

import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
    List<Time> findByNomeContaining(String nome);

}