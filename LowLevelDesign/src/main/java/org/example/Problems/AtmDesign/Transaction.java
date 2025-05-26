package org.example.Problems.AtmDesign;

import java.util.UUID;

public class Transaction {
    private String id;
    private TransactionStatus transactionStatus;
    private Double amount;
    private User user;
    private Card card;
    private Account account;

    public Transaction(Double amount, User user, Card card, Account account) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.user = user;
        this.card = card;
        this.account = account;
        this.transactionStatus = TransactionStatus.IN_PROGRESS;
    }

    public String getId() {
        return id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }

    public Card getCard() {
        return card;
    }

    public Account getAccount() {
        return account;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
