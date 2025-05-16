package com.example.productservice.adapter.in.web.mapper;

import com.example.productservice.adapter.in.web.dto.response.ProductInfoDto;
import com.example.productservice.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductInfoMapper {
    ProductInfoDto entityToDto(Product product);

    void updateEntityToDto(ProductInfoDto dto, @MappingTarget Product product);
}
