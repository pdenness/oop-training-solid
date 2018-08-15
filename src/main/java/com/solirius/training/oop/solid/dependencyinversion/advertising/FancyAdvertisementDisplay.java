package com.solirius.training.oop.solid.dependencyinversion.advertising;

import com.solirius.training.oop.products.StockType;

public class FancyAdvertisementDisplay {

    public void displayContent(StockType stockType) {
        System.out.println("The fanciest of all products, the " + stockType
            + " is going to represent who you want to become. It's yours for just £" + stockType.getCost() + "!!!");
    }
}
