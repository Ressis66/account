package ru.vaganov.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vaganov.account.models.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
