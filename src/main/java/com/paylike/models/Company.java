package com.paylike.models;

/**
 * Created by jankjr on 17/11/2016.
 */
public class Company {
  public String country;
  public String number;

  public Company(String country, String number) {
    this.country = country;
    this.number = number;
  }

  public Company() {
  }

  @Override
  public String toString() {
    return "Company{" +
    "country='" + country + '\'' +
    ", number='" + number + '\'' +
    '}';
  }
}
