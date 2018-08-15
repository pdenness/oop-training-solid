package com.solirius.training.oop.solid.dependencyinversion;

import com.solirius.training.oop.exception.InsufficientPaymentException;
import com.solirius.training.oop.exception.OutOfStockException;
import com.solirius.training.oop.payment.Card;
import com.solirius.training.oop.products.Product;
import com.solirius.training.oop.products.Stock;
import com.solirius.training.oop.products.StockType;

public class App_d {

    public static void main(String[] args)
        throws InsufficientPaymentException, OutOfStockException {

        /* The business has provided advertisement modules which need installing into our vending machines.
        Refactor EmotionalAdVendingMachine & FancyAdVendingMachine to comply with the dependency inversion principle. */

        Card hsbc = new Card(20);

        BasicVendingMachine_d emotionalAdVendingMachine = new EmotionalAdVendingMachine(Stock.getStock());
        Product cola = emotionalAdVendingMachine.purchaseProduct(StockType.COLA, hsbc);

        BasicVendingMachine_d fancyAdVendingMachine = new FancyAdVendingMachine(Stock.getStock());
        Product sprite = fancyAdVendingMachine.purchaseProduct(StockType.SPRITE, hsbc);
    }
}
