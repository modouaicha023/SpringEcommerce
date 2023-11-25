package com.ecommerce.microcommerce.service.impl;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.dto.ProductDto;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setPurchaseprice(productDto.getPurchaseprice());
        return productDao.save(product);
    }

    @Override
    public void update(ProductDto productDto) {
        Product product =  productDao.findById(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setPurchaseprice(productDto.getPurchaseprice());
        productDao.save(product);
    }
}
