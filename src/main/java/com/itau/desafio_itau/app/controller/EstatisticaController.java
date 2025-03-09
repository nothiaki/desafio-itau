package com.itau.desafio_itau.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.desafio_itau.core.domain.Estatistica;
import com.itau.desafio_itau.core.usecase.EstatisticaUseCase;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

  @Autowired
  private EstatisticaUseCase estatisticaUseCase;

  @GetMapping
  public ResponseEntity<Estatistica> find() {
    Estatistica estatistica = estatisticaUseCase.execute();

    return ResponseEntity.ok(estatistica);
  }

}
