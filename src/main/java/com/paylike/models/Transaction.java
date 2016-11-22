package com.paylike.models;

import java.util.List;
import java.util.Map;

/**
 * Created by jankjr on 22/11/2016.
 */
public class Transaction {
  public String id;

  public boolean test;
  
  public String merchantId;

  public String created;

  public long amount;

  public long refundedAmount;
  public long capturedAmount;
  public long voidedAmount;
  public long pendingAmount;
  public long disputedAmount;

  public Card card;
  boolean tds;

  public String currency;

  public Map custom;

  public boolean recurring;
  public boolean successful;
  public boolean error;
  public String descriptor;

  public List<TrailEntry> trail;

  @Override
  public String toString() {
    return "Transaction{" +
    "id='" + id + '\'' +
    ", test=" + test +
    ", merchantId='" + merchantId + '\'' +
    ", created='" + created + '\'' +
    ", amount=" + amount +
    ", refundedAmount=" + refundedAmount +
    ", capturedAmount=" + capturedAmount +
    ", voidedAmount=" + voidedAmount +
    ", pendingAmount=" + pendingAmount +
    ", disputedAmount=" + disputedAmount +
    ", card=" + card +
    ", tds=" + tds +
    ", currency='" + currency + '\'' +
    ", custom=" + custom +
    ", recurring=" + recurring +
    ", successful=" + successful +
    ", error=" + error +
    ", descriptor='" + descriptor + '\'' +
    ", trail=" + trail +
    '}';
  }
}
