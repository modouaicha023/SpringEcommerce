package com.ecommerce.microcommerce.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.microcommerce.dto.UserDto;
import com.ecommerce.microcommerce.model.User;
import com.ecommerce.microcommerce.service.UserService;
import com.ecommerce.microcommerce.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao UserDao;

    @Override
    public User createUser(UserDto UserDto) {
        User user = new User();
        user.setFirstName(UserDto.getFirstName());
        user.setLastName(UserDto.getLastName());
        user.setUsername(UserDto.getUsername());
        user.setPassword(UserDto.getPassword());
        user.setProducts(null);
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
}
