package com.backend.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String documentoCpf;
    private String numeroTelefone;

    public Pessoa() {}

    public Pessoa(Long id, String nomeCompleto, String documentoCpf, String numeroTelefone) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.documentoCpf = documentoCpf;
        this.numeroTelefone = numeroTelefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDocumentoCpf() {
        return documentoCpf;
    }

    public void setDocumentoCpf(String documentoCpf) {
        this.documentoCpf = documentoCpf;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
}
