package com.paylike.models.requests;

import com.paylike.models.Bank;
import com.paylike.models.Company;

/**
 * Created by jankjr on 17/11/2016.
 */

public class MerchantData {
  public String name;
  public String currency;
  public Boolean test;
  public String email;
  public String website;
  public String descriptor;
  public Company company;
  public Bank bank;

  public MerchantData() {
  }



  @Override
  public String toString() {
    return "MerchantData{" +
    "name='" + name + '\'' +
    ", currency='" + currency + '\'' +
    ", test=" + test +
    ", email='" + email + '\'' +
    ", website='" + website + '\'' +
    ", descriptor='" + descriptor + '\'' +
    ", company=" + company +
    ", bank=" + bank +
    '}';
  }

  public MerchantData(String name, String currency, Boolean test, String email, String website, String descriptor, Company company, Bank bank) {
    this.name = name;
    this.currency = currency;
    this.test = test;
    this.email = email;
    this.website = website;
    this.descriptor = descriptor;
    this.company = company;
    this.bank = bank;
  }


}
