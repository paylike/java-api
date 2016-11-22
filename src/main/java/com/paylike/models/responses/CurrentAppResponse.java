package com.paylike.models.responses;

import com.paylike.models.Identity;

/**
 * Created by jankjr on 17/11/2016.
 */
public class CurrentAppResponse {
  public Identity identity;

  @Override
  public String toString() {
    return "CurrentAppResponse{" +
    "identity=" + identity +
    '}';
  }
}
