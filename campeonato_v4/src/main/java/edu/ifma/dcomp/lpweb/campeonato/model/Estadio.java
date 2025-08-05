package edu.ifma.dcomp.lpweb.campeonato.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome do estádio é obrigatório")
    private String nome;
    @NotBlank(message = "Endereço do estádio é obrigatório")
    private String endereco;

    @NotBlank(message = "Time associado ao estádio é obrigatório")
    @OneToOne
    @JoinColumn(name = "time_id", nullable = false)
    private Time time;

    // --- GETTERS AND SETTERS ---

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // ===== THE MISSING METHODS =====
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    // =============================
}