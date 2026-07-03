package com.telusco;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Laptop {
    private String brand;
    private String model;
    private int ram;
}
