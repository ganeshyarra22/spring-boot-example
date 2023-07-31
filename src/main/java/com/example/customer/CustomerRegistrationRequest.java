package com.example.customer;

public record CustomerRegistrationRequest(
        String name,
        Integer age,
        String email
) {
}
