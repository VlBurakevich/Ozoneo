package com.example.productservice.dto.response;

@
public class ProductImageDto {
    private Long id;
    private Long productId;
    private String imageUrl;
    private ProductImageDto parentProductImageDto;
}
