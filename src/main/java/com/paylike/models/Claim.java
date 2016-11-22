package com.paylike.models;

/**
 * Created by jankjr on 21/11/2016.
 */
public class Claim {
  public boolean canCapture, canRefund, canVoid, canChargeCard, canSaveCard;

  @Override
  public String toString() {
    return "Claim{" +
    "canSaveCard=" + canSaveCard +
    ", canChargeCard=" + canChargeCard +
    ", canVoid=" + canVoid +
    ", canRefund=" + canRefund +
    ", canCapture=" + canCapture +
    '}';
  }
}
