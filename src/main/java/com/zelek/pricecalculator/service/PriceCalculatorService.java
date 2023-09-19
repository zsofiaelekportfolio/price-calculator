package com.zelek.pricecalculator.service;

import com.zelek.pricecalculator.service.model.Basket;
import com.zelek.pricecalculator.service.rules.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {

    private final LastRule lastRule;
    private final List<IntermediateRule> rules;

    public PriceCalculatorService(LastRule lastRule, List<IntermediateRule> rules) {
        this.lastRule = lastRule;
        this.rules = rules;
    }

    public Double calculate(Basket basket){
        Double totalValue = basket.getTotalWithoutDiscounts();
        for(Rule r:rules ){
            if (r.check(basket)){
                totalValue+=r.calculateAdjustment(basket,null);
            }
        }
        if(lastRule.check(basket)) {
            totalValue += lastRule.calculateAdjustment(basket, totalValue);
        }
        return totalValue;    }
}
