package com.paylike.models.requests;

/**
 * Created by jankjr on 17/11/2016.
 */
public class UpdateMerchantData {
  public String name;
  public String email;
  public String descriptor;


  @Override
  public String toString() {
    return "UpdateMerchantData{" +
    "name='" + name + '\'' +
    ", email='" + email + '\'' +
    ", descriptor='" + descriptor + '\'' +
    '}';
  }

  public UpdateMerchantData(String name, String email, String descriptor) {
    this.name = name;
    this.email = email;
    this.descriptor = descriptor;
  }




}
