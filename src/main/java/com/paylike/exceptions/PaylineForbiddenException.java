package com.paylike.exceptions;

/**
 * Created by jankjr on 22/11/2016.
 */
public class PaylineForbiddenException extends PaylikeError {
  public PaylineForbiddenException(String responseMessage, int responseCode) {super(responseMessage, responseCode);}
}
