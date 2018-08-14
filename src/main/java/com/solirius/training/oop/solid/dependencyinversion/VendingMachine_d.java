package com.solirius.training.oop.solid.dependencyinversion;

import com.solirius.training.oop.exception.InsufficientPaymentException;
import com.solirius.training.oop.exception.OutOfStockException;
import com.solirius.training.oop.payment.Card;
import com.solirius.training.oop.products.Product;
import com.solirius.training.oop.products.StockType;
import org.apache.commons.collections4.MultiValuedMap;

public class VendingMachine_d {

    private MultiValuedMap<StockType, Product> stock;
    private AdvertisementDisplay advertisementDisplay;

    VendingMachine_d(MultiValuedMap<StockType, Product> stock,
        AdvertisementDisplay advertisementDisplay) {
        this.stock = stock;
        this.advertisementDisplay = advertisementDisplay;
    }

    public void stockUp(MultiValuedMap<StockType, Product> stock) {
        this.stock = stock;
    }

    public MultiValuedMap<StockType, Product> getStock() {
        return stock;
    }

    public Product purchaseProduct(StockType stockType, Card card)
        throws OutOfStockException, InsufficientPaymentException {

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

