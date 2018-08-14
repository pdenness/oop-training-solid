package com.solirius.training.oop.products;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

public class Stock {

    public static MultiValuedMap<StockType, Product> getStock() {

        MultiValuedMap<StockType, Product> stock = new HashSetValuedHashMap();

        for(int i = 0; i<5; i++) {
            Product product = new Product(StockType.COLA);
            stock.put(product.getStockType(), product);
        }

        for(int i = 0; i<5; i++) {
            Product product = new Product(StockType.SPRITE);
            stock.put(product.getStockType(), product);
        }

        for(int i = 0; i<5; i++) {
            Product product = new Product(StockType.FANTA);
            stock.put(product.getStockType(), product);
        }

        for(int i = 0; i<5; i++) {
            Product product = new Product(StockType.LION);
            stock.put(product.getStockType(), product);
        }

        for(int i = 0; i<5; i++) {
            Product product = new Product(StockType.WALKERS);
            stock.put(product.getStockType(), product);
        }

        for(int i = 0; i<5; i++) {
            Product product = new Product(StockType.KITKAT);
            stock.put(product.getStockType(), product);
        }
        return stock;
    }
}
