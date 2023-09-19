package com.zelek.pricecalculator.controller;

import com.zelek.pricecalculator.controller.dto.OrderRequest;
import com.zelek.pricecalculator.service.PriceCalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "orders")
public class BasketRestController {
    private final PriceCalculatorService priceCalculatorService;

    public BasketRestController(PriceCalculatorService priceCalculatorService) {
        this.priceCalculatorService = priceCalculatorService;
    }

    @PostMapping
    public ResponseEntity<Double> calculatePrice(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(priceCalculatorService.calculate(orderRequest.getBasket()));
    }
}
