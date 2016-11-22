package com.paylike.models.requests;

/**
 * Created by jankjr on 22/11/2016.
 */
public class SaveCardData {
  private String transactionId;
  private String notes;

  public SaveCardData(String transactionId, String notes) {
    this.transactionId = transactionId;
    this.notes = notes;
  }

  public SaveCardData(String transactionId) {
    this.transactionId = transactionId;
  }

  @Override
  public String toString() {
    return "SaveCardData{" +
    "transactionId='" + transactionId + '\'' +
    ", notes='" + notes + '\'' +
    '}';
  }
}
