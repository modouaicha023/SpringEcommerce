package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/Products")
    public ResponseEntity<?> getProducts() {
        //return productDao.findAll();// return tab d'objet
        return  ResponseEntity.ok().body(productDao.findAll());// return a http response
    }

    @GetMapping("/Products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDao.findById(id);
    }

    @PostMapping("/Products")
    public ResponseEntity<Product> AddProduct(@Validated @RequestBody Product product) {//replace Valid with Validated because I don't find Valid
        Product productAdded = productDao.save(product);
        return ResponseEntity.ok().body(productAdded); // la response qui est OK Unauthorized ou Not found, body ou tu peux mettre la donnee que tu veux renvoyer
    }

}
