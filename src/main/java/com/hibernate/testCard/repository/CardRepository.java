package com.hibernate.testCard.repository;

import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.projections.CardNoAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer>{
    // Data method query + DTO interface projection
    List<CardNoAccount> findByCardType(String cardType);

    // dynamic DTO interface projection

    // @Query annotation + DTO class projection


}
