package com.hibernate.testCard.services;

import com.hibernate.testCard.entity.Account;
import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.projections.CardNoAccount;

import java.util.List;

public interface AccountService {

    void saveAccount(Account account);
    List<Account> findAllAccounts();
    Account findAccountById(int accountId);
    void deleteAccountById(int accountId);
}
