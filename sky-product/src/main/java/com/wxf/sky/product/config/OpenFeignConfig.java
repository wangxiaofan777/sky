package com.wxf.sky.product.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wxf
 * @since 2024-07-29 09:47:20
 **/

@Configuration
public class OpenFeignConfig {

    @Bean
    Logger.Level logger() {
        return Logger.Level.FULL;
    }
}
