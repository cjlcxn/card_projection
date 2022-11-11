package com.hibernate.testCard.controller;

import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/card")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/cards")
    public void createCards(@Valid @RequestBody Card card) {
//        cardService.saveCard(card);

    Card card1 = new Card(0, 8444, "Gold", "Active");
        Card card2 = new Card(0, 8476, "Platinum", "Block");

        Card card3 = new Card(0, 8504, "Silver", "Inactive");

        cardService.saveCard(card1);
        cardService.saveCard(card2);
        cardService.saveCard(card3);
    }





}
