package com.example.archat.model;

public record Chat(
        String message,
        String owner,
        String sessionId,
        String model,
        String timestamp
) {
}
