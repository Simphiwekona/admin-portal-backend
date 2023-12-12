package com.example.backend.service;

import com.example.backend.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto product(ProductDto productDto);
}
