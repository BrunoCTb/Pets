package com.pets.petsecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

    private String name;
    private String price;
    private String color;
    private String size;
    private String offer;
    private String image;

}
