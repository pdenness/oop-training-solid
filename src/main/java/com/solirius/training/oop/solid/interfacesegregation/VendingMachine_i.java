package com.solirius.training.oop.solid.interfacesegregation;

import com.solirius.training.oop.exception.CardPaymentsNotSupported;
import com.solirius.training.oop.exception.CashPaymentsNotSupportedException;
import com.solirius.training.oop.exception.InsufficientPaymentException;
import com.solirius.training.oop.payment.Card;
import com.solirius.training.oop.products.StockType;
import com.solirius.training.oop.exception.OutOfStockException;
import com.solirius.training.oop.products.Product;
import org.apache.commons.collections4.MultiValuedMap;

public interface VendingMachine_i {

    /* The problem is the interface is forcing sub classes to implement methods they do not need.
    This is a violation of the interface segregation principle */

    void stockUp(MultiValuedMap<StockType, Product> stock);

    MultiValuedMap<StockType, Product> getStock();

    Product purchaseProduct(StockType stockType, Double cash)
        throws OutOfStockException, InsufficientPaymentException, CashPaymentsNotSupportedException;

    Double getCashBalance() throws CashPaymentsNotSupportedException;

    Product purchaseProduct(StockType stockType, Card card)
        throws CardPaymentsNotSupported, OutOfStockException, InsufficientPaymentException;
}
