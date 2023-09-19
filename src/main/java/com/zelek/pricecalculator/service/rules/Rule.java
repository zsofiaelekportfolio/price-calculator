package com.zelek.pricecalculator.service.rules;


import com.zelek.pricecalculator.service.model.Basket;
import com.zelek.pricecalculator.service.model.ProductType;

public interface Rule {

    boolean check(Basket basket);

    Integer calculateAdjustment(Basket basket, Double totalValueAllDiscountApplied);

    default int countProductFrequency(Basket basket, ProductType productType){
        Integer counter = 0;
        for (ProductType p : basket.getProductTypes()) {
            if (p == productType) {
                counter++;
            }
        }
        return counter;
    }
}
