package com.itau.desafio_itau.app.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.desafio_itau.app.repository.TransacaoRepository;
import com.itau.desafio_itau.core.usecase.DeleteTransacaoUseCase;

@Service
public class DeleteTransacaoUseCaseImpl implements DeleteTransacaoUseCase {

  @Autowired
  private TransacaoRepository transacaoRepository;

  @Override
  public void execute() {
    transacaoRepository.getTransacoes().clear();
  }

}
