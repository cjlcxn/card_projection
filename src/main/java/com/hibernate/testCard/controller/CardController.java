package com.hibernate.testCard.controller;

import com.hibernate.testCard.entity.Account;
import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.projections.CardNoAccount;
import com.hibernate.testCard.projections.CardNoStatusAccount;
import com.hibernate.testCard.projections.CardOnlyIdAccount;
import com.hibernate.testCard.services.AccountService;
import com.hibernate.testCard.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private CardService cardService;
    private AccountService accountService;

    @Autowired
    public CardController(CardService cardService, AccountService accountService) {
        this.cardService = cardService;
        this.accountService = accountService;
    }

    // seeding cards, that maps to account (execute this 2nd)
    @PostMapping("/cards")
    public void createCards() {
    Card card1 = new Card(0, 8444, "Gold", "Active");
        Card card2 = new Card(0, 8476, "Platinum", "Block");

        Card card3 = new Card(0, 8504, "Silver", "Inactive");

        List<Account> accounts = accountService.findAllAccounts();

        card1.setAccount(accounts.get(0));
        card2.setAccount(accounts.get(1));
        card3.setAccount(accounts.get(1));

        cardService.saveCard(card1);
        cardService.saveCard(card2);
        cardService.saveCard(card3);
    }
    // cardType has to be capitalized
    @GetMapping("/type/{cardType}")
    public List<CardNoAccount> findCardsNoAccountByType(@PathVariable String cardType) {
        return cardService.findByCardType(cardType);
    }

    // cardStatus has to be capitalized
    @GetMapping("/status/{cardStatus}")
    public List<CardNoAccount> findCardsNoAccountByStatus(@PathVariable String cardStatus) {
        return cardService.findByCardStatus(cardStatus);
    }

    // length is the cardType minimum length
    @GetMapping("/{length}")
    public List<CardNoStatusAccount> findCardsNoStatusByTypeLength(@PathVariable int length) {
        return cardService.findCardNoStatusWhereTypeLengthBiggerThan(length);
    }

    // cardNumber is the minimum card number
    @GetMapping("/id/{cardNumber}")
    public List<CardOnlyIdAccount> findCardIdWhereCardNumLarger(@PathVariable int cardNumber) {
        return cardService.findCardIdWhereCardNumLarger(cardNumber);
    }
}
