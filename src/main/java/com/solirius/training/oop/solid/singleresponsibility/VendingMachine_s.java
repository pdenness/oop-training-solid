package com.solirius.training.oop.solid.singleresponsibility;

import com.solirius.training.oop.exception.InsufficientPaymentException;
import com.solirius.training.oop.exception.OutOfStockException;
import com.solirius.training.oop.payment.Card;
import com.solirius.training.oop.products.Product;
import com.solirius.training.oop.products.StockType;
import org.apache.commons.collections4.MultiValuedMap;

public class VendingMachine_s {

    /*
    This class breaks single responsibility principle because it has more than 1 reason to change.
    For example, if the verification method for cards changes then this class is affected.
    Furthermore, the object can print itself in the getStock method. This is mixes business logic with UI
     */

    private MultiValuedMap<StockType, Product> stock;

    public VendingMachine_s(MultiValuedMap<StockType, Product> stock) {
        this.stock = stock;
    }

    public Product purchaseProduct(StockType stockType, Card card)
        throws OutOfStockException, InsufficientPaymentException {

        Product selectedProduct = stock.get(stockType)
            .stream()
            .findFirst()
            .orElseThrow(() -> new OutOfStockException());

        if (!verifyCard(card, selectedProduct)) {
            throw new InsufficientPaymentException();
        }

        stock.get(stockType).remove(selectedProduct);

        return selectedProduct;
    }

    private boolean verifyCard(Card card, Product selectedProduct) {
        if (card.getBalance() > selectedProduct.getPrice()) {
            return true;
        }
        return false;
    }

    public void getStock() {
        System.out.println(stock.toString());
    }
}
