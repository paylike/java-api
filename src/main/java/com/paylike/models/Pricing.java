package com.paylike.models;

/**
 * Created by jankjr on 21/11/2016.
 */
public class Pricing {
  public Charge flat, dispute;
  public double rate;

  @Override
  public String toString() {
    return "Pricing{" +
    "rate=" + rate +
    ", dispute=" + dispute +
    ", flat=" + flat +
    '}';
  }
}
