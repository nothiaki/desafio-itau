package com.itau.desafio_itau.core.domain;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RequestTransacaoDTO (

  @NotNull
  @Min(value = 0)
  Double valor,

  @NotNull
  OffsetDateTime dataHora

) {}
