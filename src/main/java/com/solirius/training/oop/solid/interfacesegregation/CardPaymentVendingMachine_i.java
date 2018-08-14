package com.solirius.training.oop.solid.interfacesegregation;

import com.solirius.training.oop.exception.CardPaymentsNotSupported;
import com.solirius.training.oop.exception.CashPaymentsNotSupportedException;
import com.solirius.training.oop.exception.InsufficientPaymentException;
import com.solirius.training.oop.exception.OutOfStockException;
import com.solirius.training.oop.payment.Card;
import com.solirius.training.oop.products.Product;
import com.solirius.training.oop.products.StockType;
import org.apache.commons.collections4.MultiValuedMap;

public class CardPaymentVendingMachine_i implements VendingMachine_i {

    private MultiValuedMap<StockType, Product> stock;

    public CardPaymentVendingMachine_i(MultiValuedMap<StockType, Product> stock) {
        this.stock = stock;
    }

    @Override
    public void stockUp(MultiValuedMap<StockType, Product> stock) {
        this.stock = stock;
    }

    @Override
    public MultiValuedMap<StockType, Product> getStock() {
        return stock;
    }

    @Override
    public Product purchaseProduct(StockType stockType, Card card)
        throws CardPaymentsNotSupported, OutOfStockException, InsufficientPaymentException {

        Product selectedProduct = stock.get(stockType)
            .stream()
            .findFirst()
            .orElseThrow(() -> new OutOfStockException());

        if (!card.isAuthorised(selectedProduct.getPrice())) {
            throw new InsufficientPaymentException();
        }

        stock.get(stockType).remove(selectedProduct);

        return selectedProduct;
    }

    @Override
    public Product purchaseProduct(StockType stockType, Double cash)
        throws OutOfStockException, InsufficientPaymentException, CashPaymentsNotSupportedException {
        throw new CashPaymentsNotSupportedException();
    }

    @Override
    public Double getCashBalance() throws CashPaymentsNotSupportedException {
        throw new CashPaymentsNotSupportedException();
    }
}
