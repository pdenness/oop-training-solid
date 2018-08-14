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

        /* The business requires that advertising is more persuasive but we need different messages for specific demographics */

        Card hsbc = new Card(20);

        AdvertisementDisplay fancyAdvertisingPanel = new FancyAdvertisementDisplay();
        AdvertisementDisplay guiltAdvertisingPanel = new GuiltAdvertismentDisplay();
        VendingMachine_d VendingMachine = new VendingMachine_d(Stock.getStock(), guiltAdvertisingPanel);
        Product cola = VendingMachine.purchaseProduct(StockType.COLA, hsbc);

    }
}
