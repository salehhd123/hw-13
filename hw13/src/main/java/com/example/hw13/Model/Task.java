package com.example.hw13.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String id;
    private String title;
    private String description;
    private String status;

    public Task() {
    }
}
