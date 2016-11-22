package com.paylike.models.responses;

import com.paylike.models.CardWithId;

/**
 * Created by jankjr on 22/11/2016.
 */
public class SaveCardResponse {
  public CardWithId card;


  @Override
  public String toString() {
    return "SaveCardResponse{" +
    "card=" + card +
    '}';
  }
}
