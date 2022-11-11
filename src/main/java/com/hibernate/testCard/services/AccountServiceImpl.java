package com.hibernate.testCard.services;

import com.hibernate.testCard.entity.Account;
import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> findAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public Account findAccountById(int accountId) throws RuntimeException {
        Optional<Account> account = accountRepository.findById(accountId);
        Account returningAccount = null;
        if(account.isPresent()) {
            returningAccount = account.get();
        }

        return returningAccount;
    }

    @Override
    public void deleteAccountById(int accountId) {
        accountRepository.deleteById(accountId);
    }
}
