package com.paylike.models;

/**
 * Created by jankjr on 21/11/2016.
 */
public class Identity {
  public String id;
  public String name;
  public String created;


  @Override
  public String toString() {
    return "Identity{" +
    "id='" + id + '\'' +
    ", name='" + name + '\'' +
    ", created='" + created + '\'' +
    '}';
  }
}
