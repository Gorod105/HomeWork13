package org.example.request;

import lombok.Builder;

@Builder
public record UserRequestDto(
    String name,
    String username,
    String email,
    Address address,
    String phone,
    String website,
    Company company
) {

}
