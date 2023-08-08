package com.example.hw13part2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    private String id;
    private String userName;
    private int balance;

    public Customers() {
    }
}
