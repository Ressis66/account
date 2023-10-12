package ru.vaganov.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vaganov.account.controller.response.AccountResponse;
import ru.vaganov.account.models.Account;
import ru.vaganov.account.repositories.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

  private AccountRepository  accountRepository;

  public AccountServiceImpl(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }


  @Override
  public List<AccountResponse> getAllAccounts() {
    List<Account> accounts = accountRepository.findAll();
    List<AccountResponse> accountResponses = new ArrayList<>();
    for(Account account: accounts){
      accountResponses.add(new AccountResponse(account.getName(), account.getAccountBalance()));
    }
    return accountResponses;
  }


  @Override
  public Account createAccount(long name, long pinCode) {
      Account account = new Account(name, pinCode);
      accountRepository.save(account);
      return account;
  }


  @Override
  public void deposit(long id, long sum) {
      Account account1 = accountRepository.findById(id).orElseThrow();
      long initSum = account1.getAccountBalance();
      long lastSum = initSum + sum;
      account1.setAccountBalance(lastSum);
      accountRepository.save(account1);
  }


  @Override
  public void withdraw(long id, long pinCode, long sum){
    Account account1 = accountRepository.findById(id).orElseThrow();
    if (account1.getPinCode() == pinCode) {
    long initSum = account1.getAccountBalance();
     if(initSum>=sum){
        long lastSum = initSum - sum;
        account1.setAccountBalance(lastSum);
     } else System.out.println("Too small initial sum!");
     accountRepository.save(account1);
     } else System.out.println("Wrong pinCode!");
  }



  @Override
  public void transfer(long firstId, long secondId, long firstPinCode, long sum){
      Account account1 = accountRepository.findById(firstId).orElseThrow();
      Account account2 = accountRepository.findById(secondId).orElseThrow();
      if (account1.getPinCode() == firstPinCode) {
        long initSum1 = account1.getAccountBalance();
        long initSum2 = account2.getAccountBalance();
        if (initSum1 >= sum) {
          long lastSum = initSum1 - sum;
          account1.setAccountBalance(lastSum);
          long lastSecondSum = initSum2 + sum;
          account2.setAccountBalance(lastSecondSum);
        } else System.out.println("Too small initial sum!");
      } else System.out.println("Wrong pinCode!");
      accountRepository.save(account1);
      accountRepository.save(account2);
    }

}
