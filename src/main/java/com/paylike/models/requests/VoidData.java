package com.paylike.models.requests;

/**
 * Created by jankjr on 17/11/2016.
 */
public class VoidData {
  public long amount;

  public VoidData(long amount) {

    this.amount = amount;
  }

  @Override
  public String toString() {
    return "VoidData{" +
    "amount=" + amount +
    '}';
  }
}
