package com.paylike.exceptions;

/**
 * Created by jankjr on 22/11/2016.
 */
public class PaylikeConflictException extends PaylikeException {
  public PaylikeConflictException(String msg, int statuscode) {
    super(msg, statuscode);
  }
}
