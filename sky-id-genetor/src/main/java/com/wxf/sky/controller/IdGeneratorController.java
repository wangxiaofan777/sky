package com.wxf.sky.controller;

import com.wxf.sky.entity.Segment;
import com.wxf.sky.service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/id")
public class IdGeneratorController {

    @Autowired
    private IdGeneratorService idGeneratorService;

    // 分布式节点请求号段时调用此接口
    @GetMapping("/nextSegment/{bizTag}")
    public Segment getNextSegment(@PathVariable String bizTag) {
        return idGeneratorService.getNextSegment(bizTag);
    }
}
