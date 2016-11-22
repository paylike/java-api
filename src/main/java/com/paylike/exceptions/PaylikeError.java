package com.paylike.exceptions;

/**
 * Created by jankjr on 22/11/2016.
 */
public class PaylikeError extends Error {
  private final String responseMessage;
  private final int responseCode;

  public PaylikeError(String responseMessage, int responseCode) {
    super(responseMessage);
    this.responseMessage = responseMessage;
    this.responseCode = responseCode;
  }
}
