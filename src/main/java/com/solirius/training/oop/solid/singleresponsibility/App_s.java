package com.solirius.training.oop.solid.singleresponsibility;


import com.solirius.training.oop.exception.InsufficientPaymentException;
import com.solirius.training.oop.exception.OutOfStockException;
import com.solirius.training.oop.payment.Card;
import com.solirius.training.oop.products.Stock;
import com.solirius.training.oop.products.StockType;

public class App_s {

    public static void main(String[] args) throws InsufficientPaymentException, OutOfStockException {

        /* The business requires a vending machine which can accept card payments for products */
        Card llyods = new Card(500);

        VendingMachine_s vendingMachine = new VendingMachine_s(Stock.getStock());
        vendingMachine.purchaseProduct(StockType.WALKERS, llyods);
        vendingMachine.getStock();

    }
}
