package com.itau.desafio_itau.app.usecase;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    transacaoRepository.getTransacoes().add(transacao);

  }

}
