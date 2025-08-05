package edu.ifma.dcomp.lpweb.campeonato.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome do time é obrigatório")
    @Size(min = 2, max = 50, message = "Nome do jogador deve ter entre 2 e 50 caracteres")
    private String nome;

    private LocalDate nascimento;
    private String genero; // <-- Fixed from Genero

    @Positive
    private Float altura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_id", nullable = false)
    private Time time;

    // Getters and setters...
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getNascimento() { return nascimento; }
    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; }
    public String getGenero() { return genero; } // <-- Fixed
    public void setGenero(String genero) { this.genero = genero; } // <-- Fixed
    public Float getAltura() { return altura; }
    public void setAltura(Float altura) { this.altura = altura; }
    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
}