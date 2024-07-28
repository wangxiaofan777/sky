package com.wxf.sky.product;

import com.wxf.sky.product.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Wxf
 * @since 2024-07-28 20:44:52
 **/

@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Test
    void test() {
        System.out.println(orderService.userList());
    }
}
