package com.example.productservice.adapter.in.web.controller;

import com.example.productservice.adapter.in.web.dto.request.ProductCreateDto;
import com.example.productservice.adapter.in.web.dto.request.ProductUpdateDto;
import com.example.productservice.adapter.in.web.dto.response.ProductInfoDto;
import com.example.productservice.adapter.in.web.dto.response.ProductPreviewListDto;
import com.example.productservice.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ProductPreviewListDto getProductsPreviewList(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return productService.getProductsPreviewList(page, size);
    }

    @GetMapping("/{id}")
    public ProductInfoDto getProductInfo(
            @PathVariable Long id
    ) {
        return productService.getProductInfo(id);
    }

    @PostMapping
    public ProductInfoDto createProduct(ProductCreateDto productCreateDto) {
        return productService.createProduct(productCreateDto);
    }

    @PutMapping("/{id}")
    public ProductInfoDto updateProduct(ProductUpdateDto productUpdateDto, @PathVariable Long id) {
        return productService.updateProduct(productUpdateDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(
            @PathVariable Long id
    ) {
        productService.deleteProduct(id);
    }


}
