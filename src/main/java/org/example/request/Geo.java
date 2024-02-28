package org.example.request;

import lombok.Builder;

@Builder
public record Geo (
        String lat,
        String lng
){
}
