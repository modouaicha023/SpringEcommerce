package com.ecommerce.microcommerce.service;

import com.ecommerce.microcommerce.dto.ProductDto;
import com.ecommerce.microcommerce.model.Product;

public interface ProductService {

    Product createProduct(ProductDto productDto);

    void update(ProductDto productDto);
}
