package com.hibernate.testCard.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "card_number")
    @Min(1)
    private Integer cardNumber;

    @Column(name = "card_type")
    @NotEmpty
    @Size(min = 3, message = "minimum 3 letter")
    private String cardType;

    @Column(name = "card_status")
    @NotEmpty
    @Size(min = 3, message = "minimum 3 letter")
    private String cardStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "FK_account_id"))
    private Account account;

    public Card() {
    }

    public Card(int id, Integer cardNumber, String cardType, String cardStatus){
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardStatus = cardStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", cardType='" + cardType + '\'' +
                ", cardStatus='" + cardStatus + '\'' +
                ", account=" + account +
                '}';
    }
}
