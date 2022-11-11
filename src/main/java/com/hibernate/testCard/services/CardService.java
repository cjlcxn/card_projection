package com.hibernate.testCard.services;

import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.projections.CardNoAccount;
import com.hibernate.testCard.projections.CardNoStatusAccount;
import com.hibernate.testCard.projections.CardOnlyIdAccount;

import java.util.List;

public interface CardService {

    // Data method query + DTO interface projection
    List<CardNoAccount> findByCardType(String cardType);

    // dynamic DTO interface projection
    List<CardNoAccount> findByCardStatus(String cardStatus);

    // @Query annotation + DTO class projection
    List<CardNoStatusAccount> findCardNoStatusWhereTypeLengthBiggerThan(int lengthOfChar);

    // custom query
    List<CardOnlyIdAccount> findCardIdWhereCardNumLarger(int cardNoMin);


    void saveCard(Card card);
    List<Card> findAllCards();
    Card findCardById(int cardId);
    void deleteCardById(int cardId);

}
