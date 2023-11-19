package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {
    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/Products")
    public ResponseEntity<?> getProducts() {
       // List<Product> products = productDao.findAll();

       /* SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.serializeAllExcept("purchasePrice");
        FilterProvider filterLists = new SimpleFilterProvider().addFilter("myDynamicFilter", myFilter);

        MappingJacksonValue filterProducts = new MappingJacksonValue(products);
        filterProducts.setFilters(filterLists);*/
        return productDao.findAll();// return tab d'objet 
    }

    @GetMapping("/Products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDao.findById(id);
    }

    @PostMapping("/Products")
    public ResponseEntity<Product> AddProduct(@Valid @RequestBody Product product) {
        Product productAdded = productDao.save(product);
        return ResponseEntity.ok().body(productAdded); // la reponse qui est OK Unauthorized ou Not found, body ou tu peux mettre la donnee que tu veux renvoyer
    }

}
