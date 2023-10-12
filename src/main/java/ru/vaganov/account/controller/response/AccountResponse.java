package ru.vaganov.account.controller.response;

public class AccountResponse {
  Long name;
  Long sum;

  public AccountResponse(Long name, Long sum) {
    this.name = name;
    this.sum = sum;
  }

  public Long getName() {
    return name;
  }

  public void setName(Long name) {
    this.name = name;
  }

  public Long getSum() {
    return sum;
  }

  public void setSum(Long sum) {
    this.sum = sum;
  }

  @Override
  public String toString() {
    return "AccountResponse{" +
        "name=" + name +
        ", sum=" + sum +
        '}';
  }
}
