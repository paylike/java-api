package com.paylike.models.requests;

import java.util.Map;

/**
 * Created by jankjr on 22/11/2016.
 */
public class CreateTransactionFromSavedCardInput {
  private final String cardId;
  private final String currency;
  private final String descriptor;
  private final int amount;
  private final Map custom;

  public CreateTransactionFromSavedCardInput(String cardId, String currency, String descriptor, int amount, Map custom) {
    this.cardId = cardId;
    this.currency = currency;
    this.descriptor = descriptor;
    this.amount = amount;
    this.custom = custom;
  }

  @Override
  public String toString() {
    return "CreateTransactionFromSavedCardInput{" +
    "cardId='" + cardId + '\'' +
    ", currency='" + currency + '\'' +
    ", descriptor='" + descriptor + '\'' +
    ", amount=" + amount +
    ", custom=" + custom +
    '}';
  }
}
