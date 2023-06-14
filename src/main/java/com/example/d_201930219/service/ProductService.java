package com.example.d_201930219.service;

import com.example.d_201930219.dto.Product.ChangeProductDto;
import com.example.d_201930219.dto.Product.ProductDto;
import com.example.d_201930219.dto.Product.ProductResponseDto;


import java.util.List;

public interface ProductService {

    List<ProductResponseDto> allProduct();

    List<ProductResponseDto> listOrderByPrice();

    List<ProductResponseDto> listByName();

    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName (Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
