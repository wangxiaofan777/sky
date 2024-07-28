package com.wxf.sky.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户Service
 * @author Wxf
 * @since 2024-07-28 19:38:22
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(
        scanBasePackages = "com.wxf.sky"
)
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
