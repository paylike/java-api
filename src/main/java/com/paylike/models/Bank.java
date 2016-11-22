package com.paylike.models;

/**
 * Created by jankjr on 17/11/2016.
 */
public class Bank {
  public String iban;

  public Bank() {
  }

  @Override
  public String toString() {
    return "Bank{" +
    "iban='" + iban + '\'' +
    '}';
  }
}
