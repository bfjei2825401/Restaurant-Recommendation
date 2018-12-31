package com.fivetalk.userservice.controller;

import com.fivetalk.userservice.mapper.UserMapper;
import com.fivetalk.userservice.model.UserEntity;
import com.fivetalk.userservice.service.UserService;
import com.fivetalk.userservice.util.ResponseMsg;
import com.fivetalk.userservice.util.ResponseUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserController {
    private Gson gson = new Gson();
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "username", required = true)String username,
                         @RequestParam(value = "password", required = true)String password) {
        UserEntity userEntity = userService.listUserByUsernamePassword(username, password);
        ResponseMsg responseMsg = checkUserEntity(userEntity);
        return gson.toJson(responseMsg);
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public String findUserById(@RequestParam(value = "id", required = true)String id) {
        UserEntity userEntity = userService.listUserById(id);
        ResponseMsg responseMsg = checkUserEntity(userEntity);
        return gson.toJson(responseMsg);
    }

    @RequestMapping(value = "/getSomeUsers", method = RequestMethod.GET)
    public String getSomeUsers(@RequestParam(value = "page", defaultValue = "1", required = true) int page,
                               @RequestParam(value = "size", defaultValue = "10", required = true) int size) {
        List<UserEntity> list = userService.listUsers(page, size);
        ResponseMsg responseMsg = ResponseUtil.success(list);
        return gson.toJson(responseMsg);
    }

    private ResponseMsg checkUserEntity(UserEntity userEntity) {
        ResponseMsg responseMsg;
        if (userEntity == null) {
            responseMsg = ResponseUtil.error(500, "failed", "");
        } else {
            responseMsg = ResponseUtil.success(userEntity);
        }
        return responseMsg;
    }
}
