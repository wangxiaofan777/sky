package com.wxf.sky.product.service;

import com.wxf.sky.user.client.UserClient;
import com.wxf.sky.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author Wxf
 * @since 2024-07-28 20:39:24
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private UserClient userClient;

    @Override
    public List<User> userList() {
        return userClient.userList();
    }

    @Override
    public User getUserById(Long id) {
        return userClient.getUserById(id);
    }
}
