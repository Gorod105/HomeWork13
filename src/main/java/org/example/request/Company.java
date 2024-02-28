package org.example.request;

import lombok.Builder;

@Builder
public record Company (
        String name,
        String catchPhrase,
        String bs
){
}
