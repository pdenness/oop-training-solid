package com.solirius.training.oop.products;

public class Product {

    private StockType stockType;
    private Double price;

    public Product(StockType stockType) {
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

    @Override
    public String toString() {
        return "Product{" +
            "stockType=" + stockType +
            ", price=" + price +
            '}';
    }
}
