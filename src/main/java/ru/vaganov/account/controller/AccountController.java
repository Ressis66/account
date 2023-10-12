package ru.vaganov.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vaganov.account.controller.request.TransferRequest;
import ru.vaganov.account.controller.response.AccountResponse;
import ru.vaganov.account.controller.response.TransferResponse;
import ru.vaganov.account.models.Account;
import ru.vaganov.account.service.AccountService;

import java.util.List;

@RestController
public class AccountController {

  private AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/accounts")
  private List<AccountResponse> getAllAccounts() {
    return accountService.getAllAccounts();
  }

  @PostMapping("/create")
  private Account createAccount(@RequestParam String name,
                                @RequestParam String pinCode){
    return accountService.createAccount(Long.parseLong(name), Long.parseLong(pinCode));

  }

  @PostMapping("/deposit")
  private void depositMoney(@RequestParam String id,
                            @RequestParam String sum){
    accountService.deposit(Long.parseLong(id),Long.parseLong(sum));

  }
  @PostMapping("/withdraw")
  private void withdrawMoney(@RequestParam String id,
                            @RequestParam String pinCode,
                            @RequestParam String sum){
    accountService.withdraw(Long.parseLong(id),
                            Long.parseLong(pinCode),
                            Long.parseLong(sum));

  }
  @PostMapping("/transfer")
  @ResponseBody
  private TransferResponse transferMoney(@RequestBody TransferRequest transferRequest){
    accountService.transfer(transferRequest.getFirstId(),
        transferRequest.getSecondId(),
        transferRequest.getPinCode(),
        transferRequest.getSum());
     return new TransferResponse("Success!!!");
  }

}
