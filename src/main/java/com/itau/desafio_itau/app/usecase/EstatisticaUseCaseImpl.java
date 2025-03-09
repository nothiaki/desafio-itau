package com.itau.desafio_itau.app.usecase;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.desafio_itau.app.repository.TransacaoRepository;
import com.itau.desafio_itau.core.domain.Estatistica;
import com.itau.desafio_itau.core.domain.Transacao;
import com.itau.desafio_itau.core.usecase.EstatisticaUseCase;

@Service
public class EstatisticaUseCaseImpl implements EstatisticaUseCase {

  @Autowired
  private TransacaoRepository transacaoRepository;

  @Override
  public Estatistica execute() {

    List<Transacao> transacoesLastMinute = transacaoRepository.getTransacoes().stream()
      .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusMinutes(1)))
      .collect(Collectors.toList());

    Long count = Long.valueOf(transacoesLastMinute.size());
    Double sum = 0.0;
    Double min = 0.0;
    Double max = 0.0;

    for(Transacao transacao : transacoesLastMinute) {
      sum += transacao.getValor();

      if(min > transacao.getValor()) {
        min = transacao.getValor();
      }

      if(max < transacao.getValor()) {
        max = transacao.getValor();
      }

    }

    DoubleSummaryStatistics statistics = new DoubleSummaryStatistics(count, min, max, sum);
 
    return new Estatistica(statistics);

  }

}
