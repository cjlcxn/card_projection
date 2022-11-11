package com.hibernate.testCard.projections;

public class AccountNoCards {
    private int id;
    private double transactionLimit;
    private String accountCategory;
    private String accountStatus;

    public AccountNoCards(int id, double transactionLimit, String accountCategory, String accountStatus) {
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
}
