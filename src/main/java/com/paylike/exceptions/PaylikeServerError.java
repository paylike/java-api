package com.paylike.exceptions;

/**
 * Created by jankjr on 22/11/2016.
 */
public class PaylikeServerError extends PaylikeException {
  public PaylikeServerError(String msg, int statuscode) {
    super(msg, statuscode);
  }
}
