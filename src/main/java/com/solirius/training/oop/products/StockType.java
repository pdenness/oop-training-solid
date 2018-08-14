package com.solirius.training.oop.products;

public enum StockType {
    KITKAT(0.89),
    WALKERS(0.75),
    LION(0.79),
    COLA(0.79),
    SPRITE(0.69),
    FANTA(0.79);

    private Double cost;

    StockType(Double cost) {
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }
}
