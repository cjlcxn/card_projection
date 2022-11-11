package com.hibernate.testCard.services;


import com.hibernate.testCard.entity.Card;
import com.hibernate.testCard.projections.CardNoAccount;
import com.hibernate.testCard.projections.CardNoStatusAccount;
import com.hibernate.testCard.projections.CardOnlyIdAccount;
import com.hibernate.testCard.repository.card_repo.CardRepository;
import com.hibernate.testCard.repository.card_repo.CustomCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    private CustomCardRepository customCardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, CustomCardRepository customCardRepository) {
        this.cardRepository = cardRepository;
        this.customCardRepository = customCardRepository;
    }

    @Override
    public List<CardNoAccount> findByCardType(String cardType) {
        List<CardNoAccount> cards = cardRepository.findByCardType(cardType);
        return cards;
    }

    @Override
    public List<CardNoAccount> findByCardStatus(String cardStatus) {
        List<CardNoAccount> cards = cardRepository.findByCardStatus(cardStatus, CardNoAccount.class);
        return cards;
    }

    @Override
    public List<CardNoStatusAccount> findCardNoStatusWhereTypeLengthBiggerThan(int lengthOfChar) {
        List<CardNoStatusAccount> cards = cardRepository.findCardNoStatusWhereTypeLengthBiggerThan(lengthOfChar);
        System.out.println(cards);
        return cards;
    }

    @Override
    public List<CardOnlyIdAccount> findCardIdWhereCardNumLarger(int cardNoMin) {
        return customCardRepository.findCardIdWhereCardNumLarger(cardNoMin);
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
