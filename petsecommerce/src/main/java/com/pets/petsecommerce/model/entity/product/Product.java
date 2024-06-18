package com.pets.petsecommerce.model.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private String size;
    private Boolean offer;
    private String image;

    private BigDecimal price; // preço fixo/padrão que pode ser o mesmo do previous
    private BigDecimal discountPrice;
    private BigDecimal previousPrice; // ex: R$ 7,50 (previous/antigo) -> R$ 5,50 (discount/oferta)
    @Temporal(TemporalType.DATE)
    private Date initialOffer; // data de inicio de oferta
    @Temporal(TemporalType.DATE)
    private Date expirationOffer;

    @OneToOne
    private ProductCategory category;

    public Product(String name, String color, String size, Boolean offer, String image, BigDecimal price,
                   BigDecimal discountPrice, BigDecimal previousPrice, Date initialOffer,
                   Date expirationOffer, ProductCategory category) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.offer = offer;
        this.image = image;
        this.price = price;
        this.discountPrice = discountPrice;
        this.previousPrice = previousPrice;
        this.initialOffer = initialOffer;
        this.expirationOffer = expirationOffer;
        this.category = category;
    }
}
