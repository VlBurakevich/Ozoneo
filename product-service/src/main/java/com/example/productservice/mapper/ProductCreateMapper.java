package com.example.productservice.mapper;

import com.example.productservice.dto.request.ProductCreateDto;
import com.example.productservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCreateMapper {
    ProductCreateDto toProductCreateDto(Product product);

    Product toProduct(ProductCreateDto productCreateDto);
}
