package com.itau.desafio_itau.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.desafio_itau.core.domain.RequestTransacaoDTO;
import com.itau.desafio_itau.core.usecase.CreateTransacaoUseCase;
import com.itau.desafio_itau.core.usecase.DeleteTransacaoUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

  @Autowired
  private CreateTransacaoUseCase createTransacaoUseCase;

  @Autowired
  private DeleteTransacaoUseCase deleteTransacaoUseCase;
  
  @PostMapping
  public ResponseEntity<Void> create(@Valid @RequestBody RequestTransacaoDTO requestTransacao) {
    createTransacaoUseCase.execute(requestTransacao);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping
  public ResponseEntity<Void> remove() {
    deleteTransacaoUseCase.execute();
    return ResponseEntity.ok().build();
  }

}
