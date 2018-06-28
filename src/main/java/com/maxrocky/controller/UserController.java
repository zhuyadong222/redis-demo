package com.maxrocky.controller;

import com.maxrocky.dto.User;
import com.maxrocky.repository.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yado
 * @create 2018-04-17 9:41
 * @desc 使用redis注解，结合实体对象进行实体操作
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping(value = "/get/{id}")
    public User getUserById(@PathVariable Integer id){
        User user = userMapper.getUserById(id);
        return user;
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUserById(@PathVariable Integer id){
        userMapper.deleteUserById(id);
        return "SUCCESS";
    }

    @PutMapping(value = "/update")
    public String updateUser(@RequestBody User user){
        userMapper.updateUser(user);
        return "success";
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        Integer id = userMapper.saveUser(user);
        System.out.println(id);
        return "SUCCESS";
    }

}
