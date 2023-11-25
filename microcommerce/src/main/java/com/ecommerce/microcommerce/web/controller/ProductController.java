package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
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

    @PostMapping("/Products")
    public ResponseEntity<?> addProduct(@Validated @RequestBody Product product) {// replace Valid with Validated
                                                                                  // because I don't find Valid
        Product productAdded = productDao.save(product);
        return ResponseEntity.ok().body(productAdded); // la response qui est OK
        // Unauthorized ou Not found, body ou tu peux mettre la donnee que tu veux
        // renvoyer
    }

    @PutMapping("/Products")
    public void updateProduct(@RequestBody Product product) {
        productDao.save(product);
    }

    @DeleteMapping("/Products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productDao.deleteById(id);
    }

}
