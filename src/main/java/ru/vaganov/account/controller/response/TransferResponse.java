package ru.vaganov.account.controller.response;

public class TransferResponse {
  private String text;

  public TransferResponse(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "TransferResponse{" +
        "text='" + text + '\'' +
        '}';
  }
}
