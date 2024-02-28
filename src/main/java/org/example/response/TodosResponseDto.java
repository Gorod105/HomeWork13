package org.example.response;

public record TodosResponseDto(
        Long userId,
        Long id,
        String title,
        Boolean completed
) {
}
