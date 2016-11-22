package com.paylike.exceptions;

/**
 * Created by jankjr on 22/11/2016.
 */
public class PaylikeException extends Exception {
  private final String msg;
  private final int statuscode;

  public PaylikeException(String msg, int statuscode){
    super(msg);
    this.msg = msg;
    this.statuscode = statuscode;
  }
}
