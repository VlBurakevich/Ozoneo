package com.example.productservice.domain.repository;

import com.example.productservice.domain.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

}
