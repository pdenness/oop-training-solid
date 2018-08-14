package com.solirius.training.oop.payment;

public class Card {

    private Double balance;

    public Card(double balance) {
        this.balance = balance;
    }

    public boolean isAuthorised(Double price) {
        if(balance > price) {
            return true;
        }

        return false;
    }

    public Double getBalance() {
        return balance;
    }
}
