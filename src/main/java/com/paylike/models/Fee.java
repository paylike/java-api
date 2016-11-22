package com.paylike.models;

/**
 * Created by jankjr on 22/11/2016.
 */
public class Fee {
  public long flat;
  public long rate;

  @Override
  public String toString() {
    return "Fee{" +
    "rate=" + rate +
    ", flat=" + flat +
    '}';
  }
}
