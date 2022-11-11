package com.hibernate.testCard.projections;

import java.math.BigInteger;

public interface CardNoAccount {
     BigInteger getCardNumber();
     String getCardType();
     String getCardStatus();
}
