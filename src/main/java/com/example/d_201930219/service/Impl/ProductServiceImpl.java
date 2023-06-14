package com.example.d_201930219.service.Impl;

import com.example.d_201930219.dao.ProductDAO;
import com.example.d_201930219.dto.Product.ProductDto;
import com.example.d_201930219.dto.Product.ProductResponseDto;
import com.example.d_201930219.entity.Product;
import com.example.d_201930219.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public List<ProductResponseDto> allProduct() {

        List<Product> allList = productDAO.allProduct();
        List<ProductResponseDto> resultAll = allList.stream().map(ProductResponseDto::new).collect(Collectors.toList());

        return resultAll;
    }

    @Override
    public List<ProductResponseDto> listOrderByPrice() {
        List<Product> allList = productDAO.listOrderByPrice();
        List<ProductResponseDto> resultListOrderByPrice = allList.stream().map(ProductResponseDto::new).collect(Collectors.toList());

        return resultListOrderByPrice;
    }

    @Override
    public List<ProductResponseDto> listByName() {
        List<Product> allList = productDAO.listByName();
        List<ProductResponseDto> resultListByName = allList.stream().map(ProductResponseDto::new).collect(Collectors.toList());

        return resultListByName;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product =  new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setUpdateAt(LocalDateTime.now());
        product.setCreateAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changeProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changeProduct.getNumber());
        productResponseDto.setName(changeProduct.getName());
        productResponseDto.setPrice(changeProduct.getPrice());
        productResponseDto.setStock(changeProduct.getStock());
        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}

