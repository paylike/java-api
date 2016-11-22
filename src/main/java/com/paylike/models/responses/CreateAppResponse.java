package com.paylike.models.responses;

import com.paylike.models.App;

/**
 * Created by jankjr on 17/11/2016.
 */
public class CreateAppResponse {
  public App app;

  @Override
  public String toString() {
    return "CreateAppResponse{" +
    "app=" + app +
    '}';
  }
}
