package ru.vaganov.account.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column
  private long name;

  @Column
  @Range(min=1000, max=9999)
  private long pinCode;

  @Column
  private long accountBalance;


  public Account() {
  }

  public Account(long name, long pinCode) {
    this.name = name;
    this.pinCode = pinCode;
  }

  public Long getId() {
    return id;
  }

  public Long getName() {
    return name;
  }

  public long getPinCode() {
    return pinCode;
  }

  public void setPinCode(long pinCode) {
    this.pinCode = pinCode;
  }

  public void setAccountBalance(long accountBalance) {
    this.accountBalance = accountBalance;
  }

  public void setName(long name) {
    this.name = name;
  }

  public Long getAccountBalance() {
    return accountBalance;
  }

  @Override
  public String toString() {
    return "Account{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", pinCode=" + pinCode +
        ", accountBalance=" + accountBalance +
        '}';
  }

}
