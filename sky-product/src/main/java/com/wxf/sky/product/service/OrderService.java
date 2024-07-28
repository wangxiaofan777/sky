package com.wxf.sky.product.service;

import com.wxf.sky.user.model.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Wxf
 * @since 2024-07-28 20:39:14
 **/
public interface OrderService {


    List<User> userList();

    User getUserById(@PathVariable("id") Long id);
}
