package com.example.productservice.service;

import com.example.productservice.dto.request.ProductCreateDto;
import com.example.productservice.dto.request.ProductUpdateDto;
import com.example.productservice.dto.response.ProductInfoDto;
import com.example.productservice.dto.response.ProductPreviewListDto;

public interface ProductService {
    ProductPreviewListDto getProductsPreviewList(Integer page, Integer size);

    ProductInfoDto getProductInfo(Long id);

    ProductInfoDto createProduct(ProductCreateDto productCreateDto);

    ProductInfoDto updateProduct(ProductUpdateDto productUpdateDto, Long id);

    void deleteProduct(Long id);
}
