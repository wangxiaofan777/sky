package com.wxf.sky;

import com.wxf.sky.entity.Segment;
import com.wxf.sky.service.IdGeneratorService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class IDGenerator {

    @Resource
    private IdGeneratorService idGeneratorService;

    private long currentId;
    private long maxId;
    private final Object lock = new Object();

    // 异步号段预分配标志
    private boolean isAllocating = false;

    // 从中心服务获取号段的接口
    private final String serviceUrl = "http://localhost:8080/id/nextSegment/";

    private String bizTag;

    /*public IDGenerator(String bizTag) {
        this.bizTag = bizTag;
        // 初始时申请第一个号段
        allocateSegment();
    }*/

    // 生成ID的接口
    public long getNextId() {
        synchronized (lock) {
            if (currentId >= maxId) {
                // 号段用完，重新申请新的号段
                allocateSegment();
            }
            // 提前申请下一个号段，避免耗尽时的性能影响
            if ((maxId - currentId) < 10 && !isAllocating) {
                isAllocating = true;
                new Thread(this::allocateSegment).start();
            }
            return currentId++;
        }
    }

    // 向中心服务申请号段
    private void allocateSegment() {
        try {
            // 使用RestTemplate来请求号段
//            RestTemplate restTemplate = new RestTemplate();
//            Segment segment = restTemplate.getForObject(serviceUrl + bizTag, Segment.class);
            Segment segment = idGeneratorService.getNextSegment("test");

            synchronized (lock) {
                this.currentId = segment.getStartId();
                this.maxId = segment.getEndId();
            }
            isAllocating = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
