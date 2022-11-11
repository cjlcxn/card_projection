package com.hibernate.testCard.projections;

import com.hibernate.testCard.entity.Account;

public class CardOnlyIdAccount {

    private int id;
    private AccountNoCards account;

    public CardOnlyIdAccount(int id, AccountNoCards account) {
        this.id = id;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AccountNoCards getAccount() {
        return account;
    }

    public void setAccount(AccountNoCards account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "CardOnlyIdAccount{" +
                "id=" + id +
                '}';
    }
}
