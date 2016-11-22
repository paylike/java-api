package com.paylike.models;

/**
 * Created by jankjr on 21/11/2016.
 */
public class Merchant {
  public String id;
  public String created;
  public String name;
  public String currency;
  public boolean test;
  public String key;
  public String descriptor;
  public String website;
  public String email;
  public Company company;
  public Claim claim;

  public long balance;

  public Bank bank;

  public Pricing pricing;
  public Tds tds;

  @Override
  public String toString() {
    return "Merchant{" +
    "tds=" + tds +
    ", pricing=" + pricing +
    ", bank=" + bank +
    ", balance=" + balance +
    ", claim=" + claim +
    ", company=" + company +
    ", email='" + email + '\'' +
    ", website='" + website + '\'' +
    ", descriptor='" + descriptor + '\'' +
    ", key='" + key + '\'' +
    ", test=" + test +
    ", currency='" + currency + '\'' +
    ", name='" + name + '\'' +
    ", created='" + created + '\'' +
    ", id='" + id + '\'' +
    '}';
  }
}
