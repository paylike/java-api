package com.paylike.models.requests;

import java.util.Map;

/**
 * Created by jankjr on 17/11/2016.
 */
public class CreateTransactionFromPreviusTransactionData {
  public String transactionId;
  public String descriptor;
  public String currency;
  public long amount;
  public Map custom;

  public CreateTransactionFromPreviusTransactionData() {
  }

  public CreateTransactionFromPreviusTransactionData(long amount, String transactionId, String descriptor, String currency, Map custom){
    this.amount = amount;
    this.transactionId = transactionId;
    this.descriptor = descriptor;
    this.currency = currency;
    this.custom = custom;
  }

  @Override
  public String toString() {
    return "CreateTransactionFromPreviusTransactionData{" +
    "transactionId='" + transactionId + '\'' +
    ", descriptor='" + descriptor + '\'' +
    ", currency='" + currency + '\'' +
    ", amount=" + amount +
    ", custom=" + custom +
    '}';
  }
}
