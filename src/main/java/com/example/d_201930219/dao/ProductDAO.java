package com.example.d_201930219.dao;

import com.example.d_201930219.entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> allProduct();

    List<Product> listOrderByPrice();

    List<Product> listByName();

    Product insertProduct(Product product);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

    Product selectProduct(Long number);


}
