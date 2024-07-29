package com.wxf.sky.product.client;

import com.wxf.sky.user.model.User;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author Wxf
 * @since 2024-07-29 10:12:33
 **/
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable cause) {
        return new UserClient() {
            @Override
            public List<User> userList() {
                return Collections.singletonList(User.builder().username("nr").build());
            }

            @Override
            public User getUserById(Long id) {
                return User.builder().username("nr").build();
            }
        };
    }
}
