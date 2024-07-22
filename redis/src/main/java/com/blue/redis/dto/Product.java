package com.blue.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id ;
    private String name ;
    private int qty;
    private long price;
}
