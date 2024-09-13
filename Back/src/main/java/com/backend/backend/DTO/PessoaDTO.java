package com.backend.backend.dto;

public class PessoaDTO {
    private String nomeCompleto;
    private String numeroTelefone;
    private String documentoCpf;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getDocumentoCpf() {
        return documentoCpf;
    }

    public void setDocumentoCpf(String documentoCpf) {
        this.documentoCpf = documentoCpf;
    }
}
