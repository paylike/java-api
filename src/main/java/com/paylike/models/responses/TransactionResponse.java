package com.paylike.models.responses;

import com.paylike.models.Transaction;

/**
 * Created by jankjr on 22/11/2016.
 */
public class TransactionResponse {
  public Transaction transaction;


  @Override
  public String toString() {
    return "TransactionResponse{" +
    "transaction=" + transaction +
    '}';
  }
}
