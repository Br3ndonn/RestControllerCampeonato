package edu.ifma.dcomp.lpweb.campeonato.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Time {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome do time é obrigatório")
    @Size(min = 3, max = 25, message = "Nome do time deve ter entre 3 e 25 caracteres")
    private String nome;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Jogador> jogadores = new HashSet<>();

    @NotBlank
    @OneToOne(mappedBy = "time", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Estadio estadio;

    @ManyToMany
    @JoinTable(
        name = "campeonato_time",
        joinColumns = @JoinColumn(name = "time_id"),
        inverseJoinColumns = @JoinColumn(name = "campeonato_id")
    )
    private Set<Campeonato> campeonatos = new HashSet<>();

    @OneToMany(mappedBy = "timeMandante", fetch = FetchType.LAZY)
    private Set<Partida> partidasComoMandante = new HashSet<>();

    // A set for all games where this team was the away team (visitante)
    @OneToMany(mappedBy = "timeVisitante", fetch = FetchType.LAZY)
    private Set<Partida> partidasComoVisitante = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(Set<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Set<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(Set<Campeonato> campeonatos) {
        this.campeonatos = campeonatos;
    }

    public Set<Partida> getPartidasComoMandante() {
        return partidasComoMandante;
    }

    public void setPartidasComoMandante(Set<Partida> partidasComoMandante) {
        this.partidasComoMandante = partidasComoMandante;
    }

    public Set<Partida> getPartidasComoVisitante() {
        return partidasComoVisitante;
    }

    public void setPartidasComoVisitante(Set<Partida> partidasComoVisitante) {
        this.partidasComoVisitante = partidasComoVisitante;
    }
}
