package com.wxf.sky.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Wxf
 * @since 2024-08-10 15:34:12
 **/
@SpringBootApplication(
        scanBasePackages = {"com.wxf.sky.elasticsearch"}
)
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }
}
