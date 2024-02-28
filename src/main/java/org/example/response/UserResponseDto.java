package org.example.response;

import org.example.request.Address;
import org.example.request.Company;

public record UserResponseDto(
    Long id,
    String name,
    String username,
    String email,
    Address address,
    String phone,
    String website,
    Company company
) {

}
