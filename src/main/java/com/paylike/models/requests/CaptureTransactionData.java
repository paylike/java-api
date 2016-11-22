package com.paylike.models.requests;

/**
 * Created by jankjr on 17/11/2016.
 */
public class CaptureTransactionData {
  public long   amount;
  public String currency;
  public String descriptor;


  public CaptureTransactionData(long amount, String currency, String descriptor) {
    this.amount = amount;
    this.currency = currency;
    this.descriptor = descriptor;
  }

  @Override
  public String toString() {
    return "CaptureTransactionData{" +
    "amount=" + amount +
    ", currency='" + currency + '\'' +
    ", descriptor='" + descriptor + '\'' +
    '}';
  }
}
