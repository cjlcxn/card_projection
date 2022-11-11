package com.hibernate.testCard.repository.card_repo;


import com.hibernate.testCard.projections.CardOnlyIdAccount;

import java.util.List;

public interface CustomCardRepository {

    List<CardOnlyIdAccount> findCardIdWhereCardNumLarger(int cardNoMin);
}
