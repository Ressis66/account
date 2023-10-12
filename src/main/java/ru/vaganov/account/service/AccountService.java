package ru.vaganov.account.service;

import ru.vaganov.account.controller.response.AccountResponse;
import ru.vaganov.account.models.Account;

import java.util.List;

public interface AccountService {
  List<AccountResponse> getAllAccounts();
  Account createAccount(long name, long pinCode);
  void deposit(long id, long sum);
  void withdraw(long id, long pinCode, long sum);
  void transfer(long firstId, long secondId, long firstPinCode, long sum);
}
