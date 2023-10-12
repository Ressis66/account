package ru.vaganov.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vaganov.account.models.Account;
import ru.vaganov.account.service.AccountService;

@SpringBootTest
class AccountApplicationTests {

	@Autowired
	private AccountService accountService;

	@Test
	void contextLoads() {
		Account account1 = accountService.createAccount(22, 1245);
		Account account2 = new Account(22, 1245);
		Assertions.assertEquals(account1.getPinCode(), account2.getPinCode());

	}

}
