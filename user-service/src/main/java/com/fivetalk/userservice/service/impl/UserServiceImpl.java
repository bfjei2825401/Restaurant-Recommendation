package com.fivetalk.userservice.service.impl;

import com.fivetalk.userservice.mapper.UserMapper;
import com.fivetalk.userservice.model.UserEntity;
import com.fivetalk.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> listUsers(int page, int size) {
        int limit = (page - 1) * size;
        return userMapper.getSomeUsers(limit, size);
    }

    @Override
    public UserEntity listUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public UserEntity listUserByUsernamePassword(String username, String password) {
        return userMapper.findUserByUsernamePassword(username, password);
    }
}
