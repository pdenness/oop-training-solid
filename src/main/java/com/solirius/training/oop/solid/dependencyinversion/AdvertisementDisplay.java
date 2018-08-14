package com.solirius.training.oop.solid.dependencyinversion;

import com.solirius.training.oop.products.StockType;

public interface AdvertisementDisplay {
    void displayContent(StockType stockType);
}
