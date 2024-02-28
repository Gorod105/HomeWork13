package org.example.request;

import lombok.Builder;

@Builder
public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo
) {
}
