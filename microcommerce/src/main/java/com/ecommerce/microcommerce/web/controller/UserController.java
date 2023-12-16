package com.ecommerce.microcommerce.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.UserDao;
import com.ecommerce.microcommerce.dto.UserDto;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.service.UserService;
import com.ecommerce.microcommerce.model.User;

@RestController
public class UserController {
    private final UserDao UserDao;

    private final UserService userService;

    public UserController(UserDao UserDao, UserService userService) {
        this.UserDao = UserDao;
        this.userService = userService;
    }

    @GetMapping("/{user_id}/products")
    public ResponseEntity<?> getUserProducts(@PathVariable int user_id) {
        List<Product> products = UserDao.findProductsById(user_id);
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/profile/{id}")
    public User  getUserById(@PathVariable int id) {
        return UserDao.findById(id);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> addUser(@Validated @RequestBody UserDto userDto) {// replace Valid with Validated
        User userAdded = userService.createUser(userDto);
        return ResponseEntity.ok().body(userAdded);
    }

    @PutMapping("/profile")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.update(userDto);
    }

    @DeleteMapping("/profile/{id}")
    public void deleteUser(@PathVariable int id) {
        UserDao.deleteById(id);
    }
}
