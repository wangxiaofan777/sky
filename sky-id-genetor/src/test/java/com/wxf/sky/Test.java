package com.wxf.sky;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Wxf
 * @since 2024-10-17 08:45:58
 **/
@SpringBootTest
public class Test {

    @Resource
    private IDGenerator idGenerator;

    @org.junit.jupiter.api.Test
    void test01() {
        for (int i = 0; i < 1000; i++) {
            long nextId = idGenerator.getNextId();
            System.out.println(String.format("%06d", nextId));
        }
    }
}
