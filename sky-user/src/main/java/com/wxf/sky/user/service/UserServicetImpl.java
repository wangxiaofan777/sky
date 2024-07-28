package com.wxf.sky.user.service;

import com.wxf.sky.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Wxf
 * @since 2024-07-28 19:57:10
 **/
@Slf4j
@Service
public class UserServicetImpl implements UserService {

    private static final List<User> USER_LIST = Arrays.asList(
            User.builder().id(1L).username("wxf").age(18).remark("hehe").build(),
            User.builder().id(2L).username("yc").age(38).remark("...").build()
    );


    @Override
    public List<User> userList() {
        return USER_LIST;
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        for (User u : USER_LIST) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }
        return user;
    }
}
