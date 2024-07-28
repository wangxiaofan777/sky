package com.wxf.sky.user.client;

import com.wxf.sky.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 用户Feign客户端
 *
 * @author Wxf
 * @since 2024-07-28 19:47:49
 **/
@FeignClient(name = "user-provider", path = "/users")
public interface UserClient {

    List<User> userList();

    User getUserById(Long id);
}
