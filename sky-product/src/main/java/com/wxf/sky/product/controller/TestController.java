package com.wxf.sky.product.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Controller
 *
 * @author Wxf
 * @since 2024-07-29 13:55:52
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    @SentinelResource(value = "test", blockHandler = "testFallback")
    public String test() {
        return "test successful";
    }

    // 方法是否私有不影响
    private String testFallback(BlockException e) {
        e.printStackTrace();
        return "test failed";
    }
}
