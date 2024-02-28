package org.example.response;

public record PostResponseDto(
        Long userId,
        Long id,
        String title,
        String body
) {
}
