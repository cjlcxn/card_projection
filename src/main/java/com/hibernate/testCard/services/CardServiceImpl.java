package com.hibernate.testCard.services;


import com.hibernate.testCard.entity.Account;
import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.projections.CardNoAccount;
import com.hibernate.testCard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public List<CardNoAccount> findByCardCategory(String cardCategory) {
        return null;
    }

    @Override
    public void saveCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public List<Card> findAllCards() {
        List<Card> cards = cardRepository.findAll();
        return cards;
    }

    @Override
    public Card findCardById(int cardId) throws RuntimeException{
        Optional<Card> card = cardRepository.findById(cardId);
        Card returningCard = null;
        if(card.isPresent()) {
            returningCard = card.get();
        }

        return returningCard;

    }

    @Override
    public void deleteCardById(int cardId) {
        cardRepository.deleteById(cardId);
    }
}
