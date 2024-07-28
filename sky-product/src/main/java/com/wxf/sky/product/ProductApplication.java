package com.wxf.sky.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 产品Service
 *
 * @author Wxf
 * @since 2024-07-28 19:37:45
 **/
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.wxf.sky")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
