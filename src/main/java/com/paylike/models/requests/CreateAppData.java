package com.paylike.models.requests;

/**
 * Created by jankjr on 21/11/2016.
 */
public class CreateAppData {
  public final String name;

  public CreateAppData(String name) { this.name = name;}

  @Override
  public String toString() {
    return "CreateAppData{" +
    "name='" + name + '\'' +
    '}';
  }
}
