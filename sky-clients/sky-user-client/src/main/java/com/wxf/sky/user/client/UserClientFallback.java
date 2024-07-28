package com.wxf.sky.user.client;

import com.wxf.sky.user.model.User;

import java.util.Collections;
import java.util.List;

/**
 * @author Wxf
 * @since 2024-07-28 20:26:11
 **/
public class UserClientFallback implements UserClient{

    @Override
    public List<User> userList() {
        return Collections.emptyList();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }
}
