package com.paylike.models;

/**
 * Created by jankjr on 22/11/2016.
 */
public class CardWithId {
  public String id;
  public String created;

  public String bin;
  public String last4;
  public String expiry;
  public String scheme;

  @Override
  public String toString() {
    return "CardWithId{" +
    "id='" + id + '\'' +
    ", created='" + created + '\'' +
    ", bin='" + bin + '\'' +
    ", last4='" + last4 + '\'' +
    ", expiry='" + expiry + '\'' +
    ", scheme='" + scheme + '\'' +
    '}';
  }
}
