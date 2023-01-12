package com.aronalvarenga.avaliacaobackend.controller;

import com.aronalvarenga.avaliacaobackend.dto.CadastroDTO;
import com.aronalvarenga.avaliacaobackend.dto.EnderecosDTO;
import com.aronalvarenga.avaliacaobackend.entity.Pessoa;
import com.aronalvarenga.avaliacaobackend.repository.EnderecoRepository;
import com.aronalvarenga.avaliacaobackend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CadastroController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping("/pessoa")
    public Pessoa criarPessoa(@RequestBody CadastroDTO cadastro) {
        return pessoaRepository.save(cadastro.getPessoa());
    }

    @GetMapping("/pessoas")
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/enderecos")
    public List<EnderecosDTO> listarEnderecos() {
        return pessoaRepository.getJoinInfo();
    }


    @GetMapping("/pessoa/{id}")
    public ResponseEntity consultarPessoa(@PathVariable Long id) {
        Optional<Pessoa> personById = pessoaRepository.findById(id);

        if(personById.isPresent()) {
            return new ResponseEntity(pessoaRepository.findById(id), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pessoa/{id}/enderecos")
    public ResponseEntity consultarEnderecosPessoa(@PathVariable Long id) {
        Optional<Pessoa> personById = pessoaRepository.findById(id);

        if(personById.isPresent()) {
            return new ResponseEntity(pessoaRepository.getJoinInfoById(id), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pessoa/{id}/enderecos/principal")
    public ResponseEntity consultarEnderecoPrincipalPessoa(@PathVariable Long id) {
        Optional<Pessoa> personById = pessoaRepository.findById(id);

        if(personById.isPresent()) {
            return new ResponseEntity(pessoaRepository.getJoinInfoMainById(id), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/pessoa")
    public ResponseEntity editarPessoa(@RequestBody CadastroDTO cadastro) {
        Optional<Pessoa> personById = pessoaRepository.findById(cadastro.getPessoa().getId());

        if(personById.isPresent()) {
            return new ResponseEntity(pessoaRepository.save(cadastro.getPessoa()), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/endereco")
    public ResponseEntity criarEndereco(@RequestBody CadastroDTO cadastro) {
        Optional<Pessoa> personById = pessoaRepository.findById(cadastro.getPessoa().getId());

        if(personById.isPresent()) {
            return new ResponseEntity(pessoaRepository.save(cadastro.getPessoa()), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
