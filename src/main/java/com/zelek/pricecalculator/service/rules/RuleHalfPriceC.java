package com.zelek.pricecalculator.service.rules;

import com.zelek.pricecalculator.service.model.Basket;
import com.zelek.pricecalculator.service.model.ProductType;
import org.springframework.stereotype.Component;

@Component
public class RuleHalfPriceC implements IntermediateRule {
    private static final Integer REQUIRED_NUMBER_OF_A = 2;
    private static final Integer REQUIRED_NUMBER_OF_C = 1;

    @Override
    public boolean check(Basket basket) {
        Integer counterA = countProductFrequency(basket,ProductType.A);

        Integer counterC = countProductFrequency(basket,ProductType.C);

        if ((counterA.equals(REQUIRED_NUMBER_OF_A)) && (counterC.equals(REQUIRED_NUMBER_OF_C))) {
            return true;
        }

        return false;
    }

    @Override
    public Integer calculateAdjustment(Basket basket, Double totalValueAllDiscountApplied) {
        return (-1)*ProductType.C.getPrice() / 2;
    }
}
