package com.example.productservice.mapper;

import com.example.productservice.dto.response.ProductPreviewDto;
import com.example.productservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPreviewMapper {
    ProductPreviewDto entityToDto(Product product);
}
