package com.example.productservice.security;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class JwtService {

    @Value("${jwt.security.key}")
    private String secret;

    @Value("${jwt.security.key}")
    private int lifetime;

}
