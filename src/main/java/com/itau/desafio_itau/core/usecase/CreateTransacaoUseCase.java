package com.itau.desafio_itau.core.usecase;

import com.itau.desafio_itau.core.domain.RequestTransacaoDTO;

public interface CreateTransacaoUseCase {

  public void execute(RequestTransacaoDTO requestTransacao);

}
