package com.example.productservice.application.service.impl;

import com.example.productservice.adapter.in.web.dto.request.ProductCreateDto;
import com.example.productservice.adapter.in.web.dto.request.ProductUpdateDto;
import com.example.productservice.adapter.in.web.dto.response.ProductInfoDto;
import com.example.productservice.adapter.in.web.dto.response.ProductPreviewDto;
import com.example.productservice.adapter.in.web.dto.response.ProductPreviewListDto;
import com.example.productservice.adapter.in.web.mapper.ProductInfoMapper;
import com.example.productservice.adapter.in.web.mapper.ProductPreviewMapper;
import com.example.productservice.application.service.ProductService;
import com.example.productservice.domain.model.Product;
import com.example.productservice.domain.repository.CategoryRepository;
import com.example.productservice.domain.repository.ProductImageRepository;
import com.example.productservice.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductPreviewMapper productPreviewMapper;
    private final ProductInfoMapper productInfoMapper;

    public ProductPreviewListDto getProductsPreviewList(Integer page, Integer size) {
        Page<Product> productsPage = productRepository.findAll(PageRequest.of(page, size));
        List<ProductPreviewDto> products = productsPage.getContent().stream()
                .map(productPreviewMapper::entityToDto)
                .toList();

        return new ProductPreviewListDto(products);
    }

    public ProductInfoDto getProductInfo(Long id) {
        return productInfoMapper.entityToDto(productRepository.findById(id).orElse(null));
    }

    @Override
    public ProductInfoDto createProduct(ProductCreateDto productCreateDto) {
        return null;
    }

    @Override
    public ProductInfoDto updateProduct(ProductUpdateDto productUpdateDto, Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        // TODO
    }
}
