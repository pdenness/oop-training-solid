package com.solirius.training.oop.solid.liskovsubstitution;

import com.solirius.training.oop.products.StockType;

public class Product_l {

    protected StockType stockType;
    protected Double price;

    public Product_l(StockType stockType) {
        this.stockType = stockType;
        this.price = stockType.getCost();
    }

    public StockType getStockType() {
        return stockType;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductSummary() {
        return stockType.name() + " costs " + price;
    }
}
