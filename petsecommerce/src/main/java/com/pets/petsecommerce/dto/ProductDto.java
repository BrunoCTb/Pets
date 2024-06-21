package com.pets.petsecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

    private String name;
    private String color;
    private String size;
    private String offer;
    private String image;

    private String price;
    private String discountPrice;
    private String previousPrice;

    private String initialOffer;
    private String expirationOffer;

    private String category;

}
