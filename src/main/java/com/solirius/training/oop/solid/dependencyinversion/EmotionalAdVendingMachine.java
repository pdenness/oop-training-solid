package com.solirius.training.oop.solid.dependencyinversion;

import com.solirius.training.oop.exception.InsufficientPaymentException;
import com.solirius.training.oop.exception.OutOfStockException;
import com.solirius.training.oop.payment.Card;
import com.solirius.training.oop.products.Product;
import com.solirius.training.oop.products.StockType;
import com.solirius.training.oop.solid.dependencyinversion.advertising.EmotionalAdvertismentDisplay;
import org.apache.commons.collections4.MultiValuedMap;

public class EmotionalAdVendingMachine implements BasicVendingMachine_d {

    /* This class breaks dependency inversion principle because the advertising class is tightly coupled with this class.*/

    private MultiValuedMap<StockType, Product> stock;
    private EmotionalAdvertismentDisplay advertisementDisplay;

    public EmotionalAdVendingMachine(MultiValuedMap<StockType, Product> stock) {
        this.stock = stock;
    }

    public void stockUp(MultiValuedMap<StockType, Product> stock) {
        this.stock = stock;
    }

    public MultiValuedMap<StockType, Product> getStock() {
        return stock;
    }

    public Product purchaseProduct(StockType stockType, Card card)
        throws OutOfStockException, InsufficientPaymentException {

        advertisementDisplay = new EmotionalAdvertismentDisplay();
        advertisementDisplay.displayContent(stockType);

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

}

