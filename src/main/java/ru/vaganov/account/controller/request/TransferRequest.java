package ru.vaganov.account.controller.request;

public class TransferRequest {
  long firstId;
  long secondId;
  long pinCode;
  long sum;

  public TransferRequest(long firstId, long secondId, long pinCode, long sum) {
    this.firstId = firstId;
    this.secondId = secondId;
    this.pinCode = pinCode;
    this.sum = sum;
  }

  public long getFirstId() {
    return firstId;
  }

  public void setFirstId(long firstId) {
    this.firstId = firstId;
  }

  public long getSecondId() {
    return secondId;
  }

  public void setSecondId(long secondId) {
    this.secondId = secondId;
  }

  public long getPinCode() {
    return pinCode;
  }

  public void setPinCode(long pinCode) {
    this.pinCode = pinCode;
  }

  public long getSum() {
    return sum;
  }

  public void setSum(long sum) {
    this.sum = sum;
  }

  @Override
  public String toString() {
    return "TransferRequest{" +
        "firstId=" + firstId +
        ", secondId=" + secondId +
        ", pinCode=" + pinCode +
        ", sum=" + sum +
        '}';
  }
}
