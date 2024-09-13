package com.backend.backend.controller;

import java.net.URI;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import com.backend.backend.dto.PessoaDTO;
import com.backend.backend.model.Pessoa;
import com.backend.backend.repository.PessoaRepository;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/post")
    public ResponseEntity<Void> criaPessoa(@RequestBody PessoaDTO pessoaDTO, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setTelefone(formatTelefone(pessoaDTO.getTelefone()));
        pessoa.setCpf(formatCpf(pessoaDTO.getCpf()));

        Pessoa novaPessoa = pessoaRepository.save(pessoa);
        URI location = uriBuilder.path("/api/{id}").buildAndExpand(novaPessoa.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        return pessoaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa novaPessoa) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(novaPessoa.getNome());
                    pessoa.setTelefone(formatTelefone(novaPessoa.getTelefone()));
                    pessoa.setCpf(formatCpf(novaPessoa.getCpf()));
                    pessoaRepository.save(pessoa);
                    return ResponseEntity.ok(pessoa);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoaRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    private String formatTelefone(String telefone) {
        return telefone.replaceAll("[^0-9]", "");
    }

    private String formatCpf(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }
}
