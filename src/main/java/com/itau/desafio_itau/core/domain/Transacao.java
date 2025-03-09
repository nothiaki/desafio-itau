package com.itau.desafio_itau.core.domain;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

  private Float valor;
  private OffsetDateTime dataHora;

  public Transacao(RequestTransacaoDTO requestTransacao) {
    this.valor = requestTransacao.valor();
    this.dataHora = requestTransacao.dataHora();
  }

}
