package com.paylike.exceptions;

/**
 * Created by jankjr on 22/11/2016.
 */
public class PaylikeUnauthorizedException extends PaylikeError {
  public PaylikeUnauthorizedException(String msg, int statuscode) {
    super(msg, statuscode);
  }
}
