package com.paylike.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jankjr on 22/11/2016.
 */
public class TrailEntry {
  public long amount;
  public long balance;
  public String created;
  public Fee fee;

  @SerializedName(value = "void")
  public boolean voided;

  @Override
  public String toString() {
    return "Trail{" +
    "amount=" + amount +
    ", balance=" + balance +
    ", created='" + created + '\'' +
    ", fee=" + fee +
    ", voided=" + voided +
    '}';
  }
}
