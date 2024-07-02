package com.pets.petsecommerce.model.category;

import lombok.Getter;
import lombok.ToString;

@Getter
public enum ProductAlternativeCategories {

    DISCOUNTED ("Desconto"),
    NEW ("Novos"),
    BABY_PETS ("Baby Pets"),
    BUNDLE ("Pacotes"),
    POPULAR ("Populares");

    private String value;

    ProductAlternativeCategories(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
