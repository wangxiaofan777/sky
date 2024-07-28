package com.wxf.sky.user.service;

import com.wxf.sky.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Wxf
 * @since 2024-07-28 21:06:21
 **/
public interface UserService {


    @GetMapping("/list")
    List<User> userList();

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Long id);
}
