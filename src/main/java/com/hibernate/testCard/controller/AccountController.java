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

    @PostMapping("/accounts")
    public void createAccounts(@RequestBody Account account) {


        List<Card> cards = cardService.findAllCards();


        List<Card> cards1 = new ArrayList<>();
        cards1.add(cards.get(0));

        List<Card> cards2 = new ArrayList<>();
        cards2.add(cards.get(1));
        cards2.add(cards.get(2));

        Account account1 = new Account(0, 100, "Premium", "Active");
        Account account2 = new Account(0, 150, "Normal", "Inactive");

        account1.setCards(cards1);
        account2.setCards(cards2);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx");
        System.out.println(account2);
        System.out.println(account1);

        accountService.saveAccount(account1);
        accountService.saveAccount(account2);

    }

}
