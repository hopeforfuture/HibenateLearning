package com.telusco;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="aliens")
@Data
public class Alien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String tech;
    private LocalDate dob;
    @OneToOne
    private Laptop laptop;

}
