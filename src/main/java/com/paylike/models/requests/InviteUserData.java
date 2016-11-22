package com.paylike.models.requests;

/**
 * Created by jankjr on 17/11/2016.
 */
public class InviteUserData {
  public String email;

  public InviteUserData(String email) {
    this.email = email;
  }

  public InviteUserData() {
  }

  @Override
  public String toString() {
    return "InviteUserData{" +
    "email='" + email + '\'' +
    '}';
  }
}
