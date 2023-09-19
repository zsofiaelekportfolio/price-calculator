package com.zelek.pricecalculator.service.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Basket {
    List<Product> products;

    public List<ProductType> getProductTypes(){
        return products.stream()
                .map(product -> product.getName())
                .collect(Collectors.toList());
    }

    public Double getTotalWithoutDiscounts() {
        Double sum = 0D;
        for (ProductType product : getProductTypes()) { // Use 'items' instead of 'basket'
            Integer price = product.getPrice();
            if (price != null) {
                sum += price; // Use simple arithmetic addition
            }
        }
        return sum;
    }
}


