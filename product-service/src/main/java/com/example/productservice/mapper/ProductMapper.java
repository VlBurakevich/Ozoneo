package com.example.productservice.mapper;

import com.example.productservice.dto.request.ProductUpdateDto;
import com.example.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    void updateEntityToDto(Product product, @MappingTarget ProductUpdateDto productUpdateDto);
}
