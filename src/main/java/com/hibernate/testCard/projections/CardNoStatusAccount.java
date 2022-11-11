package com.hibernate.testCard.projections;

public class CardNoStatusAccount {
    private int id;
    private int cardNumber;
    private String cardType;

    public CardNoStatusAccount(int id, int cardNumber, String cardType) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "CardNoStatus{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
