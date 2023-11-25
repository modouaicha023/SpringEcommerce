package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.dto.ProductDto;
import com.ecommerce.microcommerce.model.Product;

import com.ecommerce.microcommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    private final ProductDao productDao;

    private final ProductService productService;

    public ProductController(ProductDao productDao, ProductService productService) {
        this.productDao = productDao;
        this.productService = productService;
    }

    @GetMapping("/Products")
    public ResponseEntity<?> getProducts() {
        // return (ResponseEntity<?>) productDao.findAll();// return tab d'objet
        List<Product> products = productDao.findAll();
        return ResponseEntity.ok().body(products);// return a http response
    }

    @GetMapping("/Products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDao.findById(id);
    }

    @GetMapping(value = "test/products/{limitprice}")
    // @Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :limitprice")
    public List<Product> requestTest(@PathVariable int limitprice) {
        return productDao.findByPriceGreaterThan(400);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@Validated @RequestBody ProductDto productDto) {// replace Valid with Validated
                                                                                  // because I don't find Valid
        Product productAdded = productService.createProduct(productDto);
        return ResponseEntity.ok().body(productAdded); // la response qui est OK
        // Unauthorized ou Not found, body ou tu peux mettre la donnee que tu veux
        // renvoyer
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.update(productDto);
    }

    @DeleteMapping("/Products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productDao.deleteById(id);
    }

}
