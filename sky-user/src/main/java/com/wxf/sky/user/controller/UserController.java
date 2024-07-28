package com.wxf.sky.user.controller;

import com.wxf.sky.user.model.User;
import com.wxf.sky.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wxf
 * @since 2024-07-28 20:14:27
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public List<User> userList() {
        return userService.userList();
    }


    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
