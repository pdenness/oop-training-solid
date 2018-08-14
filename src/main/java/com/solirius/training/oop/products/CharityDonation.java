package com.solirius.training.oop.products;

public enum CharityDonation {
    CHILDPROTECTION(0.1),
    HOMELESS(0.05),
    WILDLIFE(0.05);

    private Double cost;

    CharityDonation(Double cost) {
        this.cost = cost;
    }
    public Double getCost() {
        return cost;
    }
}
