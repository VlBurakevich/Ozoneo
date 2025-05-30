package com.example.productservice.service.impl;

import com.example.productservice.dto.request.ProductCreateDto;
import com.example.productservice.dto.request.ProductUpdateDto;
import com.example.productservice.dto.response.ProductInfoDto;
import com.example.productservice.dto.response.ProductPreviewDto;
import com.example.productservice.dto.response.ProductPreviewListDto;
import com.example.productservice.mapper.ProductCreateMapper;
import com.example.productservice.mapper.ProductInfoMapper;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.mapper.ProductPreviewMapper;
import com.example.productservice.service.ProductService;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.CategoryRepository;
import com.example.productservice.repository.ProductImageRepository;
import com.example.productservice.repository.ProductRepository;
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
    private final ProductCreateMapper productCreateMapper;
    private final ProductMapper productMapper;

    public ProductPreviewListDto getProductsPreviewList(Integer page, Integer size) {
        Page<Product> productsPage = productRepository.findAll(PageRequest.of(page, size));
        List<ProductPreviewDto> products = productsPage.getContent().stream()
                .map(productPreviewMapper::entityToDto)
                .toList();

        return new ProductPreviewListDto(products);
    }

    public ProductInfoDto getProductInfo(Long id) {
        return productInfoMapper.entityToDto(productRepository.findById(id).orElseThrow(RuntimeException::new)); //TODO make exception
    }

    @Override
    public ProductInfoDto createProduct(ProductCreateDto productCreateDto) {
        Product product = productCreateMapper.toProduct(productCreateDto);

        return productInfoMapper.entityToDto(productRepository.save(product));
    }

    @Override
    public ProductInfoDto updateProduct(ProductUpdateDto productUpdateDto, Long id) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new );//TODO make exception
        productMapper.updateEntityToDto(product, productUpdateDto);
        return productInfoMapper.entityToDto(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException(); //TODO make exception
        }
        productRepository.deleteById(id);
    }
}
