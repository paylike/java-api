package com.paylike.models;

/**
 * Created by jankjr on 21/11/2016.
 */
public class Charge {
  public String currency;
  public long amount;

  @Override
  public String toString() {
    return "Charge{" +
    "currency='" + currency + '\'' +
    ", amount=" + amount +
    '}';
  }
  public Charge() {
  }
}
