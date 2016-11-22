package com.paylike.models;

/**
 * Created by jankjr on 17/11/2016.
 */
public class Card {
  public String bin;
  public String last4;
  public String expiry;
  public String scheme;

  @Override
  public String toString() {
    return "Card{" +
    "bin='" + bin + '\'' +
    ", last4='" + last4 + '\'' +
    ", expiry='" + expiry + '\'' +
    ", scheme='" + scheme + '\'' +
    '}';
  }
}
