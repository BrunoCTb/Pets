package com.pets.petsecommerce.dto;

public record RegisterDto(
        String username,
        String email,
        String password,
        byte role
) {
}
