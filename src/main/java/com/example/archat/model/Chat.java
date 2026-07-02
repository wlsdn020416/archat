package com.example.archat.model;

public record Chat(
        String message,
        String owner,
        String model,
        String timestamp
) {
}
