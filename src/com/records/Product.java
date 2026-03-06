package com.records;

import org.junit.platform.commons.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;

public record Product(String name, BigDecimal cost, String type) {

    //implementing validation
    public Product {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name!");
        }

        if (cost.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid Cost Moron!");
        }
    }

    //Giving default values to parameters
    public Product(String name, BigDecimal cost) {//Our custom constructor
        this(name, cost, "DEFAULT");// calling canonical constructor using this block
    }
}
