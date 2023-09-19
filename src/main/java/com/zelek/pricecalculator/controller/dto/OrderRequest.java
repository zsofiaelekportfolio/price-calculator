package com.zelek.pricecalculator.controller.dto;

import com.zelek.pricecalculator.service.model.Basket;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class OrderRequest {
    Basket basket;
}
