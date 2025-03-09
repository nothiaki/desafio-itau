package com.itau.desafio_itau.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itau.desafio_itau.core.domain.Transacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TransacaoRepository {

  private List<Transacao> transacoes = new ArrayList<>();

}
