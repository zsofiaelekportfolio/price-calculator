package com.zelek.pricecalculator.service.model;

public enum ProductType {
    A(55),
    B(40),
    C(35),
    D(30),
    E(20);

    private final Integer price;

    ProductType(Integer price) {
        this.price = price;

    }

    public Integer getPrice(){
        return price;
    }
}
