package com.zelek.pricecalculator.service.rules;

import com.zelek.pricecalculator.service.model.Basket;
import com.zelek.pricecalculator.service.model.ProductType;
import org.springframework.stereotype.Component;

@Component

public class RuleNotTogether implements LastRule{

    private static final Integer REQUIRED_NUMBER_OF_D = 1;
    private static final Integer REQUIRED_NUMBER_OF_E = 1;
    @Override
    public boolean check(Basket basket) {
        Integer counterD = countProductFrequency(basket, ProductType.D);
        Integer counterE = countProductFrequency(basket,ProductType.E);

        return counterD>=REQUIRED_NUMBER_OF_D && counterE>=REQUIRED_NUMBER_OF_E;
    }

    @Override
    public Integer calculateAdjustment(Basket basket, Double totalValueAllDiscountApplied) {
        return (int)(totalValueAllDiscountApplied*0.3);
    }
}
