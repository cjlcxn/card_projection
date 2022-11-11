package com.hibernate.testCard.repository.card_repo;

import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.projections.CardNoAccount;
import com.hibernate.testCard.projections.CardNoStatusAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer>{
    // Data method query + DTO interface projection
    // returns a card  w/o an account, find by card type
    List<CardNoAccount> findByCardType(String cardType);

    // dynamic DTO interface projection
    // returns card w/o acc, find by card status
    <T> List<T> findByCardStatus(String cardStatus, Class<T> classType);

    // @Query annotation + DTO class projection
    // returns card w/o status and find by card type where length of char > input value
    @Query("SELECT new com.hibernate.testCard.projections.CardNoStatusAccount(c.id, c.cardNumber, c.cardType) FROM Card c LEFT JOIN c.account a WHERE LENGTH(c.cardType) > ?1")
    List<CardNoStatusAccount> findCardNoStatusWhereTypeLengthBiggerThan(int lengthOfChar);


}
