package com.paylike.models.responses;

import com.paylike.models.Merchant;

/**
 * Created by jankjr on 17/11/2016.
 */
public class CreateMerchantResponse {
  public Merchant merchant;

  @Override
  public String toString() {
    return "CreateMerchantResponse{" +
    "merchant=" + merchant +
    '}';
  }
}
