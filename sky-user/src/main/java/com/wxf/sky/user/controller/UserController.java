package com.wxf.sky.user.controller;

import com.wxf.sky.user.client.UserClient;
import com.wxf.sky.user.feign.clients.UserClientImpl;
import com.wxf.sky.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private UserClientImpl userClient;

    @GetMapping("/list")
    public List<User> userList() {
        return userClient.userList();
    }
}
