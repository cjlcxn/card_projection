package com.hibernate.testCard.services;

import com.hibernate.testCard.entity.Account;
import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.projections.CardNoAccount;

import java.util.List;

public interface CardService {

    List<CardNoAccount> findByCardCategory(String cardCategory);

    void saveCard(Card card);
    List<Card> findAllCards();
    Card findCardById(int cardId);
    void deleteCardById(int cardId);

}
