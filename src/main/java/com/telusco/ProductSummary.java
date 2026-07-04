package com.telusco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ProductSummary {

    private String productName;
    private double price;
    private String categoryName;


}
