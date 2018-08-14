package com.solirius.training.oop.solid.liskovsubstitution;

import com.solirius.training.oop.products.CharityDonation;
import com.solirius.training.oop.products.StockType;

public class CharityProduct extends Product_l {

    private CharityDonation charityDonation;

    public CharityProduct(StockType stockType) {
        super(stockType);
    }

    public void setCharityDonation(CharityDonation charityDonation) {
        this.charityDonation = charityDonation;
        this.price = stockType.getCost();
    }

    /*
    The getProductSummary method breaks Liskov Substitution because
    it behaves differently to the base class implementation (Should return product name)
     */
    @Override
    public String getProductSummary() {
        return "Donate " + charityDonation.getCost() + " to " + charityDonation.name();
    }

    /*
    The getPrice method complies with Liskov Substitution because
    it returns the expected result (Total price of the product with charity donation).
    */
    @Override
    public Double getPrice() {
        return price + charityDonation.getCost();
    }
}
