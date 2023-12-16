package com.ecommerce.microcommerce.dao;

import java.util.List;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    // User findById(int id);
    List<Product> findProducts(int userId);
}
