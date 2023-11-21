package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductDaoImpl implements ProductDao {

    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Ordinateur portable", 350,200));
        products.add(new Product(2, "Aspirateur Robot", 500,150));
        products.add(new Product(3, "Table de Ping Pong", 750,500));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {

        for(Product product:products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product p) {
        products.add(p);
        return p; //should  return the product
//        return  products.add(p);
    }
}
