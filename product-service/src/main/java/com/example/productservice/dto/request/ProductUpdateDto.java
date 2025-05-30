package com.example.productservice.dto.request;

import com.example.productservice.dto.response.CategoryDto;
import com.example.productservice.dto.response.ProductImageDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateDto {
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryDto category;
    private List<ProductImageDto> images;
    private Integer stockQuantity;
    private String brand;
    private Boolean isActive;
    private LocalDateTime createdAt;
}