package com.hibernate.testCard.controller;

import com.hibernate.testCard.entity.Account;
import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.services.AccountService;
import com.hibernate.testCard.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;
    private CardService cardService;

    @Autowired
    public AccountController(AccountService accountService, CardService cardService) {
        this.accountService = accountService;
        this.cardService = cardService;
    }

    // seeding, execute this before seeding cards
    @PostMapping("/accounts")
    public void createAccounts() {

        Account account1 = new Account(0, 100, "Premium", "Active");
        Account account2 = new Account(0, 150, "Normal", "Inactive");

        accountService.saveAccount(account1);
        accountService.saveAccount(account2);
    }

}
