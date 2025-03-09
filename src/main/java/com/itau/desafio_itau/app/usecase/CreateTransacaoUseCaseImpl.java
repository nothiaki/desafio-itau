package com.itau.desafio_itau.app.usecase;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.desafio_itau.app.repository.TransacaoRepository;
import com.itau.desafio_itau.core.domain.RequestTransacaoDTO;
import com.itau.desafio_itau.core.domain.Transacao;
import com.itau.desafio_itau.core.usecase.CreateTransacaoUseCase;

@Service
public class CreateTransacaoUseCaseImpl implements CreateTransacaoUseCase {

  @Autowired
  private TransacaoRepository transacaoRepository;

  @Override
  public void execute(RequestTransacaoDTO requestTransacao) {
    Transacao transacao = new Transacao(requestTransacao);

    if(OffsetDateTime.now().isBefore(transacao.getDataHora())) {
      System.out.println("data futura");
      throw new RuntimeException();
    }

    transacaoRepository.getTransacoes().add(transacao);

  }

}
