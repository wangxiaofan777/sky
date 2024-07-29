package com.wxf.sky.product.client;

import com.wxf.sky.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 用户Feign客户端
 *
 * @author Wxf
 * @since 2024-07-28 19:47:49
 **/
@FeignClient(
        value = "user-service",
//        url = "http://127.0.0.1:8090",
        path = "/users",
//        fallback = UserClientFallback.class,
        fallbackFactory = UserClientFallbackFactory.class
//        configuration = UserClientConfiguration.class
)
public interface UserClient {

    @GetMapping("/list")
    List<User> userList();

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Long id);
}
