package com.paylike.models.requests;

/**
 * Created by jankjr on 17/11/2016.
 */
public class RefundData {
  public String transactionId;
  public String descriptor;
  public long amount;

  @Override
  public String toString() {
    return "RefundData{" +
    "transactionId='" + transactionId + '\'' +
    ", descriptor='" + descriptor + '\'' +
    ", amount=" + amount +
    '}';
  }

  public RefundData(String transactionId, String descriptor, long amount) {
    this.transactionId = transactionId;
    this.descriptor = descriptor;
    this.amount = amount;
  }

  public RefundData() {
  }
}
