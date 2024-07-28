package com.wxf.sky.user.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wxf
 * @since 2024-07-28 20:27:07
 **/
@Configuration
public class UserClientConfiguration {

    @Bean
    public UserClientFallback userClientFallback() {
        return new UserClientFallback();
    }
}
