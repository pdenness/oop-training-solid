package com.solirius.training.oop.solid.dependencyinversion.advertising;

import com.solirius.training.oop.products.StockType;

public class EmotionalAdvertismentDisplay {

    public void displayContent(StockType stockType) {
        System.out.println(
            stockType + " are going to go bankrupt, causing thousands of people to become unemployed. For just £"
                + stockType.getCost() + " you can save families from poverty...");
    }
}
