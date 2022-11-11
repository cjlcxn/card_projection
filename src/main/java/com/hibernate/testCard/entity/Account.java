package com.hibernate.testCard.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "transaction_limit")
    private double transactionLimit;

    @Column(name = "account_category")
    @NotNull
    @Size(min = 3, message = "minimum 3 letter")
    private String accountCategory;

    @Column(name = "account_status")
    @NotNull
    @Size(min = 3, message = "minimum 3 letter")
    private String accountStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Card> cards;

    public Account() {
    }

    public Account(int id, double transactionLimit, String accountCategory, String accountStatus) {
        this.id = id;
        this.transactionLimit = transactionLimit;
        this.accountCategory = accountCategory;
        this.accountStatus = accountStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public String getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(String accountCategory) {
        this.accountCategory = accountCategory;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", transactionLimit=" + transactionLimit +
                ", accountCategory='" + accountCategory + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
