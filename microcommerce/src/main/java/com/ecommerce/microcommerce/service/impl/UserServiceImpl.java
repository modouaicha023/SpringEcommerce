package com.ecommerce.microcommerce.service.impl;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.microcommerce.dao.UserDao;
import com.ecommerce.microcommerce.dto.UserDto;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.model.User;
import com.ecommerce.microcommerce.service.UserService;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao UserDao;

    // ...

    @Override
    public User createUser(UserDto UserDto) {
        User user = new User();
        user.setFirstName(UserDto.getFirstName());
        user.setLastName(UserDto.getLastName());
        user.setUsername(UserDto.getUsername());
        user.setPassword(UserDto.getPassword());
        List<Product> products = new ArrayList<>();
        user.setProducts(products);
        return UserDao.save(user);
    }

    @Override
    public void update(UserDto UserDto) {

        Optional<User> optionalUser = UserDao.findById(UserDto.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(UserDto.getFirstName());
            user.setLastName(UserDto.getLastName());
            user.setUsername(UserDto.getUsername());
            user.setPassword(UserDto.getPassword());
            user.setProducts(UserDto.getProducts());
            UserDao.save(user);
        }
        // User user = UserDao.findById(UserDto.getId());
        // user.setFirstName(UserDto.getFirstName());
        // user.setLastName(UserDto.getLastName());
        // user.setUsername(UserDto.getUsername());
        // user.setPassword(UserDto.getPassword());
        // user.setProducts(UserDto.getProducts());
        // UserDao.save(user);
    }

    // @Override
    // public void addProduct(UserDto UserDto, ProductDto productDto) {
    // Optional<User> optionalUser = UserDao.findById(UserDto.getId());

    // if (optionalUser.isPresent()) {
    // User user = optionalUser.get();

    // // Assuming you have a method to convert ProductDto to Product
    // Product productAdded = ProductService.createProduct(productDto);

    // // Add the product to the user's list
    // user.addProduct(product);

    // // Save the updated user to the database
    // UserDao.save(user);
    // }
    // }
}