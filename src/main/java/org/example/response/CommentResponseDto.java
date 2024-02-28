package org.example.response;

public record CommentResponseDto(
        Long postId,
        Long id,
        String name,
        String email,
        String body
) {
}
