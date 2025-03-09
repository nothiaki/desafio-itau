package com.itau.desafio_itau.core.domain;

import java.util.DoubleSummaryStatistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estatistica {

  private Long count;
  private Double min;
  private Double max;
  private Double sum;
  private Double avg;

  public Estatistica(DoubleSummaryStatistics doubleSummaryStatistics) {
    this.count = doubleSummaryStatistics.getCount();
    this.min = doubleSummaryStatistics.getMin();
    this.max = doubleSummaryStatistics.getMax();
    this.sum = doubleSummaryStatistics.getSum();
    this.avg = doubleSummaryStatistics.getSum() / doubleSummaryStatistics.getCount();
  }

}
