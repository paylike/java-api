package com.paylike.models.requests;

/**
 * Created by jankjr on 17/11/2016.
 */

public class AddAppData {
  public String appId;

  public AddAppData(String appId) {
    this.appId = appId;
  }

  public AddAppData() {
  }

  @Override
  public String toString() {
    return "AddAppData{" +
    "appId='" + appId + '\'' +
    '}';
  }
}
