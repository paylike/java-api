package com.paylike.models;
/**
 * Created by jankjr on 21/11/2016.
 */
public class App {
  public String id;
  public String name;
  public String key;
  public String created;

  @Override
  public String toString() {
    return "App{" +
    "created=" + created +
    ", key='" + key + '\'' +
    ", name='" + name + '\'' +
    ", id='" + id + '\'' +
    '}';
  }
}
