package com.fivetalk.userservice.service;

import com.fivetalk.userservice.model.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> listUsers(int page, int size);

    UserEntity listUserById(String id);

    UserEntity listUserByUsernamePassword(String username, String password);
}
