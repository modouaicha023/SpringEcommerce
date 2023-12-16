package com.ecommerce.microcommerce.service;

import com.ecommerce.microcommerce.dto.UserDto;
import com.ecommerce.microcommerce.model.User;

public interface UserService {

    User createUser(UserDto UserDto);

    void update(UserDto UserDto);
}