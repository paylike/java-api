package com.paylike.models;

/**
 * Created by jankjr on 22/11/2016.
 */
public class Line {
  public String id;
  public String created;
  public String merchantId;
  public long balance;
  public long fee;
  public String transactionId;
  public Charge amount;
  public boolean capture;
  public boolean test;


  @Override
  public String toString() {
    return "Line{" +
    "id='" + id + '\'' +
    ", created='" + created + '\'' +
    ", merchantId='" + merchantId + '\'' +
    ", balance=" + balance +
    ", fee=" + fee +
    ", transactionId='" + transactionId + '\'' +
    ", amount=" + amount +
    ", capture=" + capture +
    ", test=" + test +
    '}';
  }
}
