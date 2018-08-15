package com.solirius.training.oop.solid.dependencyinversion;

import com.solirius.training.oop.exception.InsufficientPaymentException;
import com.solirius.training.oop.exception.OutOfStockException;
import com.solirius.training.oop.payment.Card;
import com.solirius.training.oop.products.Product;
import com.solirius.training.oop.products.StockType;
import org.apache.commons.collections4.MultiValuedMap;

public interface BasicVendingMachine_d {

    Product purchaseProduct(StockType stockType, Card card)
        throws OutOfStockException, InsufficientPaymentException;

    MultiValuedMap<StockType, Product> getStock();

    void stockUp(MultiValuedMap<StockType, Product> stock);
}
