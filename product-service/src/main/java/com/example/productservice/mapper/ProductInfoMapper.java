package com.example.productservice.mapper;

import com.example.productservice.dto.response.ProductInfoDto;
import com.example.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductInfoMapper {
    ProductInfoDto entityToDto(Product product);

    void updateEntityToDto(ProductInfoDto dto, @MappingTarget Product product);
}
