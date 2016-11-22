package com.paylike.models;

/**
 * Created by jankjr on 22/11/2016.
 */
public class User {
  public String id;
  public String created;
  public String email;
  public String name;

  @Override
  public String toString() {
    return "User{" +
    "id='" + id + '\'' +
    ", created='" + created + '\'' +
    ", email='" + email + '\'' +
    ", name='" + name + '\'' +
    '}';
  }
}
