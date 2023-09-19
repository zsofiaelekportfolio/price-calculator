package com.zelek.pricecalculator.service.rules;

import com.zelek.pricecalculator.service.model.Basket;
import com.zelek.pricecalculator.service.model.ProductType;
import org.springframework.stereotype.Component;

@Component

public class RuleThreeForTwo implements IntermediateRule{
    private static final Integer REQUIRED_NUMBER_OF_D = 3;

    @Override
    public boolean check(Basket basket) {
        Integer counterD = countProductFrequency(basket,ProductType.D);

        return counterD>=REQUIRED_NUMBER_OF_D;
        }


    @Override
    public Integer calculateAdjustment(Basket basket, Double totalValueAllDiscountApplied) {
        Integer counterD = countProductFrequency(basket,ProductType.D);
        Integer numberOfDiscountedItems = counterD/REQUIRED_NUMBER_OF_D;
        return (-1)*ProductType.D.getPrice()*numberOfDiscountedItems;
    }
}
