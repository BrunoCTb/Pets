package com.pets.petsecommerce.model.entity.product;

import com.pets.petsecommerce.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private String size;
    private String offer;
    private String image;

    private BigDecimal price; // preço fixo/padrão que pode ser o mesmo do previous
    private BigDecimal discountPrice;
    private BigDecimal previousPrice; // e x: R$ 7,50 (previous/antigo) -> R$ 5,50 (discount/oferta)
    private LocalDate initialOffer; // data de inicio de oferta
    private LocalDate expirationOffer;

    @OneToOne
    private ProductCategory category;

    public Product(String name, String color, String size, String offer, String image, BigDecimal price,
                   BigDecimal discountPrice, BigDecimal previousPrice, LocalDate initialOffer,
                   LocalDate expirationOffer, ProductCategory category) {
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
