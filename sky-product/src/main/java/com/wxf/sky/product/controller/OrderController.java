package com.wxf.sky.product.controller;

import com.wxf.sky.product.service.OrderService;
import com.wxf.sky.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wxf
 * @since 2024-07-28 20:38:53
 **/

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/list")
    public List<User> userList() {
        return orderService.userList();
    }
}
