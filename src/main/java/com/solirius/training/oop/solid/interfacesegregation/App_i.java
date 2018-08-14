package com.solirius.training.oop.solid.interfacesegregation;

import com.solirius.training.oop.exception.CardPaymentsNotSupported;
import com.solirius.training.oop.exception.CashPaymentsNotSupportedException;
import com.solirius.training.oop.exception.InsufficientPaymentException;
import com.solirius.training.oop.payment.Card;
import com.solirius.training.oop.products.Product;
import com.solirius.training.oop.products.StockType;
import com.solirius.training.oop.exception.OutOfStockException;
import com.solirius.training.oop.products.Stock;

public class App_i {

    public static void main(String[] args)
        throws OutOfStockException, InsufficientPaymentException, CashPaymentsNotSupportedException, CardPaymentsNotSupported {

        /* The business requires that we support card payments for our vending machines.
        In addition, our designer indicates that more changes are in the backlog. */

        BasicVendingMachine_i basicVendingMachine = new BasicVendingMachine_i(Stock.getStock());

        Product cola = basicVendingMachine.purchaseProduct(StockType.COLA, 0.9);

        Card santanderCard = new Card(100.58);

        CardPaymentVendingMachine_i cardVendingMachine = new CardPaymentVendingMachine_i(Stock.getStock());
        Product lion = cardVendingMachine.purchaseProduct(StockType.LION, santanderCard);
        //cardVendingMachine.purchaseProduct(StockType.FANTA, 0.7);

    }
}
