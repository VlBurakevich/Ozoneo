package com.example.productservice.adapter.in.web.mapper;

import com.example.productservice.adapter.in.web.dto.response.ProductPreviewDto;
import com.example.productservice.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPreviewMapper {
    ProductPreviewDto entityToDto(Product product);
}
