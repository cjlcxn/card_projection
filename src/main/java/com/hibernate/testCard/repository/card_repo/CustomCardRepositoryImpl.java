package com.hibernate.testCard.repository.card_repo;

import com.hibernate.testCard.projections.AccountNoCards;
import com.hibernate.testCard.projections.CardOnlyIdAccount;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomCardRepositoryImpl implements CustomCardRepository{
    private EntityManager entityManager;

    @Autowired
    public CustomCardRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CardOnlyIdAccount> findCardIdWhereCardNumLarger(int cardNoMin) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("SELECT " +
                "c.id, a.id, a.transactionLimit, a.accountCategory, a.accountStatus " +
                "FROM " +
                "com.hibernate.testCard.entity.Card c " +
                "LEFT JOIN " +
                "c.account a " +
                "WHERE " +
                "c.cardNumber > ?1");
        try {
            List<Object[]> cards = query.setParameter(1, cardNoMin).getResultList();
            List<CardOnlyIdAccount> result = new ArrayList<>(cards.size());
            for (Object[] card: cards) {
                AccountNoCards acc = new AccountNoCards((int) card[1], (Double)card[2], (String)card[3], (String)card[4]);
                result.add(new CardOnlyIdAccount((Integer) card[0], acc));
            }
            System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
            System.out.println(result.get(0));
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
