package com.wxf.sky.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

/**
 * 产品Service
 *
 * @author Wxf
 * @since 2024-07-28 19:37:45
 **/
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = "com.wxf.sky"
)
public class ProductApplication implements CommandLineRunner {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("user-service");
//        String url = String.format("http://%s:%s/users/list", serviceInstance.getHost(), serviceInstance.getPort());
//        System.out.println(restTemplate.getForEntity(url, String.class));
        System.out.println(restTemplate.getForEntity("http://user-service/users/list", String.class));
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
